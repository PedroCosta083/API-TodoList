package pedro.costa.TaskManagerAPI.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pedro.costa.TaskManagerAPI.entities.TaskEntitie;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskRepositoryTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskEntitie task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        // Arrange
        TaskEntitie taskToSave = new TaskEntitie("pending", null, "high", "John Doe");
        when(taskRepository.save(taskToSave)).thenReturn(taskToSave);

        // Act
        TaskEntitie savedTask = taskRepository.save(taskToSave);

        // Assert
        assertNotNull(savedTask);
        assertEquals(taskToSave, savedTask);
    }

    @Test
    void testFindById() {
        // Arrange
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Act
        Optional<TaskEntitie> foundTask = taskRepository.findById(taskId);

        // Assert
        assertTrue(foundTask.isPresent());
        assertEquals(task, foundTask.get());
    }

    @Test
    void testDeleteById() {
        // Arrange
        Long taskId = 1L;

        // Act
        taskRepository.deleteById(taskId);

        // Assert
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}
