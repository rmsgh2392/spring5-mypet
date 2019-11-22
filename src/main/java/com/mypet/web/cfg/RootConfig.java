package com.mypet.web.cfg;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages= {"com.mypet.web"})
@ComponentScan(basePackages= {"com.mypet.web"})
//@Import({ServletConfig.class, MyBatisConfig.class}) 에러먹으면 이렇게 임포트 시켜준다
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikarConfig = new HikariConfig();
		hikarConfig.setDriverClassName("org.mariadb.jdbc.Driver");
		hikarConfig.setJdbcUrl("jdbc:mariadb://172.168.0.150:3306/mypet");
		hikarConfig.setUsername("catdog");
		hikarConfig.setPassword("catdog");
		HikariDataSource dataSource = new HikariDataSource(hikarConfig);
		return dataSource;
	}
	@Bean
	public DataSourceTransactionManager txManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}
