package ru.uoles.proj.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 24.06.2022
 * Time: 21:57
 */
@Configuration
public class JdbcConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.main")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.search")
    public DataSourceProperties searchDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSource() {
        return mainDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public DataSource searchDataSource() {
        return searchDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate mainNamedParameterJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Bean
    public NamedParameterJdbcTemplate searchNamedParameterJdbcTemplate(@Qualifier("searchDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }
}
