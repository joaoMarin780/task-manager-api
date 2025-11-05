package com.joaomarin.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaomarin.demo.model.Task;
import com.joaomarin.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    // Listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Task>> listarTodas() {
        List<Task> tasks = taskService.listarTodas();
        return ResponseEntity.ok(tasks);
    }
    
    // Buscar tarefa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        return taskService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Criar nova tarefa
    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Task task) {
        taskService.criar(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa criada com sucesso!");
    }
    
    // Atualizar tarefa
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Task taskAtualizada) {
        return taskService.atualizar(id, taskAtualizada)
                .map(task -> ResponseEntity.ok("Tarefa atualizada!"))
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Deletar tarefa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (taskService.deletar(id)) {
            return ResponseEntity.ok("Tarefa deletada!");
        }
        return ResponseEntity.notFound().build();
    }
}
