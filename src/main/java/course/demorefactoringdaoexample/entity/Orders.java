package course.demorefactoringdaoexample.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "customers_id", referencedColumnName = "id")
    private Customers customers_id;

    @Getter
    @Setter
    private String product_name;

    @Getter
    @Setter
    private int amount;
}
