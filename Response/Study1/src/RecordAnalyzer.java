import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RecordAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length < 2)
		{
			System.err.println("옵션을 입력해주세요");
			System.exit(1);
		}
		
		ArrayList<String> listData = new ArrayList<>();
		
		String command = args[0];
		String dataFile = args[1];
		String resultValue = "";
		
		
		try 
		{
		      BufferedReader in = new BufferedReader(new FileReader(dataFile+".txt"));
		      String strData;

		      while ((strData = in.readLine()) != null) 
		      {
					System.out.println(strData);
					listData.add(strData);
		      }
		      
		      in.close();
		} catch (IOException e) {
		        System.err.println(e); // 에러가 있다면 메시지 출력
		        System.exit(1);
		}
		
		
		if(listData.size()>0)
		{
			if(command.equals("max"))
			{
				//최대값
				resultValue = getMaxData(listData);
				
			}
			else if(command.equals("min"))
			{
				//최소값
				resultValue = getMinData(listData);
			}
			else if(command.equals("avg"))
			{
				//평균
				resultValue = getAvgData(listData);
			}
			else
			{
				System.err.println("옵션을 다시 확인해주세요.");
				System.exit(1);
			}
		}
		else
		{
			System.err.println("데이터가 존재하지 않습니다.");
			System.exit(1);
		}
		
		System.out.println("결과 값 " +command +" : "+ resultValue);
		
	}
	
	
	//최대 값 구하는 함수
	public static String getMaxData(ArrayList<String> list)
	{
		int beforeData = 0;
		
		for(int i=0; i<list.size(); i++)
		{
			int tempData = Integer.parseInt(list.get(i).substring(8).trim());
			
			if(beforeData<=tempData)
			{
				beforeData = tempData;
			}
		}
		return Integer.toString(beforeData);
	}
	
	//최소 값 구하는 함수
	public static String getMinData(ArrayList<String> list)
	{
		int beforeData = 0;
		
		for(int i=0; i<list.size(); i++)
		{
			int tempData = Integer.parseInt(list.get(i).substring(8).trim());
			
			if(i==0)
			{
				beforeData = tempData;
			}
			
			if(tempData<=beforeData)
			{
				beforeData = tempData;
			}
		}
		return Integer.toString(beforeData);
	}
	
	//평균 값 구하는 함수
	public static String getAvgData(ArrayList<String> list)
	{
		int sumData = 0;
		
		for(int i=0; i<list.size(); i++)
		{
			int tempData = Integer.parseInt(list.get(i).substring(8).trim());
			sumData += tempData;
		}
		
		String pattern = "####.##";
		DecimalFormat format = new DecimalFormat(pattern);
		
		double resultData = sumData/list.size();
		
		
		return Double.toString(resultData);
	}
	
	

}
