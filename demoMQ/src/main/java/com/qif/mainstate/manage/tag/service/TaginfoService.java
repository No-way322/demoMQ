package com.qif.mainstate.manage.tag.service;

import com.qif.mainstate.common.pager.Pager;
import com.qif.mainstate.manage.tag.entity.TagInfo;

import java.util.List;

public interface TaginfoService {

    /**
     * 分页查询表m_taginfo
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    Pager findTagList(Integer currentPage, Integer pageSize);

    /**
     *
     * @return
     */
    List<TagInfo> findTagAll();
}
