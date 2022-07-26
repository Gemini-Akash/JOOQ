package com.example.jooq;

import com.example.jooq.model.Student;
import com.example.jooq.repository.StudentRepo;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static test.generated.Tables.FILES;

@SpringBootApplication
public class JooqDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(JooqDemoApplication.class, args);

		String userName = "root";
		String password = "Akashverma@123";
		String url = "jdbc:mysql://localhost:3306/users";

		// Connection is the only JDBC resource that we need
		// PreparedStatement and ResultSet are handled by jOOQ, internally
		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

			StudentRepo studentRepo =new StudentRepo(create);
			List<Student> list =studentRepo.findAll();
			for (Student s:list) {
				System.out.println("name "+ s.getName()+" "+ "id "+s.getId()+" Books_id "+s.getBooks());
			}


//			Result<Record> result = create.select().from(FILES).fetch();
//
//			for (Record r : result) {
//				String id = r.getValue(FILES.STUDENT_ID);
//				String firstName = r.getValue(FILES.NAME);
//
//				System.out.println("ID: " + id + "Name: " + firstName );
//			}
		}

		// For the sake of this tutorial, let's keep exception handling simple
		catch (Exception e) {
			e.printStackTrace();
		}


//



		// With th help of the Generated Tables

//		JOOQ jooq =new JOOQ();
//		jooq.getTheID();


		//Without The help of Tables
//		JOOQWithoutTable jooqWithoutTable= new JOOQWithoutTable();
//		jooqWithoutTable.showData();



	}

}
