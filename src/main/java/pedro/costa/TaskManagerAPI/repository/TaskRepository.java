package pedro.costa.TaskManagerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.costa.TaskManagerAPI.entities.TaskEntitie;

public interface TaskRepository extends JpaRepository<TaskEntitie,Long> {

}
