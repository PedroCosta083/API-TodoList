package pedro.costa.TaskManagerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {

}
