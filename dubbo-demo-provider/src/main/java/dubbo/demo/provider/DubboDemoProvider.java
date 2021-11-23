package dubbo.demo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description: TODO
 * @author: Jason
 * @Date: 2019/8/20
 * @Copyright (C), 2018-2022
 */

@EnableAutoConfiguration  //激活自动装配
@PropertySource("classpath:/application.properties") //扫描配置文件
public class DubboDemoProvider {

    public static void main(String[] args) {
        //SpringApplication.run(DubboDemoProvider.class,args);
        new SpringApplicationBuilder(DubboDemoProvider.class)
                //.web(WebApplicationType.NONE)
                .properties("dubbo.scan.basePackages= dubbo.demo.provider")
                .properties("management.endpoints.web.exposure.include = *")
                .run(args);
        System.out.println("My Provider application is running now!");
    }

}
