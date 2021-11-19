package com.nowcent.javaeehw2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private Long id;
    private String name;
    private Integer type;
    private List<Comment> commentList;
}
