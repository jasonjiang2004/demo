package dubbo.demo.consumer;

import dubbo.demo.api.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @author: Jason
 * @Date: 2019/8/20
 * @Copyright (C), 2018-2022
 */

@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
@RestController
public class DubboDemoConsumer {

    /**
     * "dubbo://192.168.0.165:12345?version=1.0.0" 需要增加version=1.0.0，否则在服务调用时找不服务。2021-11-23
     */
    @Reference(version = "${echo.service.version}",
               application = "${dubbo.application.id}",
               url = "dubbo://192.168.0.165:12345?version=1.0.0"
    )
    private DemoService demoService ;

    @GetMapping
    public String echo(@RequestParam String message){
        String response = demoService.sayHello(message);
        System.out.println("I am Consumer !!!!!");
        return response ;
    }

    public static void main(String[] args) {
        SpringApplication
                .run(DubboDemoConsumer.class,args);
        System.out.println("My Consumer application is running now !!");

    }

}
