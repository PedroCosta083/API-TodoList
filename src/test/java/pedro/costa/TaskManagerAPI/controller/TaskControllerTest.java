package pedro.costa.TaskManagerAPI.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;
import pedro.costa.TaskManagerAPI.service.TaskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TaskControllerTest {
    @Mock
    TaskService taskService;

    @InjectMocks
    TaskController taskController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateTask() {
        // Arrange
        TaskEntity task = new TaskEntity();
        when(taskService.create(task)).thenReturn(List.of(task));

        // Act
        ResponseEntity<List<TaskEntity>> responseEntity = taskController.create(task);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(List.of(task), responseEntity.getBody());
    }

    @Test
    void testListTasks() {
        // Arrange
        List<TaskEntity> expectedTasks = new ArrayList<>();
        expectedTasks.add(new TaskEntity());
        when(taskService.list()).thenReturn(expectedTasks);

        // Act
        ResponseEntity<List<TaskEntity>> responseEntity = taskController.list();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTasks, responseEntity.getBody());
    }

    @Test
    public void testUpdateTask() {
        List<TaskEntity> updatedTasks = new ArrayList<>();

        when(taskService.update(any(TaskEntity.class))).thenReturn(updatedTasks);

        ResponseEntity<List<TaskEntity>> responseEntity = taskController.update(new TaskEntity());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(updatedTasks, responseEntity.getBody());
    }

    @Test
    void testDeleteTask() {
        // Arrange
        Long taskId = 1L;

        // Act
        ResponseEntity<List<TaskEntity>> responseEntity = taskController.delete(taskId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(taskService, times(1)).delete(taskId);
    }
}
