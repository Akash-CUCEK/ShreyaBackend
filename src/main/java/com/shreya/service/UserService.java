package com.shreya.service;

import com.shreya.dto.request.LogInRequestDTO;
import com.shreya.dto.request.RegisterRequestDTO;
import com.shreya.dto.response.LogInResponseDTO;
import com.shreya.dto.response.RegisterResponseDTO;

public interface UserService {
    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);

    LogInResponseDTO logInUser(LogInRequestDTO logInRequestDTO, String requestId);
}
