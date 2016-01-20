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
		
		
		int iCnt = Integer.parseInt(args[0]);
		String sFileName = args[1];
		String sText = "";
		
		
		
		for(int i=0; i<iCnt; i++)
		{
			
			Student dtoStudent = new Student();
			
			dtoStudent.setSTUDENT_NO(getRandStudentNo());
			dtoStudent.setSTUDENT_JUMSU(getRandStudentJumSu());
			
			
			boolean isConstrain = false;
			
			if(!sText.contains(getRandStudentNo()))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  getRandStudentNo());
					if(!sText.contains(getRandStudentNo()))
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
				sText += getRandStudentNo() + " " + getRandStudentJumSu() + "\n";
			}
				
			
		}
		System.out.println(sText);
		
		
		try
		{
			//txt파일 생성 및 작성 true로 주면 그뒤에 이어서 작성
			FileWriter fFilwWriter = new FileWriter(sFileName+".txt");
			
			fFilwWriter.write(sText);
			fFilwWriter.flush();
			
			fFilwWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
	
	
	public static String getRandStudentNo()
	{
		String result = "";
		
		int iRandom_No = new Random().nextInt(100000);
		
		
		String str_random = "";
		str_random = String.format("%05d", iRandom_No); 
		
		result = "NT"+ str_random;
		
		return result;
	}
	
	
	public static int getRandStudentJumSu()
	{
		int result = new Random().nextInt(100);
		
		return result;
	}

	
	
}
