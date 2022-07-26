package com.example.jooq.repository;
import com.example.jooq.model.Student;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static test.generated.Tables.*;

@Repository
public class StudentRepoWithCodeGen {



        private final JdbcMapper<Student> jdbcMapper;
        private final DSLContext jooq;

        @Autowired
        public StudentRepoWithCodeGen(DSLContext jooq) {
            this.jdbcMapper = JdbcMapperFactory
                    .newInstance()
                    .addKeys("id", "books_id")
                    .newMapper(Student.class);

            this.jooq = jooq;
        }

        @Transactional(readOnly = true)
        public List<Student> findAll() {
            ResultSet query =  jooq.select(STUDENT.ID,
                            STUDENT.NAME,
                            BOOKS.ID.as("books_id"),
                            BOOKS.NAME.as("books_name")
                    )
                    .from(STUDENT)
                    .leftJoin(BOOKS).on(BOOKS.STUDENT_ID.eq(STUDENT.ID))
                    .orderBy(STUDENT.ID.asc())
                    .fetchResultSet();

//            System.out.println(query);

            return transformQueryIntoList(query);
        }

        private List<Student> transformQueryIntoList(ResultSet query) {
            List<Student> list=null;
            try  {
                list=jdbcMapper.stream(query).collect(Collectors.toList());
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            return list;
        }
}

