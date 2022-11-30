package com.example.DownloadCsv.controller;

import com.example.DownloadCsv.model.User;
import com.example.DownloadCsv.service.UserService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/export-users")
    public void exportCSV(HttpServletResponse response) throws Exception {

        //set file name and content type
        String filename = "users.csv";

        String[] header = {"name","id","email"};

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        ColumnPositionMappingStrategy<User> strat = new ColumnPositionMappingStrategy<>();
        strat.setType(User.class);
        String[] columns = header;// the fields to bind to in your bean
        strat.setColumnMapping(columns);

        //create a csv writer
        StatefulBeanToCsv<User> writer = new StatefulBeanToCsvBuilder<User>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withMappingStrategy(strat)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
       // writer.write(header);
        response.getWriter().write(String.join(",",header)+"\n");
        writer.write(userService.listUsers());

    }
}
