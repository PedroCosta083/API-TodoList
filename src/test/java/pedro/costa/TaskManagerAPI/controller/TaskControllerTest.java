package pedro.costa.TaskManagerAPI.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pedro.costa.TaskManagerAPI.entities.TaskEntitie;
import pedro.costa.TaskManagerAPI.service.TaskService;

import java.util.ArrayList;
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
        TaskEntitie task = new TaskEntitie("pending", null, "high", "John Doe");
        when(taskService.create(task)).thenReturn(List.of(task));

        // Act
        ResponseEntity<List<TaskEntitie>> responseEntity = taskController.create(task);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(List.of(task), responseEntity.getBody());
    }

    @Test
    void testListTasks() {
        // Arrange
        List<TaskEntitie> expectedTasks = new ArrayList<>();
        expectedTasks.add(new TaskEntitie("pending", null, "high", "John Doe"));
        when(taskService.list()).thenReturn(expectedTasks);

        // Act
        ResponseEntity<List<TaskEntitie>> responseEntity = taskController.list();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedTasks, responseEntity.getBody());
    }

    @Test
    public void testUpdateTask() {
        List<TaskEntitie> updatedTasks = new ArrayList<>();

        when(taskService.update(any(TaskEntitie.class))).thenReturn(updatedTasks);

        ResponseEntity<List<TaskEntitie>> responseEntity = taskController.update(new TaskEntitie("pending", null, "high", "John Doe"));

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(updatedTasks, responseEntity.getBody());
    }

    @Test
    void testDeleteTask() {
        // Arrange
        Long taskId = 1L;

        // Act
        ResponseEntity<List<TaskEntitie>> responseEntity = taskController.delete(taskId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(taskService, times(1)).delete(taskId);
    }
}
