

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
		setBack(); //�եέI����k
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//�]�m�I��
	    JPanel jpanelBack = new JPanel(); //�Ыح�JPanel
        jpanelBack.setOpaque(false); //��JPanel�]�m���z�� �o�˴N���|�B��᭱���I�� �o�˧A�N��bJPanel�H�N�[����F
        container.add(jpanelBack);
       // setSize(600, 500);
        setVisible(true);

		gameOne = new JButton("�g�n�g��");
		
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
        ImageIcon img = new ImageIcon("�k�B��2.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
	
	
}
