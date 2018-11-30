import java.awt.*;
import javax.swing.*;

import java.util.Calendar;
import java.util.Scanner;
import java.awt.event.*;
import java.io.*;
import java.util.TimerTask;
public class mainclass extends JFrame implements ActionListener
{
	SimpleTask mes=new SimpleTask();
	/****************/
	static Calendar cal = Calendar.getInstance();
	static String year = String.valueOf(cal.get(Calendar.YEAR));
	static String month = String.valueOf(cal.get(Calendar.MONTH)+1);
	static String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	/****************/
	 /*********************/
	
     /*********************/
	String mm="";
    JButton an1,an2,function1,function2,function3,specialgame;
    JTextField bjk;
    JTextArea area;
    JLabel bq1,bq2;
    //JPanel contPane;
    //JLabel bq3 = new JLabel(new ImageIcon("background.png"));
    JPanel jpanelpic; //創建個JPanel
    
    public static void main(String[] args){
        Write.read();
        new mainclass();
    }
    public mainclass(){
    	setBack();   	       
        an1=new JButton("send");
        an2=new JButton("exit");
        bjk=new JTextField(15);
        area=new JTextArea("\nCandy Yen :\n "+ mes.message(mm));
        bq1=new JLabel("哈囉~~歡迎使用虛擬女友，從今天開始我就是你的貼身情人囉~");
        specialgame=new JButton("離開前陪我玩一下嘛");
        function1=new JButton("增加親密度吧!");
       
        bq2=new JLabel("enter:");
        area.setOpaque(false);
        
        
      //設置背景
      	JPanel jpanelpic=new JPanel();	
        //jpanelpic.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
            
              
              setVisible(true);
        JPanel p1=new JPanel();  
        p1.setOpaque(false); 
        p1.add(jpanelpic);
        area.setRows(10);
        area.setColumns(10);
        //JScrollPane s = new JScrollPane (area);
        //p1.add(s); 
        
        p1.add(bq2);p1.add(bjk);p1.add(an1);p1.add(an2);p1.add(area);
        p1.add(function1);p1.add(specialgame);
        an1.addActionListener(this);
        an1.setActionCommand("go");
        function1.addActionListener(this);
        function1.setActionCommand("play");
        specialgame.addActionListener(this);
        specialgame.setActionCommand("exitgame");
        an2.addActionListener(this);
        an2.setActionCommand("exit");
        this.add(bq1,BorderLayout.NORTH);
        //this.add(function1);
        this.add(area);
        //this.add(s);
        this.add(p1,BorderLayout.SOUTH);
        this.setTitle("Candy Yen 上線囉~");
        this.setSize(800,600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        }
    public void setBack()
    {
		((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("background.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	
        if(e.getActionCommand().equals("go")){
        	
            String text=bjk.getText();
            String texttest=robotedit();
            System.out.println("texttest:"+texttest);            
            area.append("\n\n我：\n"+text+"\n\nCandy Yen：\n"+texttest);
            bjk.setText("");
        }
        else if(e.getActionCommand().equals("play")) 
        {    
        	gamestart choice = new gamestart(); 
        	this.setVisible(false);
        	
        }
        else if(e.getActionCommand().equals("exitgame")) 
        {    
        	   SnakeGame sg = new SnakeGame(20,30);
               sg.play('w');
        	this.setVisible(false);
        	
        }
        
        else if(e.getActionCommand().equals("exit")){
            System.exit(0);
        }
    }
   
    
	/**
	 * @return
	 */
	public String robotedit(){
        try{
        for(int i=0;i<Write.wen.length;i++){
            String mywen=Write.wen[i];
            String tada=Write.da[i];
            System.out.println(mywen);
            System.out.println(tada);
            String text=bjk.getText();
            int bl=text.indexOf(mywen);
            if((bl)==(-1)){
 
            }else 
            	{
            	if(text.equals("寶貝算錢~")) 
            	{ 
            		Billing_main bm = new Billing_main(year, month, day);
                    
                     this.setVisible(false);
            		}
            	else if(text.equals("寶貝我餓餓TAT")) 
            	{ 
            		 JavaFinal choice = new JavaFinal(); 
            		 choice.setSize(1000, 700); 
            		 choice.setVisible(true);
                     this.setVisible(false);
            		}
            	else if(text.equals("寶貝叫叫")) 
            	{ 
            		 AlarmClockFrame choice = new AlarmClockFrame(); 
            		// choice.setSize(1000, 700); 
            		// choice.setVisible(true);
                    this.setVisible(false);
            		}
            	else 
            	{
            	return tada;
            }}
         }       
        }
        catch(Exception ergg){
        }
        System.out.println("WRONG");
        return "矮油~人家聽不懂啦!!";
         
    }
 
}

class Write{
    static String wen[]=new String[1000];
    static String da[]=new String[1000];
    static FileWriter fw;
    static BufferedWriter bw; 
    static FileReader fr;
    static BufferedReader br;
    static int shu=0;
    public static void write(){
    	
 
         try{
            fw=new FileWriter("./talk.txt");
            bw=new BufferedWriter(fw);
           //bw.write("123 哈囉~\n");
            bw.write("你好 哈囉~\n");
            bw.write("寶貝 恩~\n");
            bw.write("想我嗎 好想你~\n");
            bw.write("想你 我也想你~\n");
            bw.write("學貓叫 喵嗚~\n");
            bw.write("學狗叫 汪汪~\n");
            bw.write("學豬叫 ㄍㄡˊ\n");
            
            
           
        }catch(Exception e){}
        finally{
            try{
                bw.flush();
                fw.close();
                bw.close();
            }catch(Exception e){System.out.println(e.toString());}
        }
    }
    public static void read(){
        System.out.println("readStart");
        try{
            File f=new File("./talk.txt");
            System.out.println("set");
            if(f.exists()==false)
            {
                write();
                System.out.println("write");
            }
            fr=new FileReader("./talk.txt");
            br=new BufferedReader(fr); 
            String s="";
            int i=0;
            while((s=br.readLine())!=null){
                System.out.println(s);
                String[] st=s.split(" ");
               // if(st[0]=="123") { System.err.println("oh yeah");}
                System.err.println(st[0]);
                System.err.println(st[1]);
                wen[i]=st[0];
                da[i]=st[1];
                i++;
                System.out.println("No."+i+":"+wen[i]);
                System.out.println("No."+i+":"+da[i]);
            }
 
        }catch(Exception e){System.err.println(e.toString());}
 
    }
}

   