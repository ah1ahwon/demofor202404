package com.example.demo.controller;


import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @PostMapping("")
    public ResponseEntity<TodoDTO> register( @RequestBody TodoDTO todoDTO) {
        log.info("register: " + todoDTO);
        return ResponseEntity.ok(todoService.register(todoDTO));
    }

    @GetMapping("/{tno}")
    public ResponseEntity<TodoDTO> read(@PathVariable Long tno) {
        log.info("read: " + tno);
        return ResponseEntity.ok(todoService.read(tno));
    }

    @PutMapping("/{tno}")
    public ResponseEntity<Void> modify(@PathVariable Long tno, @RequestBody TodoDTO todoDTO) {

        todoDTO.setTno(tno);
        log.info("modify: " + todoDTO);
        todoService.modify(todoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<Void> remove(@PathVariable Long tno) {
        log.info("remove: " + tno);
        todoService.remove(tno);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(value = "page", defaultValue = "1") int page) {
        log.info("list: " + page);
        return ResponseEntity.ok(todoService.list(page));
    }
}
