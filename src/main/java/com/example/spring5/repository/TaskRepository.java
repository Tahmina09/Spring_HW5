package com.example.spring5.repository;

import com.example.spring5.model.Task;
import com.example.spring5.Enum.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Репозиторий для работы с задачами
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * Получение списка задач по статусу
     * @param status статус задач
     * @return список задач по определленому статусу
     */
    List<Task> getTaskByStatus(TaskStatus status);
}
