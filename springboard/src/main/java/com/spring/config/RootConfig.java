package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages= {"com.spring.config","com.spring.service"})
@MapperScan(basePackages= {"com.spring.mapper"})
@Transactional
public class RootConfig {
	
	@Value("${driver}")
	private String driver;
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikari=new HikariConfig();
		hikari.setDriverClassName(driver);
		hikari.setJdbcUrl(url);
		hikari.setUsername(user);
		hikari.setPassword(password);
		
		HikariDataSource dataSource=new HikariDataSource(hikari);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean factory() {
		SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		//factory.setMapperLocations(new Resource[] {new ClassPathResource("mapper/board.xml"), new ClassPathResource("mapper/member.xml"), new ClassPathResource("mapper/comment.xml")});
		return factory;
	}
	
	@Bean
	public DataSourceTransactionManager transaction(DataSource dataSource) {
		DataSourceTransactionManager transaction=new DataSourceTransactionManager();
		
		transaction.setDataSource(dataSource);
		
		return transaction;
	}
}
