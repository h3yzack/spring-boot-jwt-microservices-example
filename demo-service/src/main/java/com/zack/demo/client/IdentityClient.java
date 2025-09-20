package com.zack.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zack.demo.config.FeignClientConfig;
import com.zack.example.common.dto.UserDto;

@FeignClient(
    name = "identity-service", 
    url = "${feign.client.identity-service.url}",
    configuration = FeignClientConfig.class)
public interface IdentityClient {

    @GetMapping("/users/me")
    UserDto getUser();
}
