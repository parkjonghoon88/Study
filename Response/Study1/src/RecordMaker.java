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
			String data = "";
			
			int iRandom_Jumsu = new Random().nextInt(100);
			String str_No = getRandomNo();
			boolean isConstrain = false;
			
			
			if(!txt.contains(str_No))
			{
				isConstrain = false;
			}
			else
			{
				//학번 중복
				for(int j=0; j<10; j++)
				{
					System.out.println("중복 데이터  : " +j  +", "+  str_No);
					if(!txt.contains(str_No))
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
				data = str_No + " " + iRandom_Jumsu + "\n";
				txt += data;
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
	
	
	//랜덤 학번 생성
	public static String getRandomNo()
	{
		String result = "";
		
		int iRandom_No = new Random().nextInt(100000);
		
		
		
		String str_random = "";
		if(0<=iRandom_No && iRandom_No<10)
		{
			str_random = "0000"+iRandom_No;
		}
		else if(10<=iRandom_No && iRandom_No<100)
		{
			str_random = "000"+iRandom_No;
		}
		else if(100<=iRandom_No && iRandom_No<1000)
		{
			str_random = "00"+iRandom_No;
		}
		else if(1000<=iRandom_No && iRandom_No<10000)
		{
			str_random = "0"+iRandom_No;
		}
		else 
		{
			str_random = Integer.toString(iRandom_No);
		}
		
		result = "NT"+ str_random;
		
		return result;
	}
	
}
