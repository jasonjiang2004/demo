package dubbo.demo.provider.service.impl;

import dubbo.demo.api.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Description: TODO
 * @author: Jason
 * @Date: 2019/8/20
 * @Copyright (C), 2018-2022
 */

@Service(version = "${echo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultDemoService implements DemoService {

    @Value("${spring.application.name}")
    private String serviceName ;

    @Override
    public String sayHello(String message) {
        //return "Echo" + message;
        System.out.println("I am Provider Service-----");
        return String.format("[%s] : Hello,%s",serviceName,message);
    }
}
