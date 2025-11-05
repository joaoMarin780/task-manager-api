package com.joaomarin.demo.service;

import com.joaomarin.demo.model.Task;
import com.joaomarin.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repository;
    
    public List<Task> listarTodas() {
        return repository.findAll();
    }
    
    public Optional<Task> buscarPorId(Long id) {
        return repository.findById(id);
    }
    
    public Task criar(Task task) {
        return repository.save(task);
    }
    
    public Optional<Task> atualizar(Long id, Task taskAtualizada) {
        return repository.findById(id)
                .map(task -> {
                    if (taskAtualizada.getTitle() != null) {
                        task.setTitle(taskAtualizada.getTitle());
                    }
                    if (taskAtualizada.getDescription() != null) {
                        task.setDescription(taskAtualizada.getDescription());
                    }
                    if (taskAtualizada.getCompleted() != null) {
                        task.setCompleted(taskAtualizada.getCompleted());
                    }
                    return repository.save(task);
                });
    }
    
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}


