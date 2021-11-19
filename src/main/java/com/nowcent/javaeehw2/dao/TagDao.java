package com.nowcent.javaeehw2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nowcent.javaeehw2.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagDao extends BaseMapper<Tag> {
    @Insert("INSERT INTO `tag`(`name`, `comment_id`) VALUES (#{tag.name}, #{commentId})")
    int insertNew(Tag tag, long commentId);
}
