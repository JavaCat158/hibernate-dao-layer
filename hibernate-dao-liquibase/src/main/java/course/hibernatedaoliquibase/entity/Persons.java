package course.hibernatedaoliquibase.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@ToString
@Entity
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    @Column(name = "phone_number", nullable = false)
    private int phonenumber;

    @Getter
    @Setter
    private String city_of_living;

    public Persons() {

    }
}
