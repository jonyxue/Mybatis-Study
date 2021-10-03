package com.xue.dao;

import com.xue.pojo.Blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map<String,String> map);

}
