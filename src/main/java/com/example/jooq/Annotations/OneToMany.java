package com.example.jooq.Annotations;

import org.jooq.TableLike;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface  OneToMany{

   String table1() default "" ;
   String table2() default "" ;
   String table1_ID() default "" ;
   String table1_NAME() default "" ;
   String table2_ID() default "" ;
   String table2_NAME() default "";
   String foreignKey() default "";
   Class c() default void.class;
   String tag() default "";

 }
