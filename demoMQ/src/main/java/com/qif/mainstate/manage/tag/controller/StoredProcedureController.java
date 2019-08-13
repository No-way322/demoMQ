/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StoredProcedure
 * Author:   Administrator
 * Date:     2019/1/3 13:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.controller;

import com.qif.mainstate.manage.tag.service.StoredProcedureService;
import com.qif.mainstate.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存储过程
 *
 * @author hj
 */
@Controller
@RequestMapping("sp")
public class StoredProcedureController {

    private static final Log log = LogFactory.getLog(StoredProcedureController.class);

    @Autowired
    private StoredProcedureService storedProcedureService;

    /**
     * 根据存储过程名称调用对应的sql
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("findSg")
    @ResponseBody
    public Map<String, Object> findStoredProcedure(HttpServletResponse response, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String name = request.getParameter("name");
        if (!StringHelper.isNotBlack(name)) {
            map.put("error", "参数错误");
        } else {
            List<Map<String, Object>> list = storedProcedureService.findStoredProcedure(name);
            map.put("list", list);
        }
        return map;
    }

}