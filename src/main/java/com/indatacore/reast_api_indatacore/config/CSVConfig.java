package com.indatacore.reast_api_indatacore.config;
import com.indatacore.reast_api_indatacore.dto.StudentResponse;
import com.indatacore.reast_api_indatacore.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class CSVConfig {
    private final StudentService studentService;

    @SneakyThrows
    @Bean
    List<StudentResponse> getDefaultRecords(){
        return studentService.getAndSaveStudentsFromCsv();
    }
}
