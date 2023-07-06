package com.example.multipledatasource.configdb;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2EntityManagerFactory",
        transactionManagerRef = "db2TransactionManager",
        basePackages = {
                "com.example.multipledatasource.db2.repository"
        }
)
public class Db2Config {
    @Primary
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "db2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("db2DataSource") DataSource dataSource
    ){
        return builder.dataSource(dataSource)
                .packages("com.example.multipledatasource.db2.entity")
                .build();
    }
    @Primary
    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
