
import java.util.Calendar;



public class Test 
{
	static Calendar cal = Calendar.getInstance();
	static String year = String.valueOf(cal.get(Calendar.YEAR));
	static String month = String.valueOf(cal.get(Calendar.MONTH)+1);
	static String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	
	/*public static void main(String[] args) 
	{
		Billing_main bm = new Billing_main(year, month, day);
	}*/

	
}
