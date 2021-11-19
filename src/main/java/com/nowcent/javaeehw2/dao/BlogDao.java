package com.nowcent.javaeehw2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nowcent.javaeehw2.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDao extends BaseMapper<Blog> {

    Blog queryBlogById(long id);

    List<AuthorDao> queryAuthorByBlogId(long id);

    List<Comment> queryCommentByArticleId(long id);

    List<Tag> queryTagByCommentId(long id);

    List<Article> queryArticleByBlogId(long id);

    Blog queryBlogUsingJoinById(long id);
}
