/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookController
 * Author:   Administrator
 * Date:     2019/1/10 11:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qif.mainstate.manage.tag.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.qif.mainstate.manage.tag.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mg")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/findAllBooks")
    @ResponseBody
    public String findAllBooks() {
        String bookList = bookService.FindAll();
        return bookList;
    }

    /**
     * 新增
     *
     * @return
     */
    @RequestMapping(value = "addBooks")
    @ResponseBody
    public String addBooks() {
        Book book = new Book();
//        book.setId("2");
        book.setAuthor("hejun");
        book.setName("奥术大师");
        book.setPicture("dddd");
        book.setPrice(10);
        book.setMessage("sadasdsadsa");
        book.setSale(1);
        book.setStock(1);
        bookService.addBooks(book);
        return "success";
    }

    /**
     * 根据条件查询对象
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "getByAuthor")
    @ResponseBody
    public Map<String, Object> getByAuthor(HttpServletRequest request) {
        Map<String, Object> map = bookService.getByAuthor1(request.getParameter("author"));
        return map;
    }

    /**
     * 更新操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "updateBook")
    @ResponseBody
    public Map<String, Object> updateBook(HttpServletRequest request) {
        Map<String, Object> map = bookService.updateBook();
        return map;
    }

    /**
     * 删除操作
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "deleteBook")
    @ResponseBody
    public Map<String, Object> deleteBook(HttpServletRequest request) {
        Map<String, Object> map = bookService.deleteBook(request.getParameter("id"));
        return map;
    }

    @RequestMapping(value = "getById")
    @ResponseBody
    public String getById(HttpServletRequest request) {
        String book = bookService.getById(request.getParameter("id"));
        return book;
    }

    @RequestMapping(value = "getById1")
    @ResponseBody
    public Map<String, Object> getById1(HttpServletRequest request) {
        Map<String, Object> map = bookService.getById1(request.getParameter("id"));
        return map;
    }

}