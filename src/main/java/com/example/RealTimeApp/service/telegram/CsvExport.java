package com.example.RealTimeApp.service.telegram;

import com.example.RealTimeApp.entity.Task;
import com.example.RealTimeApp.repository.TaskRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class CsvExport {
    private static final Logger log = getLogger(CsvExport.class);

    private final TaskRepo repo;

    public CsvExport(TaskRepo repo) {
        this.repo = repo;
    }


    public void writeEmployeesToCsv(Writer writer) {

        List<Task> employees = repo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL)) {
            for (Task task : employees) {
                csvPrinter.printRecord(task.getName(), task.getDescription(), task.getDate());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
