package cn.com.djin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *   项目的启动类
 */
@SpringBootApplication(scanBasePackages = "cn.com.djin.springboot.*")  //项目启动注解 // same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("cn.com.djin.springboot.mapper")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        //关闭热部署
       // System.setProperty("spring.devtools.restart.enabled", "false");
        //启动此项目
        SpringApplication.run(Application.class, args);

    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
