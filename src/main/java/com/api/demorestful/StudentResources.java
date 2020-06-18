package com.api.demorestful;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("student")
public class StudentResources {
	
	StudentRepository repo = new StudentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Student> getStudents() {
		System.out.println("getStudent called..");
		
 		return repo.getStudents();
	}

	@GET
	@Path("student/{points}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Student getStudent(@PathParam("points") int points) {
		
 		return repo.getStudent(points);
	}
	
	
	@POST
	@Path("stud")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student createStudent(Student s1) {
		System.out.println(s1);
		repo.create(s1);
		return s1;
	}
	
	@PUT
	@Path("stud")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student updateStudent(Student s1) {
		System.out.println(s1);
		if(repo.getStudent(s1.getPoints()).getPoints()==0) {
			repo.create(s1);
		}
		else {
			repo.update(s1);
		}
		repo.update(s1);
		return s1;
	}
	
	@DELETE
	@Path("student/{points}")
	public Student deleteStudent(@PathParam("points") int points) {
		Student s = repo.getStudent(points);
		
		if(s.getPoints()!=0) {
			repo.delete(points);
		}
		
		return s;
	}

}
