package com.appleindustries.challenge.service.model;

import com.appleindustries.challenge.repositories.model.OrderDetail;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderResponseDTO {

    String id;

    LocalDate creationDate;

    Double total;

    List<OrderDetailDTO> orderDetailList;
}
