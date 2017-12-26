package springboot;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot应用启动类
 *
 */
@RestController
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }
	
	@RequestMapping("/now")
    String hehe() {
        return "现在时间：" + (new Date()).toLocaleString();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
