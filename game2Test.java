
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class game2Test {
	   public static void main(String[] args)
	   { 		
		   game2 game22 = new game2(); //名稱改一改，啟動UI元件
	       game22.addWindowListener(new WindowAdapter(){ 
	       public void windowClosing(WindowEvent e)
	       {
	    	   System.exit(0);
	    	   }
	       }); //處理視窗關閉要求
	   } 
}
