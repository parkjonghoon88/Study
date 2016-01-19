import java.util.Random;

public class Student {
	
	private String STUDENT_NO = "";
	private int STUDENT_JUMSU = 0;
	
	
	public String getSTUDENT_NO() {
		return STUDENT_NO;
	}
	public void setSTUDENT_NO(String sTUDENT_NO) {
		STUDENT_NO = sTUDENT_NO;
	}
	public int getSTUDENT_JUMSU() {
		return STUDENT_JUMSU;
	}
	public void setSTUDENT_JUMSU(int sTUDENT_JUMSU) {
		STUDENT_JUMSU = sTUDENT_JUMSU;
	}
	
	
	
	public String getRandStudentNo()
	{
		String result = "";
		
		int iRandom_No = new Random().nextInt(100000);
		
		
		String str_random = "";
		str_random = String.format("%05d", iRandom_No); 
		
		result = "NT"+ str_random;
		
		return result;
	}
	
	
	public int getRandStudentJumSu()
	{
		int result = new Random().nextInt(100);
		
		return result;
	}


}
