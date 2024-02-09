package pedro.costa.TaskManagerAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.costa.TaskManagerAPI.entities.TaskEntitie;
import pedro.costa.TaskManagerAPI.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<List<TaskEntitie>> create(@RequestBody TaskEntitie task) {
        List<TaskEntitie> createdTask = taskService.create(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskEntitie>> list() {
        List<TaskEntitie> tasks = taskService.list();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<TaskEntitie>> update(@RequestBody TaskEntitie task) {
        List<TaskEntitie> updatedTasks = taskService.update(task);
        return new ResponseEntity<>(updatedTasks, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<List<TaskEntitie>> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
