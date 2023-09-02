package com.appleindustries.challenge.service.model;

import com.appleindustries.challenge.repositories.model.OrderDetail;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderRequestDTO {

    @JsonProperty("customerId")
    String customerId;

    @JsonProperty("packageId")
    String packageId;
}
