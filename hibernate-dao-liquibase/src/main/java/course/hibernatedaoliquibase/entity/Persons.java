package course.hibernatedaoliquibase.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@ToString
@IdClass(PersonsId.class)
@Entity
public class Persons {

    @Id
    @Getter
    @Setter
    private String name;

    @Id
    @Getter
    @Setter
    @Column(name = "surname")
    private String surName;

    @Id
    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    @Column(name = "phonenumber")
    private Long phoneNumber;

    @Getter
    @Setter
    @Column(name = "city_of_living")
    private String city;

    public Persons() {

    }
}
