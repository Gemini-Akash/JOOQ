package com.example.jooq.repository;

public class OneToMany {

    public String Select(String ... E){
        String sql = "SELECT";
        return sql;
    }
    public String formTable(String table){

        String sql = "FROM "+table;
        return sql;
    }
    public String leftJoin(String leftJoinTable){
        String sql = "LEFT JOIN "+leftJoinTable;
        return sql;
    }
    public String on(String TableEntity1, String TableEntity2){
        String sql ="ON "+TableEntity1+"="+TableEntity2;
        return sql;
    }
    public String orderBy(String TableEntity){
        String sql= "ORDER BY "+TableEntity;
        return sql;
    }

}
