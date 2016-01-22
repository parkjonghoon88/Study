package com.study;
import java.util.ArrayList;
import java.util.List;

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
		
		RandomCreateDataManager dataRandomCreate = new RandomCreateDataManager();
		listData.addAll(dataRandomCreate.getTotalStudent(cnt));
		
		
		for(int i=0; i<listData.size(); i++)
		{
			System.out.println(listData.get(i).getStudentNo() + " " +listData.get(i).getStudentJumsu() );
		}
		
		dataManager.writeData(listData);
		
	}
	
	
	
}
