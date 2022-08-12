package com.example.RealTimeApp.controller;

import com.example.RealTimeApp.service.telegram.CsvExport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TaskController {

    private final CsvExport csvExportService;

    public TaskController(CsvExport csvExportService) {
        this.csvExportService = csvExportService;
    }

    @RequestMapping(path = "/tasks")
    public void getAllTasksInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"task.csv\"");
        csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
    }


}