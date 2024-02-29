package com.example.spring5.controllers;

import com.example.spring5.model.Task;
import com.example.spring5.Enum.TaskStatus;
import com.example.spring5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Контроллер для управления задачами
 */

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private TaskRepository repository;

    /**
     * Метод добавление задачи
     * @param task Новая задача
     * @return добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreateDate(LocalDateTime.now());
        task.setStatus(TaskStatus.NOT_STARTED);
        return repository.save(task);
    }

    /**
     * Метод получение списка всех задач
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Метод получение списка задач по статусу
     * @param status статус задачи
     * @return список задач с указаным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return repository.getTaskByStatus(status);
    }

    /**
     * Метод обновления статуса задачи
     * @param id идентификатор задачи для обновления
     * @param task задача
     * @return обновленная задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, Task task) {
        Task existingTask = repository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setStatus(task.getStatus());
            return repository.save(existingTask);
        } else {
            return null;
        }
    }

    /**
     * Метод удаления задачи по идентификатору
     * @param id идентификатор задачи для удаления
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
