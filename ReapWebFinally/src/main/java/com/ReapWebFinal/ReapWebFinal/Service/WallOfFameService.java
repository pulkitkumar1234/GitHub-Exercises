package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import com.ReapWebFinal.ReapWebFinal.repository.WallOfFameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallOfFameService {
    @Autowired
    WallOfFameRepository wallOfFameRepository;
    @Autowired
    EmployeeService employeeService;


    public int saveTransaction(WallOfFame wallOfFame) {

        boolean updateSenderBadgesSuccessfully;
        try {
            if (wallOfFame.getBadgeType().equals("gold")) {
                updateSenderBadgesSuccessfully = employeeService.updateRemainingGold(wallOfFame.getGiverId());

                if (!updateSenderBadgesSuccessfully)
                    throw new GeneralException();
                employeeService.updateReceivedGold(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            } else if (wallOfFame.getBadgeType().equals("silver")) {
                updateSenderBadgesSuccessfully = employeeService.updateRemainingSilver(wallOfFame.getGiverId());
                if (!updateSenderBadgesSuccessfully)
                    throw new GeneralException();
                employeeService.updateReceivedSilver(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            } else {
                updateSenderBadgesSuccessfully = employeeService.updateRemainingBronze(wallOfFame.getGiverId());
                if (!updateSenderBadgesSuccessfully)
                    throw new GeneralException();
                employeeService.updateReceivedBronze(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            }
            return 1;
        } catch (GeneralException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

   public List<WallOfFame> allReceivedBadgeTransactionOfEmployee(Integer id){
        return wallOfFameRepository.findAllByReceiverId(id);
   }

    public List<WallOfFame> allSharedBadgeTransactionOfEmployee(Integer id){
        return wallOfFameRepository.findAllByGiverId(id);
    }

    public List<WallOfFame> AllBadgeTransaction(){
        Iterable<WallOfFame> wallOfFames= wallOfFameRepository.findAll();
        List<WallOfFame> wallOfFames1=new ArrayList<>();
        for(WallOfFame w:wallOfFames){
            wallOfFames1.add(w);
            System.out.println(w);
        }
        return wallOfFames1;
    }

    public List<WallOfFame> allBadgeTransactionOfEmployeebyId(Integer id){
        return wallOfFameRepository.findAllById(id);
    }

   public List<WallOfFame> allBadgeTransactionOfEmployee(Integer id, Integer id2){
      return wallOfFameRepository.findAllByReceiverIdOrGiverId(id,id2);
   }
   public void deletewalloffame(Integer id){
        wallOfFameRepository.deleteById(id);
   }

   public  WallOfFame findwalloffame(Integer id) throws GeneralException {
        Optional<WallOfFame> wallOfFame= wallOfFameRepository.findById(id);
        WallOfFame wallOfFame1=wallOfFame.orElse(null);
        if(wallOfFame1==null)
        {
            throw new GeneralException();
        }
        return wallOfFame1;
   }

    public List<WallOfFame> getRecognitionsBetweenDates(String dateString) {
            LocalDate today = LocalDate.now();
            if (dateString.equals("today")){
                return wallOfFameRepository.findAllByGivenDateTimeBetween(today,today);
            }
            else if (dateString.equals("yesterday")){
                return wallOfFameRepository.findAllByGivenDateTimeBetween(today.minusDays(1),today);
            }
            else if (dateString.equals("last7")){
                return wallOfFameRepository.findAllByGivenDateTimeBetween(today.minusDays(7),today);
            }else {
                return wallOfFameRepository.findAllByGivenDateTimeBetween(today.minusDays(30),today);
            }
        }
    }

