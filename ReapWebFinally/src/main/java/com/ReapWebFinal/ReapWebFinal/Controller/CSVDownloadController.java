package com.ReapWebFinal.ReapWebFinal.Controller;

import com.ReapWebFinal.ReapWebFinal.Service.WallOfFameService;
import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import com.ReapWebFinal.ReapWebFinal.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

    @Controller
    public class CSVDownloadController {

        @Autowired
        WallOfFameService wallOfFameService;

        @GetMapping("/downloadCSV/{date}")
        public void downloadCSV(@PathVariable("date") String dateString,
                                HttpServletRequest request,
                                HttpServletResponse response) throws IOException{
            System.out.println("Downloading CSV for: "+dateString);
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("employee");

            if (employee == null){
                throw new UserNotFoundException("Unauthorized user");
            }

            String csvFileName = "reap-recognitions-"+dateString+".csv";

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"",csvFileName);
            response.setHeader(headerKey, headerValue);
            response.setContentType("text/csv");

            List<WallOfFame> wallOfFamelist = wallOfFameService.getRecognitionsBetweenDates(dateString);

            ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.EXCEL_PREFERENCE);

            String[] header = {"id", "giverName", "receiverName", "giverId", "receiverId",
                    "karma", "badgeType", "givenDateTime"};

            csvBeanWriter.writeHeader(header);
            for (WallOfFame wallOfFame : wallOfFamelist){
                csvBeanWriter.write(wallOfFame, header);
            }
            csvBeanWriter.close();
        }
    }


