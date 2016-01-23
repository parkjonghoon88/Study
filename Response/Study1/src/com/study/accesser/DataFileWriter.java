package com.study.accesser;

import java.io.FileWriter;
import java.util.List;

import com.study.model.Student;

public class DataFileWriter implements DataWriter {
	
	private String fileName = "";
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void writeData(List<Student> data) {
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
