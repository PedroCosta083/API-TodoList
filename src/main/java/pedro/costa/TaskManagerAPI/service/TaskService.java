package pedro.costa.TaskManagerAPI.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;
import pedro.costa.TaskManagerAPI.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity>create(TaskEntity task){
        taskRepository.save(task);
        return list();
    }
    public List<TaskEntity>list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
       return taskRepository.findAll(sort);
    }
    public List<TaskEntity>update(TaskEntity task){
        taskRepository.save(task);
        return list();
    }
    public List<TaskEntity>delete(Long id){
        taskRepository.deleteById(id);
        return list();
    }

}
