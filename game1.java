

import java.awt.*;
import javax.swing.*;
import java.lang.Runtime;
//import game.Token.Board;
import javax.swing.JFrame;

import static javax.swing.JFrame.*;
import java.awt.event.*;
import java.util.*;
public class game1 {
	 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	int exit=1;
    	
           SnakeGame sg = new SnakeGame(20,30);
                     sg.play('w');
    }

}

class SnakeGame extends gamestartTest implements KeyListener{
	public int exit=0;
	 public static char candy[]= {'C','a','n','d','y','Y','e','n'};
	 public int count=0;
	 public int a=0;
	 
      Board b;
      
      ArrayList<Token> tokens;
      int py, px;
      boolean isEaten=false;
      public SnakeGame(int h, int w){
             b = new Board(h, w, this);
                
             tokens = new ArrayList<>();
             for(int i=0; i<4; i++){
                 Token token = new Token(this, b, tokens.size());
                 token.setInitPos();
                 tokens.add(token);
             }          
      }
      
      public void play(char key){
                 
                  b.clearBoard();
                 
                  if(isEaten) eaten();
                 
                  for(Token tokenss: tokens)
                     tokenss.MoveToken(key);
                  b.paintBoard();       
      }

	public void eaten()
       {
    	  
             isEaten = false;
             Token token = new Token(this, b, tokens.size());
             token.y = tokens.get(tokens.size()-1).y;
             token.x = tokens.get(tokens.size()-1).x;
             token.c = tokens.get(0).c;
             tokens.add(token);
             tokens.get(0).y = new Random().nextInt(b.h-3)+1;
             tokens.get(0).x = new Random().nextInt(b.w-3)+1;
           //  tokens.get(0).c = (char)(new Random().nextInt(26)+97);
             
            	 tokens.get(0).c=(char)candy[a];
            	 a++;
            	 if(a==8) 
            	 {
            		 a=0;
            		 count++;
                 	
                 	if(count==1) 
                 	{
                 		ImageIcon icon = new ImageIcon("答對囉.jpg");
                
    					JOptionPane.showConfirmDialog(
    							null, "寶貝，我就知道你很行！等等犒賞你一下","寶貝CandyYen <3",
    							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
    						exit=1;
    						System.exit(0);
    						
    						//this.setPreferredSize(new Dimension(0,0)));
    						
    				}
                 	gamestartTest gg = new gamestartTest();
                 }
     }
   

    @Override
    public void keyTyped(KeyEvent e) {
           try{
           char key = (""+e.getKeyChar()).toLowerCase().charAt(0);
           if(key=='w'||key=='s'||key=='a'||key=='d')
                   play(key);
           }
           catch(Exception ee){}
     }

    @Override
    public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Token
{		
	public int exit=1;
      SnakeGame sg;
      Board b;
      int id;
      int y,x;
      char c;
      char candy1[]= {'c','a','n','d','y','y','e','n'};
     
      public Token(SnakeGame sg, Board b, int id){
    	 
             this.sg = sg;
             this.b = b;
             this.id = id;
           //  c = (char)(new Random().nextInt(26)+97);
            for(int a=0;a<8;a++)
            {
          	c=candy1[a];
            }
      }
      public void setInitPos(){
             if(id==0){
                    y = 10;
                    x = 10;
             }
             else {
                    y = b.h-4+id;
                    x = b.w-4;
             } 
      }
      
    
      public void MoveToken(char k){
             if(id!=0){
                if(id==1){
                    sg.py = y;
                    sg.px = x;
                    switch(k){
                        case 'w' : y-=1; break;
                        case 's' : y+=1; break;
                        case 'd' : x+=1; break;
                        case 'a' : x-=1; break;
                    }
                    if(b.layout[y][x]=='*') {
                    	ImageIcon icon = new ImageIcon("答錯囉.jpg");
                    	JOptionPane.showConfirmDialog(
    							null, "寶貝，不強一點有辦法保護我嗎？","寶貝CandyYen <3",
    							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
                    	exit=1;
						System.exit(0);		
                    }
                    	else if(y==sg.tokens.get(0).y&&x==sg.tokens.get(0).x){
                            sg.isEaten=true;
                    	}
                    }
                    	else{
                            int ty = y;
                            int tx = x;
                            y = sg.py;
                            x = sg.px;
                            sg.py = ty;
                            sg.px = tx;
                    	}
                	}
             b.layout[y][x] = c;
             //gamestartTest gg = new gamestartTest();
      }
}


class Board{
	
      static JFrame f;
      int h,w;
      char[][] layout;
      public Board(int h, int w, SnakeGame sg){
    	 
             this.h = h;
             this.w = w;
          
             f = new JFrame();   
             
             f.setSize(w*20, h*30);
             Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
             f.setLocation(dim.width/2-f.size().width/2, dim.height/2-f.size().height/2);            
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             f.setLayout(new GridBagLayout());
             f.addKeyListener(sg);
            
             layout = new char [h][w];      
      }
      
      private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}
      
	public void clearBoard(){
             f.getContentPane().removeAll();

             for(int i=0; i<h; i++){
             for(int j=0; j<w; j++){
                 if(i==0||i==h-1||j==0||j==w-1) layout[i][j]='*';
                 else layout[i][j]=' ';
             }                
             }
      }
      
      public void paintBoard(){   
             for(int i=0; i<h; i++){
             for(int j=0; j<w; j++){
                 GridBagConstraints gbc = new GridBagConstraints();
                 JLabel lb = new JLabel(""+layout[i][j]);
                 gbc.gridx = j;
                 gbc.gridy = i;
                 gbc.ipadx = 10;
                 gbc.ipady = 2;
                 gbc.anchor = GridBagConstraints.CENTER;
                 f.add(lb, gbc);
             }
             }
             f.getContentPane().repaint();
             f.setVisible(true);
      }
      
    /*  public  String close(String ccc) {
    	  Board v;
    	  v=Token.b;
    	  if(ccc.equals(ccc)) {v.setVisible();}
		return null;
    	  
      }
     */
}
