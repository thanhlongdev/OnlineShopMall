package vn.thanhlong.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@Configuration
@PropertySource("classpath:application.properties")
public class DatabseConnectConfiguration {

    private Environment env;

    @Autowired
    public DatabseConnectConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public Connection getConnection() {
        try {
            log.info("Create connection");
            Connection con = this.createDataSource().getConnection();
            log.info("Created connection success");
            return con;
        } catch (Exception e) {
            log.info("Created connection exception: " + e.getMessage());
            throw new RuntimeException("Cant't init connection to db");
        }
    }

    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("database.classname"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.username"));
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager createTransaction() {
        return new DataSourceTransactionManager(createDataSource());
    }
}
