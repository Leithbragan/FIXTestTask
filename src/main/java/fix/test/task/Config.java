package fix.test.task;


import fix.test.task.web.ChessServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.http.HttpServlet;

@Configuration
public class Config {
    @Bean
    public ServletRegistrationBean<HttpServlet> chessServlet(){
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new ChessServlet());
        bean.addUrlMappings("/horse/servlet/count");
        bean.setLoadOnStartup(1);
        return bean;
    }
}
