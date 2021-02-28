package com.haoyu.dao;

import com.haoyu.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-19 17:54
 **/
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
