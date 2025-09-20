package com.zack.example.common.dto;

import java.util.List;

public record UserDto(String username, List<String> roles) {}
