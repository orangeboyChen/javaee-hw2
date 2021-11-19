package com.nowcent.javaeehw2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Blog {
    private Long id;
    private String name;
    private List<Article> articleList;
    private List<Author> authorList;
    private State state;

    public enum State {
        active, inactive, closed
    }
}
