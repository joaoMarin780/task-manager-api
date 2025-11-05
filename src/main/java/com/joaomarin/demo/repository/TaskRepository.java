package com.joaomarin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaomarin.demo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
