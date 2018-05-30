package charity;

import charity.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration()
public class SpringBeansCustomBeansConfig extends WebMvcConfigurerAdapter{


    @Bean
    public UserService userService(){
        return new UserService();
    }
}
