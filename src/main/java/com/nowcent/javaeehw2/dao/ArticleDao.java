package com.nowcent.javaeehw2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nowcent.javaeehw2.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Insert("INSERT INTO `article`(`name`, `content`, `blog_id`) VALUES (#{article.name}, #{article.content}, #{blogId})")
    int insertNew(Article article, long blogId);
}
