package kr.co.jkseo.bookProgram;

import java.util.ArrayList;

public class book {
	String title, writer, publisher, code, forrent;
	static ArrayList<book> list = new ArrayList<book>();

	book(String title, String writer, String publisher, String code, String forrent) {
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.code = code;
		this.forrent = forrent;
	}

	void setForrent(String str) {
		forrent = str;
	}

}