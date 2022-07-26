package com.example.jooq;

import static org.jooq.impl.DSL.*;
import static test.generated.Tables.*;

import java.sql.*;

import org.jooq.*;
import org.jooq.impl.*;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JOOQ {

    public void getTheID(){

        String userName = "root";
        String password = "Akashverma@123";
        String url = "jdbc:mysql://localhost:3306/users";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(FILES).fetch();

            for (Record r : result) {
                String id = r.getValue(FILES.STUDENT_ID);
                String firstName = r.getValue(FILES.NAME);

                System.out.println("ID: " + id + "Name: " + firstName );
            }
        }

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }


    }


}

