package ru.uoles.proj.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//TODO Сделать менеджер для создания NamedParameterJdbcTemplate для разных реплик.
//TODO Настройки подключения добавлять списком <master|slave, spring.datasource>
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
    @ConfigurationProperties("spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSourceProperties slave1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSourceProperties slave2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource masterDataSource() {
        System.out.println("----- Master DB url: " + masterDataSourceProperties().getUrl());
        return masterDataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build();
    }

    @Bean
    public DataSource slave1DataSource() {
        System.out.println("----- Slave 1 DB url: " + slave1DataSourceProperties().getUrl());
        return slave1DataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build();
    }

    @Bean
    public DataSource slave2DataSource() {
        System.out.println("----- Slave 2 DB url: " + slave2DataSourceProperties().getUrl());
        return slave2DataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build();
    }

    @Bean
    public NamedParameterJdbcTemplate masterNamedParameterJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Bean
    public NamedParameterJdbcTemplate slave1NamedParameterJdbcTemplate(@Qualifier("slave1DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Bean
    public NamedParameterJdbcTemplate slave2NamedParameterJdbcTemplate(@Qualifier("slave1DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource));
    }
}
