package com.nowcent.javaeehw2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DraftPost extends Article{
    private String byteContent;
}
