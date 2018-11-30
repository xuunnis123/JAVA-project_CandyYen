

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Billing_main extends JFrame implements ActionListener{

	private JFrame frame;
	
	String yearNow;
	String monthNow;
	String dayNow;
	
	private JLabel label7;
	
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Billing_main window = new Billing_main();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Billing_main(String year, String month, String day) 
	{
		initialize(year, month, day);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String year, String month, String day) {
		yearNow = year;
		monthNow = month;
		dayNow = day;
		/*************************************************************************/
		String[] years = new String[6];
		String[] months = new String[6];
		String[] days = new String[6];
		String[] things = new String[6];
		String[] moneys = new String[6];
		String[] remarks = new String[6];
		int haveData[] = new int[6];
		int totalMoney = 0;
		/*************************************************************************/
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton buttonBefore = new JButton("前一天");
		buttonBefore.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonBefore.setBounds(14, 13, 101, 35);
		frame.getContentPane().add(buttonBefore);
		buttonBefore.setActionCommand("prev");
		buttonBefore.addActionListener(this);
		
		JButton buttonNext = new JButton("下一天");
		buttonNext.setFont(new Font("新細明體", Font.PLAIN, 15));
		buttonNext.setBounds(317, 13, 101, 35);
		frame.getContentPane().add(buttonNext);
		buttonNext.setActionCommand("next");
		buttonNext.addActionListener(this);
		
		JLabel labelDate = new JLabel(year+"/"+month+"/"+day);
		labelDate.setHorizontalAlignment(SwingConstants.CENTER);
		labelDate.setFont(new Font("細明體_HKSCS", Font.BOLD, 25));
		labelDate.setBounds(129, 13, 174, 35);
		frame.getContentPane().add(labelDate);
		
		JButton buttonBill = new JButton("記帳");
		buttonBill.setBounds(319, 433, 99, 27);
		frame.getContentPane().add(buttonBill);
		buttonBill.setActionCommand("bill");
		buttonBill.addActionListener(this);
		
		JButton buttonBack = new JButton("返回");
		buttonBack.setBounds(14, 433, 99, 27);
		frame.getContentPane().add(buttonBack);
		buttonBack.setActionCommand("back");
		buttonBack.addActionListener(this);
		/*********************************************************/
		JLabel label1 = new JLabel("尚無資料");
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[0]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[0], months[0], days[0], things[0], remarks[0], moneys[0]);
				frame.dispose();}
			}
		});
		label1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label1.setBounds(33, 75, 371, 35);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[1]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[1], months[1], days[1], things[1], remarks[1], moneys[1]);
				frame.dispose();}
			}
		});
		label2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label2.setBounds(33, 123, 371, 35);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("");
		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[2]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[2], months[2], days[2], things[2], remarks[2], moneys[2]);
				frame.dispose();}
			}
		});
		label3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label3.setBounds(33, 171, 371, 35);
		frame.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("");
		label4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[3]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[3], months[3], days[3], things[3], remarks[3], moneys[3]);
				frame.dispose();}
			}
		});
		label4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label4.setBounds(33, 219, 371, 35);
		frame.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("");
		label5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[4]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[4], months[4], days[4], things[4], remarks[4], moneys[4]);
				frame.dispose();}
			}
		});
		label5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label5.setBounds(33, 267, 371, 35);
		frame.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("");
		label6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if(haveData[5]==1) {
				Billing_edit be = new Billing_edit(year, month, day);
				be.set_Value(years[5], months[5], days[5], things[5], remarks[5], moneys[5]);
				frame.dispose();}
			}
		});
		label6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label6.setBounds(33, 315, 371, 35);
		frame.getContentPane().add(label6);
		
		/*************************************************************************/
		JLabel labels[] = new JLabel[6];
		labels[0] =label1;
		labels[1] =label2;
		labels[2] =label3;
		labels[3] =label4;
		labels[4] =label5;
		labels[5] =label6;
		//labels[6] =label7;
		/************************************************************************/
		
		/************************************************************************/
		Connection connection = null;
		try
		{			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功連結MySQLToJava");

			String dataSource = "jdbc:mysql://localhost/java_finalproject?user=root&password=";
			
			connection = DriverManager.getConnection(dataSource);
			System.out.println("連接成功MySQL");
			Statement st = connection.createStatement();
			
			st.executeQuery("SELECT * FROM billing_info");
			ResultSet rs = st.getResultSet();
			rs = st.executeQuery("SELECT * FROM `billing_info` WHERE `month` LIKE "+month+" AND `day` LIKE "+day+" AND `year` LIKE "+year);
			int count = 0;
			while(rs.next())
			{
				
				//System.out.println(rs.getString("month"));
				labels[count].setText(rs.getString("month")+"/"+rs.getString("day")+"-"+rs.getString("thing")+"-"+rs.getString("money")+" NT.-"+rs.getString("remark"));
				years[count] = rs.getString("year");
				months[count] = rs.getString("month");
				days[count] = rs.getString("day");
				things[count] = rs.getString("thing");
				moneys[count] = rs.getString("money");
				remarks[count] = rs.getString("remark");
				haveData[count] = 1;//有值
				totalMoney = Integer.parseInt(moneys[count])+totalMoney;
				System.out.println(totalMoney);
				count++;
			}
		}catch(Exception e)
		{
			System.out.println("^Q^");
		}
		
		label7 = new JLabel("總金額："+totalMoney+" .NT");
		label7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		label7.setBounds(33, 363, 371, 35);
		frame.getContentPane().add(label7);
		
	}
	
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		//修改完成
		if(cmd == "bill") 
		{	
			Billing_bill bb = new Billing_bill(yearNow, monthNow, dayNow);
			frame.dispose();
		}
		//刪除
		if(cmd =="back") {
			mainclass ccc=new mainclass();
			ccc.setSize(800, 600); 
			ccc.setLocation(100,100);
            ccc.setVisible(true);
            frame.dispose();
			//System.exit(0);
		}
		if(cmd =="prev") {
			int days = Integer.parseInt(dayNow);
			days = days - 1;
			dayNow = String.valueOf(days);
			frame.dispose();
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
		}
		if(cmd =="next") {
			int days = Integer.parseInt(dayNow);
			days = days + 1;
			dayNow = String.valueOf(days);
			frame.dispose();
			Billing_main bm = new Billing_main(yearNow, monthNow, dayNow);
		}
	}
}
