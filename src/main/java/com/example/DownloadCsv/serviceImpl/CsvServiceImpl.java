package com.example.DownloadCsv.serviceImpl;

import com.example.DownloadCsv.model.Employee;
import com.example.DownloadCsv.service.CsvService;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {
    public void downloadCsvFile(PrintWriter printWriter, List<Employee> employees) {
        printWriter.write("Id , Frc Owner , A&A Owner \n");
        for (Employee employee : employees){
            printWriter.write(employee.getId()+","+employee.getFirstName()+","+employee.getLastName()+"\n");
        }

    }
}
