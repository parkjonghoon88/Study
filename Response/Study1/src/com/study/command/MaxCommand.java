package com.study.command;

import java.util.List;

import com.study.model.Student;

public class MaxCommand implements Command{

	@Override
	public void execuet(List<Student> students) {
		int beforeData = 0;

		for (int i = 0; i < students.size(); i++) {
			int tempData = students.get(i).getStudentJumsu();

			if (beforeData <= tempData) {
				beforeData = tempData;
			}
		}
		
		System.out.println("Max value is " + beforeData);
	}

}
