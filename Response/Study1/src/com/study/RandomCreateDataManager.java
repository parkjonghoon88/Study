package com.study;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCreateDataManager {
	
	
	//입력받은 개수만큼 리스트에 랜덤으로 학생 담기
	public List<Student> getTotalStudent(int cnt)
	{
		List<Student> list = new ArrayList<>();
		String text = "";
		
		
		for(int i=0; i<cnt; i++)
		{
			
			Student dtoStudent = new Student();
			
			dtoStudent.setStudentNo(getRandStudentNo());
			dtoStudent.setStudentJumsu(getRandStudentJumSu());
			
			boolean isConstrain = false;
			
			if(!text.contains(getRandStudentNo()))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  getRandStudentNo());
					if(!text.contains(getRandStudentNo()))
					{
						isConstrain = false;
						break;
					}
					else
					{
						isConstrain = true;
					}
				}
			}
			
			
			//학번 중복 없을 경우 저장
			if(!isConstrain)
			{
				text += getRandStudentNo() + " " + getRandStudentJumSu() + "\n";
				list.add(dtoStudent);
			}
		}
		
		return list;
	}
	
	
	public String getAnalyzerData(String command, List<Student> listData)
	{
		String resultValue = "";
		
		if (command.equals("max")) {
			// 최대값
			resultValue = getMaxData(listData);

		} else if (command.equals("min")) {
			// 최소값
			resultValue = getMinData(listData);
		} else if (command.equals("avg")) {
			// 평균
			resultValue = getAvgData(listData);
		} else {
			System.err.println("옵션을 다시 확인해주세요.");
			System.exit(1);
		}
		
		return resultValue;
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
