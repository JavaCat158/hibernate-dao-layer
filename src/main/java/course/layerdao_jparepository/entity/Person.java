package course.layerdao_jparepository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persons")
@ToString
@EqualsAndHashCode
public class Person {
    @Getter
    @Setter
    @EmbeddedId
    private PrimaryKeyPerson id;

    @Getter
    @Setter
    @Column(name = "phonenumber")
    private int phone_number;

    @Getter
    @Setter
    @Column(name = "city_of_living")
    private String city;
}
