package com.study.command;

import java.util.List;

import com.study.model.Student;

public interface Command {

	public void execuet(List<Student> students);
}
