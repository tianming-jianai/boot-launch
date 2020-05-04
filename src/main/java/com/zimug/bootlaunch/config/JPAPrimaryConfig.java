package com.zimug.bootlaunch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-03 21:31
 * @since 0.1.0
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.zimug.bootlaunch.dao.testdb",
        entityManagerFactoryRef = "entityManagerFactoryBeanOne",
        transactionManagerRef = "platformTransactionManagerOne")
public class JPAPrimaryConfig {
    @Resource(name = "primaryDataSource")
    DataSource primaryDataSource;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBeanOne(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(primaryDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.zimug.bootlaunch.dao.testdb")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerOne(
            EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryOne
                = entityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(factoryOne.getObject());
    }
}
