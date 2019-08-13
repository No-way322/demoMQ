package com.qif.mainstate.manage.tag.dao;

import com.qif.mainstate.manage.tag.entity.TagInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public interface StoredProcedureDao {
    /**
     * 根据存储过程名称调用对应的sql
     *
     * @return
     */
    List<Map<String, Object>> findStoredProcedure(@Param("name") String name);
}
