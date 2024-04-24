package com.example.demo.repository;


import com.example.demo.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoRepositoryTests {

    @Autowired(required = false)
    private TodoRepository todoRepository;

    @Test
    public void testExist() {
        System.out.println(todoRepository);
    }
    @Test
    public void testInsert() {

        for(int i = 0; i < 20; i++) {
            TodoEntity todo = TodoEntity.builder()
                    .title("Sample..."+i)
                    .complete(false)
                    .build();

            todoRepository.save(todo);

            System.out.println(todo);

        }

    }
}
