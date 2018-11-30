

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Billing_bill extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField textMoney;
	private JTextField textRemark;
	private JComboBox comboYear;
	private JComboBox comboMonth;
	private JComboBox comboDay;
	private JComboBox comboThing;
	private JButton buttonComplete;
	private JButton buttonBack;
	
	String[] yearOption = {"None","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028"};
	String[] monthOption = {"None","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	String[] dayOption = {"None","1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] thingOption = {"None","Food costs","Snack&Drinks","Necessary expenses","Stationery&Books","Dress&Accessories","Medical&Insurance","Hair&Skin care","Other"};

	String yearSave;
	String monthSave;
	String daySave;
	String thingSave;
	String remarkSave;
	String moneySave;
	
	String yearNow;
	String monthNow;
	String dayNow;
	
	static Connection connection = null;
	static String qry1;
	static Statement st;
	
	/*public static void main(String[] args)throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing_bill window = new Billing_bill();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功連結MySQLToJava");
			
			String dataSource = "jdbc:mysql://localhost/java_finalproject?user=root&password=";
			
			connection = DriverManager.getConnection(dataSource);
			System.out.println("連接成功MySQL");
			st = connection.createStatement();
			
			st.executeQuery("SELECT * FROM billing_info");
			ResultSet rs = st.getResultSet();
			connection.close();
		}catch(Exception e)
		{
			System.out.println("^Q^");
		}
	}*/


	public Billing_bill(String year, String month, String day) {
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
		
		buttonBack = new JButton("返回");
		buttonBack.setBounds(14, 433, 99, 27);
		frame.getContentPane().add(buttonBack);
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(this);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd == "complete") {
			yearSave = yearOption[comboYear.getSelectedIndex()];			
			monthSave = monthOption[comboMonth.getSelectedIndex()];			
			daySave = dayOption[comboDay.getSelectedIndex()];			
			thingSave = thingOption[comboThing.getSelectedIndex()];			
			remarkSave = textRemark.getText();			
			moneySave = textMoney.getText();
			qry1 = "INSERT INTO billing_info VALUES('"+monthSave+"','"+daySave+"','"+thingSave+"','"+moneySave+"','"+remarkSave+"','"+yearSave+"')";
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				String dataSource = "jdbc:mysql://localhost/java_finalproject?user=root&password=";
				Connection conn = DriverManager.getConnection(dataSource);
				Statement st = conn.createStatement();
				st.executeUpdate(qry1);
				conn.close();
			} 
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
			frame.dispose();
		}
		if(cmd == "back") {
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
			frame.dispose();
		}
	}
}

