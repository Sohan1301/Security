package com.example.Controller;

public class Student {
	   private int id;
	    private String name;
	    private int marks;
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(int id, String name, int marks) {
			super();
			this.id = id;
			this.name = name;
			this.marks = marks;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public int getMarks() {
			return marks;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
		}


}
