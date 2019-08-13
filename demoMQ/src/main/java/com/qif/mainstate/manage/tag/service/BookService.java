/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookService
 * Author:   Administrator
 * Date:     2019/1/10 11:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.service;

import com.qif.mainstate.manage.tag.entity.Book;

import java.util.Map;

/*
 * 图书管理
 */
public interface BookService {

    /*
     * 查询所有图书
     */
    public String FindAll();

    /**
     * 根据id查询对应图书
     *
     * @param id
     * @return
     */
//    public Map<String, Object> getByName(String id);

    /*
     * 根据作者获取所有图书——模糊查询
     *
     * @author 作者
     *
     * @return
     */
    public String getByAuthor(String author);

    /*
     * 根据id获取所有图书
     *
     * @id 图书id
     *
     * @return
     */
    public String getById(String id);

    public Map<String, Object> getById1(String id);

    public void addBooks(Book book);

    public Map<String, Object> getByAuthor1(String author);

    public Map<String, Object> updateBook();

    public Map<String, Object> deleteBook(String id);
}
