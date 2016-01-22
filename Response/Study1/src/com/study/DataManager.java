package com.study;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	
	public String getRandStudentNo()
	{
		String result = "";
		
		int randomNo = new Random().nextInt(100000);
		
		
		String randomData = "";
		randomData = String.format("%05d", randomNo); 
		
		result = "NT"+ randomData;
		
		return result;
	}
	
	
	public int getRandStudentJumSu()
	{
		int result = new Random().nextInt(100);
		
		return result;
	}
	
	
	
	// 최대 값 구하는 함수
	public String getMaxData(List<Student> list) {
		int beforeData = 0;

		for (int i = 0; i < list.size(); i++) {
			int tempData = list.get(i).getStudentJumsu();

			if (beforeData <= tempData) {
				beforeData = tempData;
			}
		}
		return Integer.toString(beforeData);
	}

	// 최소 값 구하는 함수
	public String getMinData(List<Student> list) {
		int beforeData = 0;

		for (int i = 0; i < list.size(); i++) {
			int tempData =  list.get(i).getStudentJumsu();

			if (i == 0) {
				beforeData = tempData;
			}

			if (tempData <= beforeData) {
				beforeData = tempData;
			}
		}
		return Integer.toString(beforeData);
	}

	// 평균 값 구하는 함수
	public String getAvgData(List<Student> list) {
		int sumData = 0;

		for (int i = 0; i < list.size(); i++) {
			int tempData =  list.get(i).getStudentJumsu();
			sumData += tempData;
		}

		String pattern = "####.##";
		DecimalFormat format = new DecimalFormat(pattern);

		double resultData = sumData / list.size();

		return Double.toString(resultData);
	}

}
