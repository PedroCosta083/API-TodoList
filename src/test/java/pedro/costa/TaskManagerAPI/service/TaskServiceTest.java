package pedro.costa.TaskManagerAPI.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import pedro.costa.TaskManagerAPI.entities.TaskEntitie;
import pedro.costa.TaskManagerAPI.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        // Arrange
        TaskEntitie task = new TaskEntitie("pending", null, "high", "John Doe");

        // Act
        taskService.create(task);

        // Assert
        ArgumentCaptor<TaskEntitie> argumentCaptor = ArgumentCaptor.forClass(TaskEntitie.class);
        verify(taskRepository, times(1)).save(argumentCaptor.capture());
        TaskEntitie capturedTask = argumentCaptor.getValue();
        assertEquals(task, capturedTask);
    }

    @Test
    void testList() {
        // Arrange
        List<TaskEntitie> expectedTasks = new ArrayList<>();
        expectedTasks.add(new TaskEntitie("pending", null, "high", "John Doe"));
        when(taskRepository.findAll(any(Sort.class))).thenReturn(expectedTasks);

        // Act
        List<TaskEntitie> actualTasks = taskService.list();

        // Assert
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    void testUpdate() {
        // Arrange
        TaskEntitie task = new TaskEntitie("pending", null, "high", "John Doe");

        // Act
        taskService.update(task);

        // Assert
        ArgumentCaptor<TaskEntitie> argumentCaptor = ArgumentCaptor.forClass(TaskEntitie.class);
        verify(taskRepository, times(1)).save(argumentCaptor.capture());
        TaskEntitie capturedTask = argumentCaptor.getValue();
        assertEquals(task, capturedTask);
    }

    @Test
    void testDelete() {
        // Arrange
        Long taskId = 1L;

        // Act
        taskService.delete(taskId);

        // Assert
        verify(taskRepository, times(1)).deleteById(taskId);
    }

}