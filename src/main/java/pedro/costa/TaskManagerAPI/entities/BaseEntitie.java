package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.*;

import java.util.Date;
@MappedSuperclass
public class BaseEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deactivateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getDeactivateAt() {
        return deactivateAt;
    }

    public void setDeactivateAt(Date deactivateAt) {
        this.deactivateAt = deactivateAt;
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

        if (updateAt == null) {
            throw new IllegalArgumentException("UpdateAt date cannot be null");
        }

        if (deactivateAt == null) {
            throw new IllegalArgumentException("DeactivateAt date cannot be null");
        }

        // Verifica se as datas foram inicializadas corretamente
        Date now = new Date();
        if (createAt.after(now)) {
            throw new IllegalArgumentException("CreateAt date cannot be in the future");
        }

        if (updateAt.after(now)) {
            throw new IllegalArgumentException("UpdateAt date cannot be in the future");
        }

        if (deactivateAt.after(now)) {
            throw new IllegalArgumentException("DeactivateAt date cannot be in the future");
        }

        if (deactivateAt.before(createAt)) {
            throw new IllegalArgumentException("DeactivateAt date cannot be before CreateAt date");
        }

        if (deactivateAt.before(updateAt)) {
            throw new IllegalArgumentException("DeactivateAt date cannot be before UpdateAt date");
        }
    }
}
