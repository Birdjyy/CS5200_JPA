package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.Test;
import edu.northeastern.cs5200.models.Faculty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cs5200Spring20JinYaoyuJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring20JinYaoyuJpaApplication.class, args);
//		Test obj = new Test();
//		obj.truncateDatabase();

//		FacultyDao facultyDao = new FacultyDao();
//		Faculty faculty = new Faculty();
//		faculty.setTenured(true);
//		faculty.setOffice("test");
//		facultyDao.createFaculty(faculty);
	}

}
