/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TaginfoServiceImpl
 * Author:   Administrator
 * Date:     2018/12/27 10:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.service.impl;

import com.qif.mainstate.common.pager.Pager;
import com.qif.mainstate.manage.tag.dao.TaginfoDao;
import com.qif.mainstate.manage.tag.entity.TagInfo;
import com.qif.mainstate.manage.tag.service.TaginfoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaginfoServiceImpl implements TaginfoService {

    private static Log log = LogFactory.getLog(TaginfoServiceImpl.class);

    @Autowired
    private TaginfoDao taginfoDao;

    /**
     * 分页查询表m_taginfo
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Pager findTagList(Integer currentPage, Integer pageSize) {
        int start = (currentPage - 1) * pageSize;//开始查询的起点
//        List<TagInfo> tagList = taginfoDao.findTagInfoAll();
        long count = taginfoDao.findTagInfoCount();//按条件查询所有记录
//        long count = tagList.size();
        log.info("表m_taginfo总数:" + count);
        long pageCount = pageSize;//总页数

        List<TagInfo> taginfoList = null;
        try {
            taginfoList = taginfoDao.findTagInfoList(start, (int) pageCount);
        } catch (Exception e) {
            log.error("xxx", e);
        }//分页按条件查询所有记录
        Pager pager = new Pager();
        pager.setItems(taginfoList);
        pager.setPageNo(currentPage);
        pager.setTotalCount((int) count);
        pager.setPageSize(pageSize);
        return pager;
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    @Override
    public List<TagInfo> findTagAll() {
        List<TagInfo> list = taginfoDao.findTagInfoAll();
        return list;
    }
}