package com.turing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * SpringMVC��������
 * @author fred
 *
 */

@Configuration //��ʶһ��������
@ComponentScan(basePackages = {"com.turing.controller"}) //ɨ��ָ���İ��У������������ע���
@EnableWebMvc //����SpringMVCע��
public class WebConfig extends WebMvcConfigurerAdapter{

	//������ͼ������
	@Bean
	public ViewResolver viewResolver() {
		//������ͼ��������������ǰ׺�ͺ�׺
		InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/jsp/",".jsp");
        //����bean������������Ҳ���Է���
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	//������̬��Դ�ķ���
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//����
		configurer.enable();
	}
}
