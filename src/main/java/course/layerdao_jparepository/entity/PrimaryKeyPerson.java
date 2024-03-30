package course.layerdao_jparepository.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;
import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@IdClass(Person.class)
public class PrimaryKeyPerson implements Serializable {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    @Getter
    @Setter
    private Integer age;
}
