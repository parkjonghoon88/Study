package com.study;

import java.util.ArrayList;
import java.util.List;

public class RecordAnalyzer {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length < 2) {
			System.err.println("옵션을 입력해주세요");
			System.exit(1);
		}

		String command = args[0];
		String dataFile = args[1];
		String resultValue = "";
		List<Student> listData = new ArrayList<>();

		DataManager dataManager = new DataManager();
		dataManager.setFileName(dataFile);
		listData.addAll(dataManager.getStudents());

		if (listData.size() > 0) {
			if (command.equals("max")) {
				// 최대값
				resultValue = dataManager.getMaxData(listData);

			} else if (command.equals("min")) {
				// 최소값
				resultValue = dataManager.getMinData(listData);
			} else if (command.equals("avg")) {
				// 평균
				resultValue = dataManager.getAvgData(listData);
			} else {
				System.err.println("옵션을 다시 확인해주세요.");
				System.exit(1);
			}
		} else {
			System.err.println("데이터가 존재하지 않습니다.");
			System.exit(1);
		}

		System.out.println("결과 값 " + command + " : " + resultValue);

	}



}
