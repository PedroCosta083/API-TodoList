package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Tasks")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaskEntity extends BaseEntity {
    @Getter
    @Setter
    private String status;
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date dueDate;
    @Getter
    @Setter
    private String priority;
    @Getter
    @Setter
    private String responsible;

    public TaskEntity(String name, String description, String status, Date dueDate, String priority, String responsible) {
        super(name, description);
        this.setStatus(status);
        this.setDueDate(dueDate);
        this.setPriority(priority);
        this.setResponsible(responsible);
        this.validate();
    }



    @Override
    public void validate() {
        super.validate();
        if (this.status == null || this.status.isEmpty()) {
            throw new IllegalArgumentException("Status is null or empty");
        }

        if (this.dueDate == null) {
            throw new IllegalArgumentException("Due date is required");
        }

        if (this.priority == null || priority.isEmpty()) {
            throw new IllegalArgumentException("Priority is required");
        }

        if (this.responsible == null) {
            throw new IllegalArgumentException("Responsible is required");
        }

        if (this.dueDate.before(super.getCreatedAt())) {
            throw new IllegalArgumentException("Due date cannot be before creation date");
        }
    }
}
