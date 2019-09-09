package com.jtzh.szcj.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements WebMvcConfigurer {
	  
		@Override
		public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	            .allowedOrigins("*")
	            .allowCredentials(true)
	            .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS","OPTION")
	            .maxAge(3600);
		}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration  interceptorRegistration  =registry.addInterceptor(new LoginInterceptor());
		interceptorRegistration.addPathPatterns("/**");
		interceptorRegistration.excludePathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**", "/templates/**","/file/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/",
				ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/","file:D:/test/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController( "/" ).setViewName( "index" );
//		registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
//		WebMvcConfigurer.super.addViewControllers( registry );
//	}
}
