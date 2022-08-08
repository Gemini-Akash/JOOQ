package com.example.jooq.repository;
import com.example.jooq.Annotations.OneToMany;
import com.example.jooq.model.Books;
import com.example.jooq.model.Student;
import com.example.jooq.model.movies;
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
import java.util.Objects;
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
        public <T> List<T> oneToMany(TableLike<?> table1, TableLike<?> table2, TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name, TableField<?, Integer> foreignKey,Class<T> class1,String Listnametag){

            ResultSet rs =jooq.select(table1_ID,table1_Name,table2_ID.as(Listnametag + table2_ID.getName()),table2_Name.as(Listnametag + table2_Name.getName()))
                    .from(table1)
                    .leftJoin(table2).on(foreignKey.eq(table1_ID))
                    .orderBy(table1_ID.asc())
                    .fetchResultSet();
            return transformQueryIntoList(rs,class1,table1_ID,table2_ID);

        }

        public void manyToMany1(TableLike<?> table1,TableLike<?> table2,TableLike<?> table3,TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name,TableField<?,Integer> table3_fk1,TableField<?,Integer> table3_fk2,String Listtagname,Class class1){
          Result<Record4<Integer, String, Integer, String>> rs =jooq.select(table1_ID, table1_Name, table2_ID.as(Listtagname+table2_ID.getName()), table2_Name.as(Listtagname+table2_Name.getName()))
                    .from(table1)
                    .join(table3).on((table1_ID).eq(table3_fk1))
                    .join(table2).on((table2_ID).eq(table3_fk2))
                    .fetch();

            System.out.println(rs);
        }


        public <T> List<T> manyToMany(TableLike<?> table1,TableLike<?> table2,TableLike<?> table3,TableField<?,Integer> table1_ID,TableField<?,String> table1_Name,TableField<?,Integer> table2_ID,TableField<?,String> table2_Name,TableField<?,Integer> table3_fk1,TableField<?,Integer> table3_fk2,String Listtagname,Class<T> class1){

            ResultSet rs =jooq.select(table1_ID, table1_Name, table2_ID.as(Listtagname+table2_ID.getName()), table2_Name.as(Listtagname+table2_Name.getName()))
                    .from(table1)
                    .join(table3).on((table1_ID).eq(table3_fk1))
                    .join(table2).on((table2_ID).eq(table3_fk2))
                    .fetchResultSet();

            Result<Record> rs1= jooq.fetch("SELECT movie.movie_id, movie.name, category.category_id AS category_id, category.name AS category_name " +
                    "FROM movie " +
                    "JOIN movie_category_rl on (movie.movie_id=movie_category_rl.movie_id) " +
                    "JOIN category on (category.category_id=movie_category_rl.category_id) ");


            return transformQueryIntoList(rs, class1,table1_ID, table2_ID);
        }






//    public <T> List<T> oneToMany1(Class<T> class1, Object ... args){
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

//    public void splitString(TableField<?,?> str){
//
//        System.out.println();
//
////        String[] str2=str;
////        System.out.println(str2.length);
////        for(int i=0;i< str2.length;i++){
////            System.out.println(str2[i]);
////        }
//
//
//
//    }


        private <T> List<T> transformQueryIntoList(ResultSet query, Class<T> anyclass,TableField<?,Integer> table1_id,TableField<?,Integer> table2_id ) {
            List<T> list=null;
            try  {
                list=  JdbcMapperFactory
                        .newInstance()
                        .addKeys(table1_id.getName(),table2_id.getName())
                        .newMapper(anyclass).stream(query).collect(Collectors.toList());

                System.out.println(table2_id.getName());
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            return list;
        }
}

