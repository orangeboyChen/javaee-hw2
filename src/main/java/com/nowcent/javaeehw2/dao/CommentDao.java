package com.nowcent.javaeehw2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nowcent.javaeehw2.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao extends BaseMapper<Comment> {

    @Insert("INSERT INTO `comment`(`content`, `article_id`) VALUES (#{comment.content}, #{articleId})")
    int insertNew(Comment comment, long articleId);
}
