/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fınalproj;

import java.util.ArrayList;

public class Student {
	private int ogrenci_No;
	private String adSoyad;
	ArrayList<String> phone_numbers = new ArrayList<String>();

	
	// NORMAL STUDENT CONSTRUCTOR'I

	public Student(int ogrenci_No, String adSoyad, ArrayList<String> phone_numbers) {
		super();
		this.ogrenci_No = ogrenci_No;
		this.adSoyad = adSoyad;
		this.phone_numbers = phone_numbers;
	}


	// NO PARAMETER CONSTRUCTOR
	public Student() {
		
		this.ogrenci_No = 00;
		this.adSoyad = null;
		this.phone_numbers = null;
		
	}

	
	// COPY CONSTRUCTOR
	public Student(Student primeStudent) {
		super();
		this.ogrenci_No = primeStudent.getOgrenci_No();
		this.adSoyad = primeStudent.getAdSoyad();
		this.phone_numbers = primeStudent.getPhone_numbers();
	}

        // GETTER SETTER
	public int getOgrenci_No() {
		return ogrenci_No;
	}


	public void setOgrenci_No(int ogrenci_No) {
		this.ogrenci_No = ogrenci_No;
	}


	public String getAdSoyad() {
		return adSoyad;
	}


	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}



	public ArrayList<String> getPhone_numbers() {
		return phone_numbers;
	}


	public void setPhone_numbers(ArrayList<String> phone_numbers) {
		this.phone_numbers = phone_numbers;
	}


	public String toString() {
		return ("Student No:\t"+ogrenci_No+"\tStudent Name:\t"+adSoyad+"\tStudent Phone Number:\t"+phone_numbers);
		
	}




}
