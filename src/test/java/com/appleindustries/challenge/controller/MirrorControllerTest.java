package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.MirrorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MirrorController.class)
class MirrorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MirrorService service;

    @ParameterizedTest
    @MethodSource("provideMyObject")
    void whenStringComesThenResultIsReversedString(String message, String expected) throws Exception {
        when(service.getReflectiveMessage(message)).thenReturn(expected);
        assertEquals(expected,
                mockMvc.perform(get("/api/mirror/" + message)).andReturn().getResponse().getContentAsString());
    }

    static Stream<Arguments> provideMyObject() {
        return Stream.of(
                arguments(new String("Hola mundo"), new String("mundo Hola")),
                arguments(new String("Mirror on the screen"), new String("screen the on Mirror"))
                );
    }
}