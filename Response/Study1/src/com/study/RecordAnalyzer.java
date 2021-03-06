package com.study;

import java.lang.reflect.Constructor;

import com.study.accesser.DataFileReader;
import com.study.accesser.DataProvider;
import com.study.accesser.RandomDataProvider;
import com.study.command.Command;

public class RecordAnalyzer {


	public static void main(String[] args) {

		if (args.length < 2) {
			System.err.println("옵션을 입력해주세요");
			System.exit(1);
		}

		String commandString = args[0];
		String dataFile = args[1];

		DataFileReader dataFileReader = new DataFileReader();
		dataFileReader.setFileName(dataFile);
		
		DataProvider provider = dataFileReader;

		Command command = getCommand(commandString);
		if (command == null) {
			System.err.println("옵션을 다시 확인해주세요.");
			System.exit(1);
		}

		readAndAnalyzerData(provider, command);
	}

	private static Command getCommand(String commandString) {
		commandString = commandString.toUpperCase().substring(0, 1) +
				commandString.toLowerCase().substring(1);
		
		String commandClassName = Command.class.getPackage().getName() + "." + commandString + "Command";

		Command command = null;
		try{
			Class<?> cls = Class.forName(commandClassName);
			Constructor<?> ct = cls.getConstructor();
			command = (Command) ct.newInstance();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return command;
	}

	public static void readAndAnalyzerData(DataProvider provider, Command command){
		if (provider.getStudents().size() > 0) {
			command.execuet(provider.getStudents());
		} else {
			System.err.println("데이터가 존재하지 않습니다.");
			System.exit(1);
		}
	}


}
