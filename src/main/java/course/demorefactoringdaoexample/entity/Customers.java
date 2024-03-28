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
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private int phonenumber;

    @OneToMany
    private Set<Orders> orders;
}
