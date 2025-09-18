package com.zack.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zack.demo.config.FeignClientConfig;
import com.zack.example.common.dto.UserDto;

@FeignClient(
    name = "identity-service", 
    url = "${feign.client.identity-service.url}",
    configuration = FeignClientConfig.class)
public interface IdentityClient {

    @GetMapping("/auth/users/{username}")
    UserDto getUser(@PathVariable String username);
}
