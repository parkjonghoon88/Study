package com.study.accesser;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.study.model.Student;

public class RandomDataProvider implements DataProvider{
	
	
	private int cnt = 0;
	
	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public RandomDataProvider(){
		
	}
	
	public RandomDataProvider(int cnt) {
		
		this.cnt = cnt;
	}


	//입력받은 개수만큼 리스트에 랜덤으로 학생 담기
	@Override
	public List<Student> getStudents()
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
	
	
	
	


	
}
