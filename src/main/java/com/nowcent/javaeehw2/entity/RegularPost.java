package com.nowcent.javaeehw2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RegularPost extends Article{
    private String content;
}
