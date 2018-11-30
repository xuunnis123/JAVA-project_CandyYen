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

		setBack(); //調用背景方法
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		//設置背景
		JPanel jpanelBack = new JPanel(); //創建個JPanel
        jpanelBack.setOpaque(false); //把JPanel設置為透明 這樣就不會遮住後面的背景 這樣你就能在JPanel隨意加元件了
        container.add(jpanelBack);
        setSize(200, 100);
        setVisible(true);
        
        citites = new int [10];
    	stores = new int[10];
    	pictures = new int [10];
    	
    	String cities[] = {"台南", "台北", "台中", "基隆", "基隆", "八方雲集", 
    			"三媽", "吮指王", "基隆", "基隆"};
    	String stores[] = {"牛肉湯", "麻辣火鍋", "紅豆餅", "生魚片", "牛排", "鍋貼", 
    			"臭臭鍋", "雞排", "蔥抓餅", "ㄚMAN "};
    	String pictures[] = {"牛肉湯.jpg", "麻辣火鍋.jpg", "紅豆餅.jpg", "生魚片.jpg", "牛排.jpg", "鍋貼.jpg", 
    			"臭臭鍋.jpg", "雞排.jpg", "蔥抓餅.jpg", "早餐.jpg"};

		shuffleButton = new JButton("Let's start!");
		goHome = new JButton("回去聊天吧");

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
							null, "Do you like" + stores[choice] + "?", "走吧!",
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
								null, "Do you like" + stores[choice] + "?", "走吧!",
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
        ImageIcon img = new ImageIcon("女朋友.jpg");
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