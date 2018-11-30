

import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Billing_edit extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField textMoney;
	private JTextField textRemark;
	private JComboBox comboYear;
	private JComboBox comboMonth;
	private JComboBox comboDay;
	private JComboBox comboThing;
	private JButton buttonComplete;

	String[] yearOption = {"None","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028"};
	String[] monthOption = {"None","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	String[] dayOption = {"None","1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] thingOption = {"None","Food costs","Snack&Drinks","Necessary expenses","Stationery&Books","Dress&Accessories","Medical&Insurance","Hair&Skin care","Other"};
	private JButton buttonDel;
	/*************/
	//存改動後的資料
	String yearSave;
	String monthSave;
	String daySave;
	String thingSave;
	String remarkSave;
	String moneySave;
	/*************/
	//存改動前的資料
	String yearS;
	String monthS;
	String dayS;
	String thingS;
	String remarkS;
	String moneyS;
	/*************/
	//現在要顯示的日期
	String yearNow;
	String monthNow;
	String dayNow;
	
	/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					Billing_edit window = new Billing_edit();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});

	}*/

	
	public Billing_edit(String year, String month, String day) 
	{
		yearNow = year;
		monthNow = month;
		dayNow = day;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		textMoney = new JTextField();
		textMoney.setFont(new Font("新細明體", Font.PLAIN, 25));
		textMoney.setBounds(31, 37, 322, 44);
		frame.getContentPane().add(textMoney);
		textMoney.setColumns(10);
		
		JLabel lblNt = new JLabel("NT.");
		lblNt.setFont(new Font("Yu Gothic", Font.BOLD, 27));
		lblNt.setBounds(367, 37, 57, 44);
		frame.getContentPane().add(lblNt);
		
		JLabel labelYear = new JLabel("選擇年份 :");
		labelYear.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		labelYear.setBounds(31, 114, 103, 19);
		frame.getContentPane().add(labelYear);
		
		JLabel labelMonth = new JLabel("選擇月份 :");
		labelMonth.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		labelMonth.setBounds(148, 114, 103, 19);
		frame.getContentPane().add(labelMonth);
		
		JLabel labelDay = new JLabel("選擇日期 :");
		labelDay.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		labelDay.setBounds(265, 114, 103, 19);
		frame.getContentPane().add(labelDay);
		
		comboYear = new JComboBox(yearOption);
		comboYear.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		comboYear.setBounds(31, 156, 90, 25);
		frame.getContentPane().add(comboYear);
		
		comboMonth = new JComboBox(monthOption);
		comboMonth.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		comboMonth.setBounds(148, 156, 90, 25);
		frame.getContentPane().add(comboMonth);
		
		comboDay = new JComboBox(dayOption);
		comboDay.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		comboDay.setBounds(265, 156, 90, 25);
		frame.getContentPane().add(comboDay);
		
		JLabel labelThing = new JLabel("選擇項目 :");
		labelThing.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		labelThing.setBounds(31, 226, 103, 19);
		frame.getContentPane().add(labelThing);
		
		comboThing = new JComboBox(thingOption);
		comboThing.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		comboThing.setBounds(148, 226, 205, 25);
		frame.getContentPane().add(comboThing);
		
		JLabel labelRemark = new JLabel("備註 :");
		labelRemark.setHorizontalAlignment(SwingConstants.LEFT);
		labelRemark.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		labelRemark.setBounds(31, 298, 103, 19);
		frame.getContentPane().add(labelRemark);
		
		textRemark = new JTextField();
		textRemark.setFont(new Font("新細明體", Font.PLAIN, 15));
		textRemark.setBounds(109, 298, 244, 101);
		frame.getContentPane().add(textRemark);
		textRemark.setColumns(10);
		
		buttonComplete = new JButton("完成");		
		buttonComplete.setBounds(319, 433, 99, 27);
		frame.getContentPane().add(buttonComplete);
		buttonComplete.setActionCommand("complete");
		buttonComplete.addActionListener(this);
		
		buttonDel = new JButton("刪除");
		buttonDel.setActionCommand("");
		buttonDel.setBounds(14, 433, 99, 27);
		frame.getContentPane().add(buttonDel);
		buttonDel.setActionCommand("del");
		buttonDel.addActionListener(this);
		
	}
	//把原數值設為預設值
	public void set_Value(String year, String month, String day, String thing, String remark, String money) {
		//set money
		moneyS = money;
		textMoney.setText(money);
		frame.getContentPane().add(textMoney);
		//set year
		yearS = year;
		for(int count = 0;count<yearOption.length;count++) {
			//System.out.printf("%s %s\n",year,yearOption[count]);
			if(yearOption[count].equals(year)) {
				comboYear.setSelectedIndex(count);
				break;
			}
		}
		frame.getContentPane().add(comboYear);
		//set month
		monthS = month;
		for(int count = 0;count<monthOption.length;count++) {
			if(monthOption[count].equals(month)) {
				comboMonth.setSelectedIndex(count);
				break;
			}
		}
		frame.getContentPane().add(comboMonth);
		//set day
		dayS = day;
		for(int count = 0;count<dayOption.length;count++) {
			if(dayOption[count].equals(day)) {
				comboDay.setSelectedIndex(count);
				break;
			}
		}
		frame.getContentPane().add(comboDay);
		//set thing
		thingS = thing;
		for(int count = 0;count<thingOption.length;count++) {
			if(thingOption[count].equals(thing)) {
				comboThing.setSelectedIndex(count);
				break;
			}
		}
		frame.getContentPane().add(comboThing);
		//set remark
		remarkS = remark;
		textRemark.setText(remark);
		frame.getContentPane().add(textRemark);
	}
	
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		//修改完成
		if(cmd == "complete") 
		{
			yearSave = yearOption[comboYear.getSelectedIndex()];
			monthSave = monthOption[comboMonth.getSelectedIndex()];
			daySave = dayOption[comboDay.getSelectedIndex()];
			thingSave = thingOption[comboThing.getSelectedIndex()];
			remarkSave = textRemark.getText();
			moneySave = textMoney.getText();	
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String dataSource = "jdbc:mysql://localhost/java_finalproject?user=root&password=";
				Connection conn = DriverManager.getConnection(dataSource);
				Statement st = conn.createStatement();
				//create the java mysql update preparestatement
				String qry1 = "UPDATE billing_info SET year = '"+yearSave+"',month = '"+monthSave+"', day = '"+daySave+"', thing = '"+thingSave+"', money = '"+moneySave+"', remark = '"+remarkSave+"' WHERE day = '"+dayS+"'and thing = '"+thingS+"'and money = '"+moneyS+"'and remark = '"+remarkS+"'and month = '"+monthS+"'and year ='"+yearS+"'";
				st.executeUpdate(qry1);		
				conn.close();
			}catch (Exception ec)
			{
				System.err.println("Got an exception! ");
			     System.err.println(ec.getMessage());
			     ec.printStackTrace();
			}
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
			frame.dispose();
		}
		//刪除
		if(cmd =="del") {
			String qry1 = "DELETE from billing_info WHERE day = '"+dayS+"'and thing = '"+thingS+"'and money = '"+moneyS+"'and remark = '"+remarkS+"'and month = '"+monthS+"'and year ='"+yearS+"'";
			System.out.println(qry1);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String dataSource = "jdbc:mysql://localhost/java_finalproject?user=root&password=";
				Connection conn = DriverManager.getConnection(dataSource);
				Statement st = conn.createStatement();
				//create the java mysql update preparestatement
				qry1 = "DELETE from billing_info WHERE day = '"+dayS+"'and thing = '"+thingS+"'and money = '"+moneyS+"'and remark = '"+remarkS+"'and month = '"+monthS+"'and year ='"+yearS+"'";
				System.out.println(qry1);
				st.executeUpdate(qry1);		
				conn.close();
			}catch (Exception ec)
			{
				System.err.println("Got an exception! ");
			     System.err.println(ec.getMessage());
			     ec.printStackTrace();
			}
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
			frame.dispose();
		}
	}

}


/*buttonComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				yearSave = yearOption[comboYear.getSelectedIndex()];
				monthSave = monthOption[comboMonth.getSelectedIndex()];
				daySave = dayOption[comboDay.getSelectedIndex()];
				thingSave = thingOption[comboThing.getSelectedIndex()];
				remarkSave = textRemark.getText();
				moneySave = textMoney.getText();
	
				/*qry1 = "UPDATE billing_info SET year = '"+yearSave+"',month = '"+monthSave+"', day = '"+daySave+"', thing = '"+thingSave+"', money = '"+moneySave+"', remark = '"+remarkSave+"' WHERE day = '"+dayS+"'and thing = '"+thingS+"'and money = '"+moneyS+"'and remark = '"+remarkS+"'and month = '"+monthS+"'and year ='"+yearS+"'";*/
				
			//}
		//});

/*
String query = "update billing_info set month =?,day =?, thing =?, money =?, remark =?, year =? where month =? & day =? & thing =? & money =? & remark =? & year =?";
				PreparedStatement ppstm = conn.prepareStatement(query);
				ppstm.setString(1, monthSave);
				ppstm.setString(2, daySave);
				ppstm.setString(3, thingSave);
				ppstm.setString(4, moneySave);
				ppstm.setString(5, remarkSave);
				ppstm.setString(6, yearSave);
				ppstm.setString(7, monthS);
				ppstm.setString(8, dayS);
				ppstm.setString(9, thingS);
				ppstm.setString(10, moneyS);
				ppstm.setString(11, remarkS);
				ppstm.setString(12, yearS);
				
				//execute
				ppstm.executeUpdate();
*/
