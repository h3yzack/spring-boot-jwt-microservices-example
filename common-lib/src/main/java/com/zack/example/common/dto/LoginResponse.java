package com.zack.example.common.dto;

import java.util.List;

public record LoginResponse(String token, List<String> roles) {}