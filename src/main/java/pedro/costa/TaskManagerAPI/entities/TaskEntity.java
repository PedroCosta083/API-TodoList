package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@Data // Gera automaticamente getter, setter, equals(), hashCode() e toString()
@NoArgsConstructor // Gera um construtor sem argumentos
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public BaseEntity() {
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
