package bomnie.spring_mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// DispatcherServlet이 실행될 때 읽어들일 자바 config 설정파일
@Configuration
@EnableWebMvc
// Web에 필요한 bean들을 기본적으로 자동으로 설정
// 어떤 패키지에서 읽어들일지 basePackages를 지정
@ComponentScan(basePackages = {"bomnie.spring_mvc.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
	
	// DispatcherServlet이 모든 요청 수용 시(/), 각종 리소스 요청들에 대해 탐색할 곳을 설정 
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하도록 함.
	// 매핑정보가 없는 서블릿 -> WAS 의 default servlet 이 static 한 자원을 읽어서 보여주게 함.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
   
    // 특정 url에 대한 처리를 controller를 거치지 않고 매핑할 수 있도록 해줌
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("main");
    }
    
   // 뷰 정보 설정
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
