package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public BaseEntity(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = new Date();
        validate();
    }
    public void validate() {
        if (this.name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (this.description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }

        if (this.createdAt == null) {
            throw new IllegalArgumentException("CreatedAt date cannot be null");
        }
    }
}
