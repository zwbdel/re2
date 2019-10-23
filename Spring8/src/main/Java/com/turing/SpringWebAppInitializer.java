package com.turing;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.turing.config.RootConfig;
import com.turing.config.WebConfig;

/**
 * ��ʼ��SpringWebӦ�ã����г�ʼ��DispatcherServlet������������
 * @author fred
 *
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//ȫ��������
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	//����SpringMVC
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	//����ServletMapping
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}
