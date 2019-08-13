/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DBRsHelp
 * Author:   Administrator
 * Date:     2019/1/3 14:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.util;

import com.qif.mainstate.manage.tag.dao.TaginfoDao;
import com.qif.mainstate.manage.tag.entity.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Java工具类 通过ResultSet对象返回对应的实体List集合
 *
 * @param <T>
 */
public class DBRsHelp<T> {

    public List<T> util(T t, ResultSet rs) throws Exception {
        // 创建一个对应的空的泛型集合
        List<T> list = new ArrayList<T>();

        // 反射出类类型（方便后续做操作）
        Class c = t.getClass();
        // 获得该类所有自己声明的字段，不问访问权限.所有。所有。所有
        Field[] fs = c.getDeclaredFields();
        // 大家熟悉的操作，不用多说
        if (rs != null) {
            while (rs.next()) {
                // 创建实例
                t = (T) c.newInstance();
                // 赋值
                for (int i = 0; i < fs.length; i++) {
                    /*
                     * fs[i].getName()：获得字段名
                     *
                     * f:获得的字段信息
                     */
                    Field f = t.getClass().getDeclaredField(fs[i].getName());
                    // 参数true 可跨越访问权限进行操作
                    f.setAccessible(true);
                    /*
                     * f.getType().getName()：获得字段类型的名字
                     */
                    // 判断其类型进行赋值操作
                    if (f.getType().getName().equals(String.class.getName())) {
                        f.set(t, rs.getString(fs[i].getName()));
                    } else if (f.getType().getName().equals(int.class.getName())) {
                        f.set(t, rs.getInt(fs[i].getName()));
                    }
                }

                list.add(t);
            }
        }
        // 返回结果
        return list;
    }

}