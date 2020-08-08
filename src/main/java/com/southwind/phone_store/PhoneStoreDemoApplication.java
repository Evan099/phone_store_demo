package com.southwind.phone_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhoneStoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneStoreDemoApplication.class, args);
    }

}
