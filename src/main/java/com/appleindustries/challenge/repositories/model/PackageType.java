package com.appleindustries.challenge.repositories.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "package_type")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class PackageType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    int price;
}
