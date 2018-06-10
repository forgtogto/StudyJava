package kr.co.jkseo.bookProgram;

import java.util.ArrayList;

public class members {
	String name, address, phone;
	String rentBook[] = new String[3];
	static ArrayList<members> list = new ArrayList<members>();

	members(String name, String address, String phone, String rentBook1, String rentBook2, String rentBook3) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		rentBook[0] = rentBook1;
		rentBook[1] = rentBook2;
		rentBook[2] = rentBook3;
	}

	void setRentBook1(String str) {
		rentBook[0] = str;
	}

	void setRentBook2(String str) {
		rentBook[1] = str;
	}

	void setRentBook3(String str) {
		rentBook[2] = str;
	}

}