package com.appleindustries.challenge.service.impl;

import com.appleindustries.challenge.service.MirrorService;
import org.springframework.stereotype.Service;

@Service
public class MirrorServiceImpl implements MirrorService {
    @Override
    public String getReflectiveMessage(String message) {
        String[] words = message.split(" ");
        StringBuilder reverseMessage = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reverseMessage.append(words[i]);
            if (i > 0) {
                reverseMessage.append(" ");
            }
        }
        return reverseMessage.toString();
    }
}
