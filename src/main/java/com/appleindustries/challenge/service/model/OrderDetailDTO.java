package com.appleindustries.challenge.service.model;

import com.appleindustries.challenge.repositories.model.PackageType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {


    String id;

    PackageType photoPackage;
}
