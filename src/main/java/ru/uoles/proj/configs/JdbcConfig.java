package ru.uoles.proj.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${spring.datasource.enable.local}")
    private boolean isEnableLocal;

    @Bean
    @ConfigurationProperties("spring.datasource.local")
    public DataSourceProperties localDataSourceProperties() {
        return new DataSourceProperties();
    }

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
        return isEnableLocal
                ? localDataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build()
                : masterDataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build();
    }

    @Bean
    public DataSource slave1DataSource() {
        return isEnableLocal
                ? localDataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build()
                : slave1DataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build();
    }

    @Bean
    public DataSource slave2DataSource() {
        return isEnableLocal
                ? localDataSourceProperties()
                    .initializeDataSourceBuilder()
                    .build()
                : slave2DataSourceProperties()
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
