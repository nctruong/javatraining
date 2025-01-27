//Chú ý ràng buộc not-null của table - thường thì sẽ xãy ra lỗi null nếu dữ liệu không đồng bộ giữa các bảng.

package csc.truong.assignment2;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import csc.truong.assignment2.model.Address;
import csc.truong.assignment2.model.Score;
import csc.truong.assignment2.model.Student;
import javassist.bytecode.Descriptor.Iterator;
import csc.truong.assignment2.dao.StudentDAO;

public class MainApp {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-database.xml");
		
		StudentDAO studentDao = (StudentDAO) context.getBean("studentDao");
		
	// STUDENT
		Student student = new Student();		
		student.setName("Nguyen Thi Hong");
		student.setSex("F");
		studentDao.create(student);	// create student to get ID
		
	// ADRESS
		Address address = new Address();
		address.setStreet("Tan Vien");
		address.setCity("Ho Chi Minh");
		
	// SCORE
		Score score1 = new Score();
		score1.setSubject("Dia");
		score1.setScore(new Float("8.2"));		
		
		Score score2 = new Score();
		score2.setSubject("Su");
		score2.setScore(new Float("9.3"));
			
	// CREATION
		score1.setStudent(student);
		student.getScore().add(score1);
		
		score2.setStudent(student);
		student.getScore().add(score2);
		
		address.setStudent(student);
		student.setAddress(address);
		
		studentDao.create(student);
		
		//ArrayList<Student> students = (ArrayList<Student>) studentDao.listStudents();
		//showReport(students);
	}
	
	public static void showReport(ArrayList<Student> students){
		for (Student s : students) {
			
			System.out.println("*** Student ID: " + s.getId());	
			System.out.println("    Name: " + s.getName());
			System.out.println("    Sex: " + s.getSex());
			System.out.println("    Address: " + s.getAddress().getStreet() + ", "+ s.getAddress().getCity());
			System.out.println("    Scores: ");
			int total = 0;
			float sum = 0;
			
			for(Score sc : s.getScore()){	
				
				if(sc instanceof Score){
					++total;
					System.out.println("    - " + sc.getSubject() + ": " + sc.getScore());
					sum += sc.getScore();		
				} 
			}
			
			System.out.println("    -------------------------");
			System.out.println("    - Total: " + sum +" (" + total + " subjects)");
			System.out.println("    => finalScore: " + s.getFinalScore());
			System.out.println();
			
		}		
	}
}
