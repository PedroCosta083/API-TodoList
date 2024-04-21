package pedro.costa.TaskManagerAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.costa.TaskManagerAPI.entities.UserEntitie;

public interface UserRepository extends JpaRepository<UserEntitie,Long> {

}
