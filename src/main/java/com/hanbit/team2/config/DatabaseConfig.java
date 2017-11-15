package com.hanbit.team2.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource); // enabletransaction을 쓰려면 있어야 된데;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource); // java sql로 datasoruce를 가져오겠다
		sqlSessionFactory.setConfigLocation(
				applicationContext.getResource("classpath:mybatis/mybatis-config.xml")); // mybatis경로
		sqlSessionFactory.setMapperLocations(
				applicationContext.getResources("classpath:mybatis/mappers/**/*.xml"));

		return sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) { // bean이 알아서 들어온다
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
