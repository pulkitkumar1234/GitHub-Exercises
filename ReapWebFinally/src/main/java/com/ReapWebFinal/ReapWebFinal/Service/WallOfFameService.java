package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.ZeroBadgeException;
import com.ReapWebFinal.ReapWebFinal.repository.WallOfFameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                    throw new ZeroBadgeException();
                employeeService.updateReceivedGold(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            } else if (wallOfFame.getBadgeType().equals("silver")) {
                updateSenderBadgesSuccessfully = employeeService.updateRemainingSilver(wallOfFame.getGiverId());
                if (!updateSenderBadgesSuccessfully)
                    throw new ZeroBadgeException();
                employeeService.updateReceivedSilver(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            } else {
                updateSenderBadgesSuccessfully = employeeService.updateRemainingBronze(wallOfFame.getGiverId());
                if (!updateSenderBadgesSuccessfully)
                    throw new ZeroBadgeException();
                employeeService.updateReceivedBronze(wallOfFame.getReceiverId());
                wallOfFameRepository.save(wallOfFame);
            }
            return 1;
        } catch (ZeroBadgeException e) {
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

   public List<WallOfFame> allBadgeTransactionOfEmployee(Integer id){
      return wallOfFameRepository.findAllById(id);


   }
}
