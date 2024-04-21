package pedro.costa.TaskManagerAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;
import pedro.costa.TaskManagerAPI.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<List<TaskEntity>> create(@RequestBody TaskEntity task) {
        List<TaskEntity> createdTask = taskService.create(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskEntity>> list() {
        List<TaskEntity> tasks = taskService.list();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<List<TaskEntity>> update(@RequestBody TaskEntity task) {
        List<TaskEntity> updatedTasks = taskService.update(task);
        return new ResponseEntity<>(updatedTasks, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<List<TaskEntity>> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   @ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error:"+ex.getMessage());
    }
}
