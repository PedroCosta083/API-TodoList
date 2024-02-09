package pedro.costa.TaskManagerAPI.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pedro.costa.TaskManagerAPI.entities.UserEntitie;
import pedro.costa.TaskManagerAPI.repository.TaskRepository;
import pedro.costa.TaskManagerAPI.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntitie> create(UserEntitie user){
        userRepository.save(user);
        return list();
    }
    public List<UserEntitie>list(){
        Sort sort = Sort.by("login").descending().and(Sort.by("name").ascending());
        return userRepository.findAll(sort);
    }
    public List<UserEntitie>update(UserEntitie user){
        userRepository.save(user);
        return list();
    }
    public List<UserEntitie>delete(Long id){
        userRepository.deleteById(id);
        return list();
    }
}
