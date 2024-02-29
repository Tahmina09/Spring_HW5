package com.example.spring5.model;

import com.example.spring5.Enum.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Класс представление задачи
 */
@Data
@Entity
public class Task {
    /**
     * Идентификатор задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Описание задачи
     */
    private String description;

    /**
     * Статус задачи
     */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * Дата создания задачи
     */
    private LocalDateTime createDate;
}
