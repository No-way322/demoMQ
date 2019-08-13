
package com.qif.mainstate.manage.tag.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Path;

import com.qif.mainstate.manage.tag.entity.Book;
import com.qif.mainstate.manage.tag.entity.MessageSender;
import com.qif.mainstate.manage.tag.entity.TagInfo;
import com.qif.mainstate.manage.tag.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class BookServiceImpl implements BookService {
    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    @Qualifier("mongoTemplate")
    MongoTemplate mongoTemplate;

    public String FindAll() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Book> bookList = new ArrayList<Book>();
            bookList = mongoTemplate.findAll(Book.class);
            jsonObject.put("result", 1);
            jsonObject.put("msg", bookList);
        } catch (Exception e) {
            jsonObject.put("result", 0);
            jsonObject.put("msg", "接口异常，请联系管理员！");
        }

        return jsonObject.toString();
    }

    public String getByName(String name) {
        JSONObject jsonObject = new JSONObject();
        try {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("name").regex(".*?\\" + name + ".*"));
            List<Book> bookList = new ArrayList<Book>();
            bookList = mongoTemplate.find(new Query(criteria), Book.class);
            jsonObject.put("result", 1);
            jsonObject.put("msg", bookList);
        } catch (Exception e) {
            jsonObject.put("result", 0);
            jsonObject.put("msg", "接口异常，请联系管理员！");
        }

        return jsonObject.toString();
    }

    public String getByAuthor(String author) {
        JSONObject jsonObject = new JSONObject();
        try {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("author").regex(".*?\\" + author + ".*"));
            List<Book> bookList = new ArrayList<Book>();
            bookList = mongoTemplate.find(new Query(criteria), Book.class);
            jsonObject.put("result", 1);
            jsonObject.put("msg", bookList);
        } catch (Exception e) {
            jsonObject.put("result", 0);
            jsonObject.put("msg", "接口异常，请联系管理员！");
        }

        return jsonObject.toString();

    }

    public String getById(String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            Book book = mongoTemplate.findById(id, Book.class);
            jsonObject.put("result", 1);
            jsonObject.put("msg", book);
        } catch (Exception e) {
            jsonObject.put("result", 0);
            jsonObject.put("msg", "接口异常！");
        }
        return jsonObject.toString();
    }

    @Override
    public Map<String, Object> getById1(String id) {
//        Book book = mongoTemplate.findById(id, Book.class);
//        return book;
        Map<String, Object> map = new HashMap<>();
        try {
            Book book = mongoTemplate.findById(id, Book.class);
            map.put("book", book);
        } catch (Exception e) {
            logger.error("error", e);
        }
        return map;
    }

    @Override
    public void addBooks(Book book) {
        mongoTemplate.insert(book);
    }

    @Override
    public Map<String, Object> getByAuthor1(String author) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (author != null) {
                Criteria criteria = Criteria.where("author").is(author);
                List<Book> book = mongoTemplate.find(new Query(criteria), Book.class);
                map.put("book", book);
            }
        } catch (Exception e) {
            logger.error("error", e);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateBook() {
        Map<String, Object> map = new HashMap<>();
        try {
            Query query = new Query();
            Criteria criteria = Criteria.where("id").is(1);
            Update update = new Update().set("name", "abc");
            mongoTemplate.updateFirst(query, update, Book.class);
            map.put("101", "success");
        } catch (Exception e) {
            logger.error("error", e);
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteBook(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Query query = new Query();
            Criteria criteria = Criteria.where("id").is(id);
            query.addCriteria(criteria);
            mongoTemplate.remove(query, Book.class);
            map.put("101", "success");
        } catch (Exception e) {
            logger.error("error", e);
        }
        return map;
    }
}