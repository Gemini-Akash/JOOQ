package com.example.jooq.repository;
import com.example.jooq.model.Student;
import org.jooq.*;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.generated.Tables;
import test.generated.tables.records.BooksRecord;
import test.generated.tables.records.StudentRecord;

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

//            ResultSet query =  jooq.select(STUDENT.ID,
//                            STUDENT.NAME,
//                            BOOKS.ID.as("books_id"),
//                            BOOKS.NAME.as("books_name")
//                    )
//                    .from(STUDENT)
//                    .leftJoin(BOOKS).on(BOOKS.STUDENT_ID.eq(STUDENT.ID))
//                    .orderBy(STUDENT.ID.asc())
//                    .fetchResultSet();

            ResultSet query1 = oneToMany(STUDENT,BOOKS,STUDENT.ID,STUDENT.NAME,BOOKS.ID,BOOKS.NAME,BOOKS.STUDENT_ID);



            System.out.println(query1);

            return transformQueryIntoList(query1);
        }


        public ResultSet oneToMany(TableLike<?> table1, TableLike<?> table2, TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name, TableField<?, Integer> foreignKey){

            ResultSet rs =jooq.select(table1_ID,table1_Name,table2_ID.as("books_id"),table2_Name.as("books_name"))
                    .from(table1)
                    .leftJoin(table2).on(foreignKey.eq(table1_ID))
                    .orderBy(table1_ID.asc())
                    .fetchResultSet();

            return rs;
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

