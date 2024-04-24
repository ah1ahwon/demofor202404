package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_todos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long tno;

    private String title;

    private boolean complete;


    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeComplete(boolean complete) {
        this.complete = complete;
    }

}
