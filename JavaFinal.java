import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JavaFinal extends JFrame{
	private final JButton shuffleButton; //shuffle which to eat
	private final JButton goHome; 
	private JLabel statusLabel;
	private int[] citites;
	private int[] stores;
	private int[] pictures;
	private int choice;
	private JTextField[] displayField;

	public JavaFinal()
	{
		super("Food Choice");

		setBack(); //�եέI����k
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		//�]�m�I��
		JPanel jpanelBack = new JPanel(); //�Ыح�JPanel
        jpanelBack.setOpaque(false); //��JPanel�]�m���z�� �o�˴N���|�B��᭱���I�� �o�˧A�N��bJPanel�H�N�[����F
        container.add(jpanelBack);
        setSize(200, 100);
        setVisible(true);
        
        citites = new int [10];
    	stores = new int[10];
    	pictures = new int [10];
    	
    	String cities[] = {"�x�n", "�x�_", "�x��", "��", "��", "�K�足��", 
    			"�T��", "�m����", "��", "��"};
    	String stores[] = {"���״�", "�»�����", "������", "�ͳ���", "����", "��K", 
    			"�����", "����", "�����", "��MAN "};
    	String pictures[] = {"���״�.jpg", "�»�����.jpg", "������.jpg", "�ͳ���.jpg", "����.jpg", "��K.jpg", 
    			"�����.jpg", "����.jpg", "�����.jpg", "���\.jpg"};

		shuffleButton = new JButton("Let's start!");
		goHome = new JButton("�^�h��ѧa");

		goHome.addActionListener(
				new ActionListener(){			    

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						 mainclass cb = new mainclass(); 
					 cb.setSize(1000, 700);
					
					 setVisible(false);
					 }

					
					}
		            	);
						
		
		shuffleButton.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					JOptionPane.showMessageDialog(null, "Let me think about it~");
					int choice = (int)(Math.random()*10.0);
					displayField[0].setText(cities[choice]);
					displayField[1].setText(stores[choice]);
					statusLabel.setText("Let's go to eat " + stores[choice] + " <3");
					
					ImageIcon icon = new ImageIcon(pictures[choice]);
					int n = JOptionPane.showConfirmDialog(
							null, "Do you like" + stores[choice] + "?", "���a!",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
					if(n==JOptionPane.OK_OPTION) {
						
					}
					while(n==JOptionPane.CANCEL_OPTION) {
						choice = (int)(Math.random()*10.0);
						displayField[0].setText(cities[choice]);
						displayField[1].setText(stores[choice]);
						statusLabel.setText("Let's go to eat " + stores[choice] + " <3");
						
						icon = new ImageIcon(pictures[choice]);
						n = JOptionPane.showConfirmDialog(
								null, "Do you like" + stores[choice] + "?", "���a!",
								JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
					}
				}
			}
			);

		container.add(shuffleButton);
		container.add(goHome);
		displayField = new JTextField[2];
		for(int i=0 ; i<displayField.length ; i++){
			displayField[i] = new JTextField(10);
			displayField[i].setEditable(false);
			container.add(displayField[i]);
		}		
		
		statusLabel = new JLabel();		
		container.add(statusLabel);

	}


	public void setBack(){
		((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("�k�B��.jpg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
	public static void main(String[] args)
	   { 
	      JavaFinal javaFinal = new JavaFinal(); 
	      //javaFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      javaFinal.setSize(400, 600); 
	      //javaFinal.setVisible(true); 
	   } 

}