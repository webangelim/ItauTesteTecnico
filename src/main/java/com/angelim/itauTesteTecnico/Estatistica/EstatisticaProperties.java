package com.angelim.itauTesteTecnico.Estatistica;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties (
        @NotNull
        @Positive
        Integer segundos) {
    @Configuration
    @EnableConfigurationProperties(EstatisticaProperties.class)
    public static class Config {
    }
}
