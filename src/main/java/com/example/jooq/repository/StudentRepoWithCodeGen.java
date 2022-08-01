package com.example.jooq.repository;
import com.example.jooq.model.Books;
import com.example.jooq.model.Student;
import org.jooq.*;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static test.generated.Tables.*;

@Repository
public class StudentRepoWithCodeGen {




        private final DSLContext jooq;

        @Autowired
        public StudentRepoWithCodeGen(DSLContext jooq) {
            this.jooq = jooq;
        }

//
//        @Transactional
//        public void insertQuery(){
//            jooq.insertInto(BOOKS,BOOKS.ID,BOOKS.NAME,BOOKS.STUDENT_ID).values(4,"bio",2).execute();
//        }

        @Transactional(readOnly = true)
        public <T> List<T> oneToMany(TableLike<?> table1, TableLike<?> table2, TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name, TableField<?, Integer> foreignKey,Class<T> class1,String ListNamePassedAsTag){

            ResultSet rs =jooq.select(table1_ID,table1_Name,table2_ID.as(ListNamePassedAsTag+"_id"),table2_Name.as(ListNamePassedAsTag+"_name"))
                    .from(table1)
                    .leftJoin(table2).on(foreignKey.eq(table1_ID))
                    .orderBy(table1_ID.asc())
                    .fetchResultSet();

            return transformQueryIntoList(rs,class1);


        }

//    public <T> List<T> oneToMany1(TableLike<?> table1, TableLike<?> table2, TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name, TableField<?, Integer> foreignKey,Class<T> class1){
//
//        ResultSet rs =jooq.select(table1_ID,table1_Name,table2_ID.as("books_id"),table2_Name.as("books_name"))
//                .from(table1)
//                .leftJoin(table2).on(foreignKey.eq(table1_ID))
//                .orderBy(table1_ID.asc())
//                .fetchResultSet();
//
//        return transformQueryIntoList(rs,class1);
//
//
//    }

        private <T> List<T> transformQueryIntoList(ResultSet query, Class<T> anyclass ) {
            List<T> list=null;
            try  {
                list=  JdbcMapperFactory
                        .newInstance()
                        .addKeys("table1_id", "table2_id")
                        .newMapper(anyclass).stream(query).collect(Collectors.toList());
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            return list;
        }
}

