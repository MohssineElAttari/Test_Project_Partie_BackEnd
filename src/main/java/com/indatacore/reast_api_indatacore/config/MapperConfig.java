package com.indatacore.reast_api_indatacore.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MapperConfig {
    @SneakyThrows
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
