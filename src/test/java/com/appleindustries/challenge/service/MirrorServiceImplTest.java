package com.appleindustries.challenge.service;

import com.appleindustries.challenge.service.impl.MirrorServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
class MirrorServiceImplTest {

    @InjectMocks
    MirrorServiceImpl mirrorService;

    @ParameterizedTest
    @MethodSource("provideMyObject")
    void getReflectiveMessage(String message, String expected) {
        assertEquals(expected, mirrorService.getReflectiveMessage(message));
    }

    static Stream<Arguments> provideMyObject() {
        return Stream.of(
                arguments(new String("Hola mundo"), new String("odnum aloH")),
                arguments(new String("Mirror on the screen"), new String("neercs eht no rorriM"))
        );
    }
}