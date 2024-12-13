package com.springboot.web.dto;

import com.springboot.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void lombok_test() {

        String name = "test";
        int amount = 10000;

        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        assertEquals(helloResponseDto.getName(), name);
        assertEquals(helloResponseDto.getAmount(), amount);

    }

}