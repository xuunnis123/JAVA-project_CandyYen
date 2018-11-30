

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gamestart extends JFrame{

	private JButton gameOne;
	private JButton gameTwo;

	public gamestart()
	{
		super("Start Game");
		setSize(600, 500); 
	    setVisible(true); 
		setBack(); //調用背景方法
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//設置背景
	    JPanel jpanelBack = new JPanel(); //創建個JPanel
        jpanelBack.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
        container.add(jpanelBack);
       // setSize(600, 500);
        setVisible(true);

		gameOne = new JButton("射好射滿");
		
		gameOne.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					game2 game22 = new game2();
					setVisible(false);
				}
				
			}
			);

		container.add(gameOne);
		
		
	   
	   ImageIcon img = new ImageIcon("");
       JLabel imgSet = new JLabel(img);

       container.add(imgSet);

	}
	
	public void setBack(){
		((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("女朋友2.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
	
	
}
