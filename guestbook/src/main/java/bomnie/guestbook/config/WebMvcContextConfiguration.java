package bomnie.guestbook.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import bomnie.guestbook.argumentresolver.HeaderMapArgumentResolver;
import bomnie.guestbook.interceptor.LogInterceptor;

@Configuration
@EnableWebMvc
// Web에 필요한 bean들을 대부분 자동으로 설정
@ComponentScan(basePackages = { "bomnie.guestbook.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    
    // default servlet handler를 사용하도록
    @Override
    // 매핑 정보가 없는 url정보가 들어왔을 때 DefaultServletHttpReqeustHandler가 처리하도록
    // WAS의 default servlet이 static한 자원을 읽어서 보여줄 수 있게끔 해주는 설정 포함
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    
    @Override
    // 특정 url에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("index");
    }
    
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    
    // 인터셉터 등록
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 인터셉터 객체를 생성하여 인자로 넣어준다 
		registry.addInterceptor(new LogInterceptor());
	}
    

    // Argument Resolver 등록
    @Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    		System.out.println("Argument Resolver 등록!");
		argumentResolvers.add(new HeaderMapArgumentResolver());
	}
    
    
    // DispathcerServlet 은 준비 과정에서 "multipart/form-data"가 요청으로 올 경우 MultipartResolver를 사용
    // DispathcerServlet 에게 멀티파트 요청이 올 경우 파일 업로드 처리가 될 수 있도록 MultipartResolver 객체 등록
    @Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760); // 1024 * 1024 * 10 // 최대 10Mb 크기의 파일이 저장되도록 설정 
        return multipartResolver;
    }
    
    
}
 