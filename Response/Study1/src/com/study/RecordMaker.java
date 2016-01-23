package com.study;
import java.util.ArrayList;
import java.util.List;

import com.study.accesser.RandomDataProvider;
import com.study.accesser.DataFileWriter;
import com.study.accesser.DataProvider;
import com.study.accesser.DataWriter;
import com.study.model.Student;

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
		
		RandomDataProvider provider = new RandomDataProvider();
		provider.setCnt(cnt);
		
		DataFileWriter writer = new DataFileWriter();
		writer.setFileName(fileName);
		
		readAndWrite(provider, writer);
	}
	
	private static void readAndWrite(DataProvider provider, DataWriter writer) {
		List<Student> listData = provider.getStudents();

		writer.writeData(listData);
	}
	
	
	
	
}
