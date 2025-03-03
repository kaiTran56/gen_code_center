package com.xfilter.tech.api;

import com.xfilter.tech.constants.CommonFunction;
import com.xfilter.tech.domains.BasedDomain;
import com.xfilter.tech.domains.HelloWorldDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWorldApi {
    @Value("${common.xfliter.tech.greeting}")
    private String greetingMsg;
    @GetMapping({"*","/world"})
    public ResponseEntity<BasedDomain<HelloWorldDomain>> greeting(){
        BasedDomain<HelloWorldDomain> helloWorldDomain = HelloWorldDomain.builder()
                .content(greetingMsg)
                .build();
        log.info("greeting|"+helloWorldDomain);
        return new ResponseEntity<>(helloWorldDomain, HttpStatus.OK);
    }
    @GetMapping("/adida")
    public ResponseEntity<BasedDomain<HelloWorldDomain>> prayAdida(){
        BasedDomain<HelloWorldDomain> helloWorldDomain = HelloWorldDomain.builder()
                .content(greetingMsg)
                .build();
        log.info("prayAdida|"+helloWorldDomain);
        System.out.println(CommonFunction.getGreetingConsole());
        return new ResponseEntity<>(helloWorldDomain, HttpStatus.OK);
    }
}
