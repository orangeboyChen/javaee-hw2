package com.nowcent.javaeehw2.entity;

import lombok.Data;

import java.util.List;

@Data
public class Comment {
    private Long id;
    private String content;
    private List<Tag> tagList;
}
