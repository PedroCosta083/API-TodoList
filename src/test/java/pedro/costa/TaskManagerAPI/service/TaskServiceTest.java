package pedro.costa.TaskManagerAPI.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;
import pedro.costa.TaskManagerAPI.repository.TaskRepository;

import java.util.ArrayList;
import java.util.Date;
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
        TaskEntity task = new TaskEntity();

        // Act
        taskService.create(task);

        // Assert
        ArgumentCaptor<TaskEntity> argumentCaptor = ArgumentCaptor.forClass(TaskEntity.class);
        verify(taskRepository, times(1)).save(argumentCaptor.capture());
        TaskEntity capturedTask = argumentCaptor.getValue();
        assertEquals(task, capturedTask);
    }

    @Test
    void testList() {
        // Arrange
        List<TaskEntity> expectedTasks = new ArrayList<>();
        expectedTasks.add(new TaskEntity());
        when(taskRepository.findAll(any(Sort.class))).thenReturn(expectedTasks);

        // Act
        List<TaskEntity> actualTasks = taskService.list();

        // Assert
        assertEquals(expectedTasks, actualTasks);
    }

    @Test
    void testUpdate() {
        // Arrange
        TaskEntity task = new TaskEntity();

        // Act
        taskService.update(task);

        // Assert
        ArgumentCaptor<TaskEntity> argumentCaptor = ArgumentCaptor.forClass(TaskEntity.class);
        verify(taskRepository, times(1)).save(argumentCaptor.capture());
        TaskEntity capturedTask = argumentCaptor.getValue();
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