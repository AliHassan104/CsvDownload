package com.example.DownloadCsv.controller;


import com.example.DownloadCsv.model.Employee;
import com.example.DownloadCsv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DownloadController {
    @Autowired
    private CsvService csvService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/download/implementation.csv")
    public void downloadCvsFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment; file=frc-implementation.csv");
        csvService.downloadCsvFile(response.getWriter() , createDataTest());
    }

    private List<Employee> createDataTest(){
        List<Employee> data = new ArrayList<>();
        data.add(new Employee(1L,"Shezad","Iqbal"));
        data.add(new Employee(2L,"Shiva","Anaand"));
        data.add(new Employee(3L,"Ali","Hassan"));
        return data;
    }
}
