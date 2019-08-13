package com.qif.mainstate.manage.tag.dao;

import org.apache.ibatis.annotations.Param;

import com.qif.mainstate.manage.tag.entity.TagInfo;

import java.util.List;

public interface TaginfoDao {

    /**
     * 查询所有记录
     *
     * @return
     */
    long findTagInfoCount();

    /**
     * 查询所有记录
     *
     * @return
     */
    List<TagInfo> findTagInfoAll();

    /**
     * 分页按条件查询所有记录
     *
     * @param start
     * @param pageSize
     * @return
     */
    List<TagInfo> findTagInfoList(@Param("start") Integer start, @Param("pageSize") Integer pageSize) throws Exception;

}
