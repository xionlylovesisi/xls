package com.xlm.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ReactorApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(ReactorApplication.class, args);
        new Thread(new Reactor(8080)).start();
    }

}
