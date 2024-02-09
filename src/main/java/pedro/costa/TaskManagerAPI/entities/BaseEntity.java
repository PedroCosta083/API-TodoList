package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@MappedSuperclass
@Data // Gera automaticamente getter, setter, equals(), hashCode() e toString()
@AllArgsConstructor // Gera um construtor com todos os argumentos
public class BaseEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public BaseEntitie() {
        validate();
    }

    public void validate() {
        if (id == null) {
            throw new IllegalArgumentException("ID is required");
        }

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }

        if (createAt == null) {
            throw new IllegalArgumentException("CreateAt date cannot be null");
        }
    }
}
