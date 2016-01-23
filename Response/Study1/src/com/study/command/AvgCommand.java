package com.study.command;

import java.text.DecimalFormat;
import java.util.List;

import com.study.model.Student;

public class AvgCommand implements Command {

	@Override
	public void execuet(List<Student> students) {
		int sumData = 0;

		for (int i = 0; i < students.size(); i++) {
			int tempData =  students.get(i).getStudentJumsu();
			sumData += tempData;
		}

		String pattern = "####.##";
		DecimalFormat format = new DecimalFormat(pattern);

		double resultData = sumData / students.size();

		System.out.println("Max value is " + resultData);
	}

}
