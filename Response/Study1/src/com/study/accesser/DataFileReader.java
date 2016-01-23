package com.study.accesser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.study.model.Student;

public class DataFileReader implements DataProvider {
	private String fileName = "";
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		try 
		{
			
			BufferedReader in = new BufferedReader(new FileReader(fileName + ".txt"));
			String strData;

			while ((strData = in.readLine()) != null) 
			{
				Student object = new Student();
				object.setStudentNo(strData.substring(0, 7));
				object.setStudentJumsu(Integer.parseInt(strData.substring(8)));
				System.out.println(strData);
				list.add(object);
			}

			in.close();
		} catch (IOException e) {
			System.err.println(e);// 에러가 있다면 메시지 출력
			System.exit(1);
		}
		return list;
	}

}
