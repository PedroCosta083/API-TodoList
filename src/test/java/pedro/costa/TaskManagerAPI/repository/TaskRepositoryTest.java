package pedro.costa.TaskManagerAPI.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pedro.costa.TaskManagerAPI.entities.TaskEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSave() {
        // Arrange
        TaskEntity taskToSave = new TaskEntity();

        // Act
        TaskEntity savedTask = taskRepository.save(taskToSave);

        // Assert
        assertNotNull(savedTask);
        assertNotNull(savedTask.getId());
    }

    @Test
    void testFindById() {
        // Arrange
        TaskEntity taskToSave = new TaskEntity();
        TaskEntity savedTask = taskRepository.save(taskToSave);
        Long taskId = savedTask.getId();

        // Act
        Optional<TaskEntity> foundTask = taskRepository.findById(taskId);

        // Assert
        assertTrue(foundTask.isPresent());
        assertEquals(savedTask, foundTask.get());
    }

    @Test
    void testDeleteById() {
        // Arrange
        TaskEntity taskToSave = new TaskEntity();
        TaskEntity savedTask = taskRepository.save(taskToSave);
        Long taskId = savedTask.getId();

        // Act
        taskRepository.deleteById(taskId);

        // Assert

        assertFalse(taskRepository.findById(taskId).isPresent());
    }
}
