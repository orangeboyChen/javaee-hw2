package com.nowcent.javaeehw2;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nowcent.javaeehw2.dao.*;
import com.nowcent.javaeehw2.entity.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootTest
class JavaeeHw2ApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private TagDao tagDao;

    @Test
    void contextLoads() {
    }

    @Test
    void hwTest() {
        Blog blog = blogDao.queryBlogUsingJoinById(100);
        logger.warn("query using join: blog name: " + blog.getName());

        blog = blogDao.queryBlogById(100);
        logger.warn("query using collection: before lazy loading: " + blog.getName());
        List<Article> articleList = blog.getArticleList();
        logger.warn(JSON.toJSONString(articleList.get(0)));
        logger.warn("after lazy loading");

        logger.warn("article state: " + blog.getState().name());
    }

    @Test
    void deleteAll() {
        blogDao.delete(new QueryWrapper<>());
        authorDao.delete(new QueryWrapper<>());
        articleDao.delete(new QueryWrapper<>());
        commentDao.delete(new QueryWrapper<>());
        tagDao.delete(new QueryWrapper<>());
    }


    @Test
    void insert() {
        deleteAll();

        Blog blog = new Blog();
        blog.setName("blog-test");
        blog.setId(100L);
        blogDao.insert(blog);

        IntStream.range(0, 30).mapToObj(i -> {
            Author author = new Author();
            author.setName("author-" + i);
            return author;
        }).forEach(a -> authorDao.insertNew(a, 100L));

        IntStream.range(0, 30).mapToObj(i -> {
            Article article = new Article();
            article.setName("article-" + i);
            article.setType(0);
//            article.setContent("article-content-" + i);
            return article;
        }).forEach(a -> articleDao.insertNew(a, 100L));


        IntStream.range(0, 30).mapToObj(i -> {
            Comment comment = new Comment();
            comment.setContent("comment-content-" + i);
            return comment;
        }).forEach(a -> commentDao.insertNew(a, new Random().nextInt(30)));

        IntStream.range(0, 30).mapToObj(i -> {
            Tag tag = new Tag();
            tag.setName("tag-" + i);
            return tag;
        }).forEach(a -> tagDao.insertNew(a, new Random().nextInt(30)));
    }

}
