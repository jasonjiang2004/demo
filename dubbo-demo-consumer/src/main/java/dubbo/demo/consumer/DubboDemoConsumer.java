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
 * @Copyright (C), 2018-2019, 南天电脑系统有限公司
 */

@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
@RestController
public class DubboDemoConsumer {

    @Reference(version = "${echo.service.version}",
               application = "${dubbo.application.id}",
               url = "dubbo://localhost:12345"
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

    }

}
