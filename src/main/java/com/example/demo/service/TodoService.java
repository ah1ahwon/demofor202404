package com.example.demo.service;

import com.example.demo.dto.TodoDTO;
import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoDTO register(TodoDTO todoDTO) {

        TodoEntity todoEntity = dtoToEntity(todoDTO);

        todoRepository.save(todoEntity);

        return entityToDTO(todoEntity);
    }

    public TodoDTO read(Long tno) {

        TodoEntity todoEntity = todoRepository.findById(tno).orElseThrow();

        return entityToDTO(todoEntity);
    }

    public void modify(TodoDTO todoDTO) {

        TodoEntity todoEntity = todoRepository.findById(todoDTO.getTno()).orElseThrow();

        todoEntity.changeTitle(todoDTO.getTitle());
        todoEntity.changeComplete(todoDTO.isComplete());
    }

    public void remove(Long tno) {

        TodoEntity todoEntity = todoRepository.findById(tno).orElseThrow();

        todoRepository.delete(todoEntity);
    }

    public Page<TodoDTO> list(int page){

        Pageable pageable = PageRequest.of(page-1, 10, Sort.by("tno").descending());

        java.util.List<TodoDTO> dtoList =
                todoRepository.findAll(pageable).map(todoEntity -> entityToDTO(todoEntity)).stream().toList();

        return new org.springframework.data.domain.PageImpl<>(dtoList, pageable, todoRepository.count());
    }



    private TodoDTO entityToDTO(TodoEntity todoEntity) {

        return TodoDTO.builder()
                .tno(todoEntity.getTno())
                .title(todoEntity.getTitle())
                .complete(todoEntity.isComplete())
                .build();
    }

    private TodoEntity dtoToEntity(TodoDTO todoDTO) {

        return TodoEntity.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .complete(todoDTO.isComplete())
                .build();
    }

}
