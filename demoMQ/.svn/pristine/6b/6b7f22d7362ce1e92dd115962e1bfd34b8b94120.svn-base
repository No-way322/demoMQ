/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TaginfoController
 * Author:   Administrator
 * Date:     2018/12/27 10:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * hj           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.controller;

import com.alibaba.fastjson.JSONObject;
import com.qif.mainstate.common.pager.Pager;
import com.qif.mainstate.manage.tag.entity.TagInfo;
import com.qif.mainstate.manage.tag.service.TaginfoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tag")
public class TaginfoController {

    @Autowired
    TaginfoService taginfoService;

    private static final Log log = LogFactory.getLog(TaginfoController.class);

    /**
     * 分页查询表m_taginfo
     */

    @RequestMapping("findTag")
    @ResponseBody
    public Map<String, Object> findTagList(HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        Map<String, Object> map = new HashMap<>();
        map.put("total", 0);
        map.put("rows", "");

        //分页代码
        int pageSize = 10;
        int currentPage = 1;
        String page = request.getParameter("page");//获取前台传过来想要查询数据的页码
        if (page == null || page == "") {
            currentPage = -1;
        } else {
            currentPage = Integer.parseInt(page);
        }
        String rows = request.getParameter("rows");//获取前台传过来每页显示的数据量

        if (rows == null || rows == "") {
            pageSize = -1;
        } else {
            pageSize = Integer.parseInt(rows);
        }
//        log.info("每页显示的数量是：" + pageSize);
        if (currentPage == -1 && pageSize == -1) {
            List<TagInfo> list = taginfoService.findTagAll();//查询所有记录
            map.put("rows", list);
            map.put("total", list.size());
        } else {
            Pager pager = taginfoService.findTagList(currentPage, pageSize);
            map.put("total", pager.getTotalCount());//获取总记录数
            map.put("rows", pager.getItems());//获取当前页对象列表
        }
        return map;
    }


}