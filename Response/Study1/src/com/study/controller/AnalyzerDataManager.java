package com.study.controller;

import java.text.DecimalFormat;
import java.util.List;

import com.study.model.Student;

public class AnalyzerDataManager {
	
	private String command;
	
	
	
	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}


	public String getAnalyzerData(String command, List<Student> listData)
	{
		getCommand();
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
