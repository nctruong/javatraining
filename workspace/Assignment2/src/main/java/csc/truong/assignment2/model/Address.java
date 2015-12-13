package csc.truong.assignment2.model;

public class Address {
	// All properties of this table-class.
	private Integer id;
	private String street;
	private String city;
	
	// Object of class reference must be declared
	private Student student;
	
	public Address(){
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
