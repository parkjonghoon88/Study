import java.io.FileWriter;
import java.util.Random;

public class RecordMaker {

	public static void main(String args[])
	{
		if(args.length < 2)
		{
			System.err.println("옵션을 입력해주세요");
			System.exit(1);
		}
		
		
		int cnt = Integer.parseInt(args[0]);
		String filename = args[1];
		String txt = "";
		
		
		
		for(int i=0; i<cnt; i++)
		{
			
			Student student_object = new Student();
			
			student_object.setSTUDENT_NO(student_object.getRandStudentNo());
			student_object.setSTUDENT_JUMSU(student_object.getRandStudentJumSu());
			
			
			boolean isConstrain = false;
			
			if(!txt.contains(student_object.getRandStudentNo()))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  student_object.getRandStudentNo());
					if(!txt.contains(student_object.getRandStudentNo()))
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
				txt += student_object.getRandStudentNo() + " " + student_object.getRandStudentJumSu() + "\n";
			}
				
			
		}
		System.out.println(txt);
		
		
		try
		{
			//txt파일 생성 및 작성 true로 주면 그뒤에 이어서 작성
			FileWriter fw = new FileWriter(filename+".txt");
			
			fw.write(txt);
			fw.flush();
			
			fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
	
	
}
