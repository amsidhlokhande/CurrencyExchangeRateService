package com.amsidh.mvc.config;

import com.amsidh.mvc.repositories.ExchangeRateRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {ExchangeRateRepository.class})
public class AppConfig {
}
