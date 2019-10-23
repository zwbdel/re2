package com.turing.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ȫ�������� ɨ����Ŀ�����а���������Ҫ��SpringMVC�Ѿ�ɨ����������
 * 
 * @author fred
 *
 */

@Configuration
@ComponentScan(basePackages = "com.turing", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = { EnableWebMvc.class, Controller.class }) })
@MapperScan(basePackages = "com.turing.mapper") // ɨ��Mapper���ڰ�
@ImportResource("classpath:spring-transaction.xml") // ��������������ļ�
public class RootConfig {

	// ��������Դ
	// ��������Դ
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// ������Ҫ��
		dataSource.setUrl("jdbc:mysql:///java16");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		// ���ӳص�һЩ����
		dataSource.setInitialSize(20);// ��ʼ������
		dataSource.setMaxIdle(10);// ���������
		dataSource.setMinIdle(2);// ��С������
		dataSource.setMaxTotal(50);// ���������
		dataSource.setMaxWaitMillis(5000);// ������ӵȴ�ʱ��
		return dataSource;
	}

	/**
	 * ����SQLSessionFactory����ʵ������֮ǰ��mybatis-config.xml
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		// ��������Դ
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	// �������������
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
