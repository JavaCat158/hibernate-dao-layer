package course.demorefactoringdaoexample.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String surname;

    @Getter
    @Setter
    int age;

    @Getter
    @Setter
    int phonenumber;

    @OneToMany
    private Set<Orders> orders;
}
