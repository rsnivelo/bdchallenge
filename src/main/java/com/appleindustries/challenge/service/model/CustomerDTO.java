package com.appleindustries.challenge.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    @JsonProperty("name")
    String name;

    @JsonProperty("email")
    String email;
}
