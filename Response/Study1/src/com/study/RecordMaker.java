package com.study;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.accesser.DataWriter;

public class RecordMaker {
	

	public static void main(String args[])
	{
		if(args.length < 2)
		{
			System.err.println("옵션을 입력해주세요");
			System.exit(1);
		}
		
		
		int cnt = Integer.parseInt(args[0]);
		String fileName = args[1];
		String text = "";
		List<Student> listData = new ArrayList<Student>();
		
		DataManager dataManager = new DataManager();
		dataManager.setFileName(fileName);
		
		
		for(int i=0; i<cnt; i++)
		{
			
			Student dtoStudent = new Student();
			
			
			dtoStudent.setStudentNo(dataManager.getRandStudentNo());
			dtoStudent.setStudentJumsu(dataManager.getRandStudentJumSu());
			
			
			boolean isConstrain = false;
			
			if(!text.contains(dataManager.getRandStudentNo()))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  dataManager.getRandStudentNo());
					if(!text.contains(dataManager.getRandStudentNo()))
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
//				text += getRandStudentNo() + " " + getRandStudentJumSu() + "\n";
				listData.add(dtoStudent);
			}
		}
		
		for(int i=0; i<listData.size(); i++)
		{
			System.out.println(listData.get(i).getStudentNo());
		}
		
		
		
		dataManager.writeData(listData);
		
	}
	
	
	
}
