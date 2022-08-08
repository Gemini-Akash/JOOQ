package com.example.jooq.repository;

import com.example.jooq.model.Student;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    private final JdbcMapper<Student> jdbcMapper;
    private final DSLContext jooq;

    OneToMany oneToMany = new OneToMany();


    public StudentRepo(DSLContext jooq) {
        this.jdbcMapper = JdbcMapperFactory.
                newInstance().
                addKeys("id","book_id").
                newMapper(Student.class);

        this.jooq = jooq;
    }



    public List<Student> findAll() {

        Result<Record> query = jooq.fetch("select student.id,student.name,books.id as books_id,books.name as books_name " +
                "from student " +
                "LEFT JOIN books " +
                "ON books.student_id = student.id " +
                "ORDER BY student.id");


        System.out.println(query.intoResultSet());

        return transformQueryIntoList(query);
    }

    private List<Student> transformQueryIntoList(Result<Record> query) {
        List<Student> list = null;
        try (ResultSet rs =query.intoResultSet()) {
            list= jdbcMapper.stream(rs).collect(Collectors.toList());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
