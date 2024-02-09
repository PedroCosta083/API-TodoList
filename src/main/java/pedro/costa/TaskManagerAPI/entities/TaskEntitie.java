package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "Tasks")
public class TaskEntitie extends BaseEntitie {
//  private CategoryEntitie category;
private String status;
private Date dueDate;
private String priority;
private String responsible;

public TaskEntitie(String status, Date dueDate, String priority, String responsible) {
    super();
    this.status = status;
    this.dueDate = dueDate;
    this.priority = priority;
    this.responsible = responsible;
}

//    public CategoryEntitie getCategory() {
//return category;
//   }

//   public void setCategory(CategoryEntitie category) {
//this.category = category;
//  }

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public Date getDueDate() {
    return dueDate;
}

public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
}

public String getPriority() {
    return priority;
}

public void setPriority(String priority) {
    this.priority = priority;
}

public String getResponsible() {
    return responsible;
}

public void setResponsible(String responsible) {
    this.responsible = responsible;
}

@Override
public void validate() {
    super.validate();

  //  if (category == null) {
  //      throw new IllegalArgumentException("Category is required");
  //  }

    if (status == null || status.isEmpty()) {
        throw new IllegalArgumentException("Status is required");
    }

    if (dueDate == null) {
        throw new IllegalArgumentException("Due date is required");
    }

    if (priority == null || priority.isEmpty()) {
        throw new IllegalArgumentException("Priority is required");
    }

    if (responsible == null) {
        throw new IllegalArgumentException("Responsible is required");
   }

    if (dueDate.before(getCreateAt())) {
        throw new IllegalArgumentException("Due date cannot be before creation date");
    }

    if (dueDate.after(getDeactivateAt())) {
        throw new IllegalArgumentException("Due date cannot be after deactivation date");
    }
}
}
