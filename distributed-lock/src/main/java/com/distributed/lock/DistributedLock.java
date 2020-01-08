package com.distributed.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributedLock {

    public static void main(String[] args) {
        SpringApplication.run(DistributedLock.class, args);
    }
}
