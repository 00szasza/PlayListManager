package com.szasza.configuration;

import com.szasza.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by szasza on 2016. 02. 14..
 */

@Configuration
public class AppConfig {

    @Bean
    public FilesRepository availableFilesRepository()
    {
        return new FilesRepositoryImpl();
    }

    @Bean
    public FilesRepository releasedFilesRepository()
    {
      return new FilesRepositoryImpl();
    }

    @Bean
    public FilesRepository deletedFilesRepository()
    {
       return new FilesRepositoryImpl();
    }
}
