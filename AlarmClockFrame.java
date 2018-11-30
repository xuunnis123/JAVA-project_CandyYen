

import java.util.*;
import java.io.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat; 

	

public class AlarmClockFrame extends JFrame {

	private JLabel labelTime;
	private JLabel labelTell1;
	private JLabel labelTell2;
	private JLabel labelTell3;
	private JLabel labelTell4;
	private JButton back;
	private JTextField inputTime;
	private JTextField inputMove;
	String ala = "";
	static String mm = "";
	String string = "";
	String a="";
	/**
	 * 
	 */
	public AlarmClockFrame() {
		super("Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(250, 250); 
	    setVisible(true); 
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		back=new JButton("回去聊天吧");
		container.add(back);
		String nowTime = GetCurrentTime("hh:mm:ss"); 
		labelTime = new JLabel();
		labelTime.setText("現在時間:" + nowTime);
		container.add(labelTime);
		
		labelTell1 = new JLabel();
		labelTell1.setText("寶貝，輸入要完成的事還有提醒時間哦\n");
		container.add(labelTell1);
		
		labelTell3 = new JLabel();
		labelTell3.setText("事件 ");
		container.add(labelTell3);
		
		inputMove = new JTextField(10);
		container.add(inputMove);
		
		labelTell2 = new JLabel();
		labelTell2.setText("通知的時間(hh:mm:ss):\n");
		container.add(labelTell2);
	
		inputTime = new JTextField(10);
		container.add(inputTime);
		
		inputTime.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event){
						if(event.getSource()==inputTime) {
							string = String.format("通知的時間(hh:mm:ss): %s", event.getActionCommand());
							ala = event.getActionCommand();
							a=inputTime.getText();
							JOptionPane.showMessageDialog(null, string);
							getin();
						}
						
					}
				});
		back.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{ mainclass cb = new mainclass(); 
					 cb.setSize(800, 600);
						setVisible(false);
					}});
		inputMove.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event){
						if(event.getSource()==inputMove) {
							string = String.format("寶貝，我會提醒你 %s 唷！", event.getActionCommand());
					        mm = event.getActionCommand();
					        
						JOptionPane.showMessageDialog(null, string);
					}}
				});
	}		
	
	
	
    public void getin()
    {
    	String com = a;
    	while (true)
		{
			String nowTime2 = GetCurrentTime("hh:mm:ss"); 
			//System.out.println(nowTime2);		
			if ( nowTime2.equals(com))
			{
				Alarm_UP(3); //����x���a�T */
				break; 
				} 
			}
    	}
	public static String GetCurrentTime(String dateFormat) 
	{ 
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); 
		return sdf.format(cal.getTime()); 
	} //�x�a�{�� num �O�x�a�T������ 
	
	public static void Alarm_UP(int num) 
	{ 
		//char BEE = (char)7; //�͹��n 
		//String line2=doWhatThing();
		/*for (int i=0; i<num; i++)
		{ 
			System.out.println("時間到囉!!寶貝該"+line2+"囉"); 
		} */
		
		for (int i=0; i<3; i++)
		{ 
			JOptionPane.showMessageDialog(null, "時間到囉!!寶貝該"+mm+"囉");
		} 
	} 
}
