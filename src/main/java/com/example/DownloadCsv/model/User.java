package com.example.DownloadCsv.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class User {

    //List<String> header = {"id","name"","email"}
    @CsvBindByName(column = "id")
    private long id;
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "email")
    private String email;
    @CsvBindByName(column = "country")
    private String country;
    @CsvBindByName(column = "age")
    private int age;

}
