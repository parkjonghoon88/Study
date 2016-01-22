package com.study;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.accesser.DataProvider;
import com.accesser.DataWriter;

public class DataManager implements DataWriter, DataProvider{
	
	
	private String fileName = "";
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
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

	@Override
	public void writeData(List<Student> data) {
		// TODO Auto-generated method stub
		try
		{
			String text = "";
			for(int i=0; i<data.size(); i++)
			{
				text += data.get(i).getStudentNo()+ " " + data.get(i).getStudentJumsu() + "\n";
			}
			
			//txt파일 생성 및 작성 true로 주면 그뒤에 이어서 작성
			FileWriter fileWriter = new FileWriter(fileName+".txt");
			
			fileWriter.write(text);
			fileWriter.flush();
			
			fileWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
		
	}
	

}
