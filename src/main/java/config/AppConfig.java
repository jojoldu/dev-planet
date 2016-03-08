package config;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by jojoldu@gmail.com on 2016-03-08.
 */
@Configuration
public class AppConfig {

    @Autowired
    DataSourceProperties dataSourceProperties;

    DataSource dataSource;

    @Bean
    DataSource realDataSource(){
        this.dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();

        return dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource(){
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}
