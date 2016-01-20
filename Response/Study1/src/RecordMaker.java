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
		String fileName = args[1];
		String text = "";
		
		
		
		for(int i=0; i<cnt; i++)
		{
			
			Student dtoStudent = new Student();
			
			dtoStudent.setStudentNo(getRandStudentNo());
			dtoStudent.setStudentJumsu(getRandStudentJumSu());
			
			
			boolean isConstrain = false;
			
			if(!text.contains(getRandStudentNo()))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  getRandStudentNo());
					if(!text.contains(getRandStudentNo()))
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
				text += getRandStudentNo() + " " + getRandStudentJumSu() + "\n";
			}
				
			
		}
		System.out.println(text);
		
		
		try
		{
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
	
	
	public static String getRandStudentNo()
	{
		String result = "";
		
		int randomNo = new Random().nextInt(100000);
		
		
		String randomData = "";
		randomData = String.format("%05d", randomNo); 
		
		result = "NT"+ randomData;
		
		return result;
	}
	
	
	public static int getRandStudentJumSu()
	{
		int result = new Random().nextInt(100);
		
		return result;
	}

	
	
}
