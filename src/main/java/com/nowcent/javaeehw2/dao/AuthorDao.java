package com.nowcent.javaeehw2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nowcent.javaeehw2.entity.Author;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorDao extends BaseMapper<Author> {

    @Insert("INSERT INTO `author`(`name`, `blog_id`) VALUES (#{author.name}, #{blogId})")
    int insertNew(Author author, long blogId);
}
