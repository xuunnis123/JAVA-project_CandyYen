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
		if(r==0) {return "�_���w�w~~�b�F��?";}
		if(r==1) {return "�_�����w�A�_�ɤF��?";}
		if(r==2) {return "�_�����w�A�_�ɤF��?";}
		if(r==3) {return "�_���ߦw�A�n�ڨ�ڮ@~~";}
		if(r==4) {return "�_���Ȧw�A���ѬO�ӾA�X�Q�A���Ѯ�O~";}
		if(r==5) {return "�_���A�n�Q�A�@~";}
		if(r==6) {return "�_�����ѭ��n�j�A�ڪ��߳��j��A���F!";}
		if(r==7) {return "�_���A�F�Զ­�~";}
		return null;}
	public static void main(String[] args){
		//�إ߭p�ɾ�
		Timer timer = new Timer();

		
		timer.schedule(new SimpleTask(), 0, 2000);
	}
}