import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
public class SimpleTask extends TimerTask
{

	public void run()
	{
		  Random r=new Random();
	      int ran=	r.nextInt(6);
	      String mes= mes(ran);
	      message(mes);
	      System.out.printf("%s",mes);
	      
	}
	
	public String message(String mes) {
		Random r=new Random();
	    int ran=	r.nextInt(6);
	    mes= mes(ran);
		return mes;
		// TODO Auto-generated method stub
		
	}
	private String mes(int r) {
		// TODO Auto-generated method stub
		if(r==0) {return "寶貝安安~~在幹嘛?";}
		if(r==1) {return "寶貝早安，起床了嗎?";}
		if(r==2) {return "寶貝早安，起床了嗎?";}
		if(r==3) {return "寶貝晚安，要夢到我哦~~";}
		if(r==4) {return "寶貝午安，今天是個適合想你的天氣呢~";}
		if(r==5) {return "寶貝，好想你哦~";}
		if(r==6) {return "寶貝今天風好大，我的心都吹到你那了!";}
		if(r==7) {return "寶貝，沙朗黑唷~";}
		return null;}
	public static void main(String[] args){
		//建立計時器
		Timer timer = new Timer();

		
		timer.schedule(new SimpleTask(), 0, 2000);
	}
}