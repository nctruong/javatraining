package csc.truong.assignment2.model;

import java.util.ArrayList;
import java.util.List;

import csc.truong.assignment2.model.Score;
import csc.truong.assignment2.model.Address;

public class Student {
	private Integer id;
	private String name;
	private String sex;

	private Address address;
	private List<Score> score = new ArrayList<Score>(0);

	public Student() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getFinalScore() {
		// List<Score> listScore = score;//getScore();

		int total = 0;
		float sum = 0;
		for(Score sc : this.getScore()){	
			
			if(sc instanceof Score){
				++total;
				sum += sc.getScore();		
			} 
		}
		return sum/total;
	}

}
