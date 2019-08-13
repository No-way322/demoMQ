/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StoredProcedureServiceImpl
 * Author:   Administrator
 * Date:     2019/1/3 14:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.service.impl;

import com.qif.mainstate.manage.tag.dao.StoredProcedureDao;
import com.qif.mainstate.manage.tag.service.StoredProcedureService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoredProcedureServiceImpl implements StoredProcedureService {

    private static Log log = LogFactory.getLog(StoredProcedureServiceImpl.class);

    @Autowired
    private StoredProcedureDao storedProcedureDao;

    /**
     * 根据存储过程名称调用对应的sql
     *
     * @param name
     * @return
     */
    @Override
    public List<Map<String, Object>> findStoredProcedure(String name) {
        List<Map<String, Object>> list = null;
        try {
//            String name1 = "call " + name + "()";
            list = storedProcedureDao.findStoredProcedure(name);
        } catch (Exception e) {
            log.error("error", e);
        }

        return list;
    }
}