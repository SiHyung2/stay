package com.example.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] { characterEncodingFilter };
	}
	
	
//	파일(사진) 업로드 관련 코드
//	여기 적힌 주소는 404 에러날 때 리소스의 img 폴더에 사진을 저장한다는 의미임
//	만약 사용자가 요청한 URL에 해당하는 핸들러가 없으면, 예외(오류)를 발생시켜서 바로 알 수 있게 한다. 
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement("C:\\Users\\it\\git\\stay3\\stay\\src\\main\\webapp\\resources\\img", 
						20971520, 
						41943040,
						20971520);
		
		registration.setMultipartConfig(multipartConfig);

	}

}
