package com.example.DownloadCsv.service;

import com.example.DownloadCsv.model.Employee;

import java.io.PrintWriter;
import java.util.List;

public interface CsvService {
    public void downloadCsvFile(PrintWriter printWriter , List<Employee> employees);
}
