import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
class MyLabel extends JLabel {
 int maxBarSize;
 int full;
 int 재료;
 
 MyLabel(int maxBarSize){
  this.maxBarSize = maxBarSize;
  //초기화
  재료=0;
 }
 @Override
 protected void paintComponent(Graphics g) {
  // TODO Auto-generated method stub
  super.paintComponent(g);
  g.setColor(Color.white);
  int height = (int)(((double)(this.getHeight()))/maxBarSize*full);
                                                     
  g.fillRect(0, 0, this.getWidth(), height);
  System.out.println(height);
  System.out.println(this.getHeight());
 }
 
 
}
public class CoffeeMachine extends JFrame {
 Container contentPane;
 JLabel title = new JLabel("Welcome, YangHa CoffeeShop^____^", JLabel.CENTER);
 String [] menu_text = {"Americano","VanillaLatte","CreamLatte", "Reset","Close"};
 JButton[] btn = new JButton[5];
 JPanel top_panel = new JPanel();
 JPanel menu = new JPanel();
 JPanel coffee = new JPanel();
 MyLabel[] bar = new MyLabel[5];
 JLabel[] 재료 = new JLabel[5];
 String [] bar_name = {"Cup","Coffee","Water","Sugar", "Cream"};
 ImageIcon image = new ImageIcon("C:\\Users\\pc\\OneDrive\\바탕 화면\\image\\coffee.png");
 JLabel coffee_image = new JLabel(image);
 public CoffeeMachine() {
  // TODO Auto-generated constructor stub
  
  
  
  setTitle("- YangHa CoffeeShop -");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  contentPane = getContentPane();
  contentPane.setLayout(new BorderLayout());
  
 
  top_panel.setBackground(Color.YELLOW);
  top_panel.add(title);
  contentPane.add(top_panel, BorderLayout.NORTH);
  for(int i=0;i<btn.length;i++){
   btn[i] = new JButton(menu_text[i]);
   btn[i].setSize(100,50);
   btn[i].addActionListener(new MyActionListener());
   menu.add(btn[i]);
   
  }
  /*센터 커피 그리기 */
  int width=58;
  Border border = BorderFactory.createLineBorder(Color.black, 1);
  
  for(int i=0;i<bar.length;i++){

   bar[i] = new MyLabel(100);
   bar[i].setBorder(border);
   bar[i].setBackground(Color.LIGHT_GRAY);
   bar[i].setOpaque(true);
   bar[i].setLocation(width,50);
   재료[i] = new JLabel(bar_name[i]);
   재료[i].setSize(100,70);
   재료[i].setLocation(width+40, 280);
   bar[i].setSize(100,254);
   width+=140;
   coffee.add(bar[i]);
   coffee.add(재료[i]);
   
  }
  
  
  coffee_image.setLocation(300, 400);
  coffee_image.setSize(157, 125);
  coffee.add(coffee_image);
  coffee_image.setVisible(false);

  coffee.setLayout(null);
  contentPane.add(menu, BorderLayout.SOUTH);
  contentPane.add(coffee, BorderLayout.CENTER);
  
  //커피 뽑으면 커피 출력
  
  setVisible(true);
  setSize(800, 700);
 }
 class MyActionListener implements ActionListener{
  
  void message() {
   JOptionPane.showMessageDialog(null, "고객님, 커피나왔습니다. 뜨거우니 조심하세요","커피 나왔습니다.", JOptionPane.INFORMATION_MESSAGE);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   JButton jb = (JButton)e.getSource();
   int message=0;
   //자판기 경고문구 때문에 리셋버튼을 상단으로 올려서 자판기 경고를  피한다.
   if(jb.equals(btn[3])){
    bar[0].full = 0; bar[0].재료 = 0;
    bar[1].full = 0; bar[0].재료 = 0;
    bar[2].full = 0; bar[0].재료 = 0;
    bar[3].full = 0; bar[0].재료 = 0;
    bar[4].full = 0; bar[0].재료 = 0;
    coffee_image.setVisible(false);
    repaint();
    System.out.println("리셋");
   }
   
   
   for(int i=0;i<bar.length;i++){
    if(bar[i].재료 == 8) {
     JOptionPane.showMessageDialog(null, "부족한 재료를 채워주세요.","커피 자판기 경고", JOptionPane.ERROR_MESSAGE);
     coffee_image.setVisible(false);
     message=1;
    }
    break;
   }
   if(message==0){
    
   
   if(jb.equals(btn[0])){
    
    
    bar[0].full += 13; bar[0].재료++;
    bar[1].full += 13; bar[1].재료++;
    bar[2].full += 13; bar[2].재료++;
    repaint();
    System.out.println("Americano 입니다.");
    coffee_image.setVisible(true);
    message();
   }
   else if(jb.equals(btn[1])){
    bar[0].full += 13; bar[0].재료++;
    bar[1].full += 13; bar[1].재료++;
    bar[2].full += 13; bar[2].재료++;
    bar[3].full += 13; bar[3].재료++;
    repaint();
    System.out.println("VanillaLatte 입니다.");
    coffee_image.setVisible(true);
    message();
   }
   else if(jb.equals(btn[2])){
    bar[0].full += 13;  bar[0].재료++;
    bar[1].full += 13;  bar[1].재료++;
    bar[2].full += 13;  bar[2].재료++;
    bar[3].full += 13;  bar[3].재료++;
    bar[4].full += 13;  bar[4].재료++;
    repaint();
    System.out.println("CreamLatte 입니다.");
    coffee_image.setVisible(true);
    message();
   }
   else if(jb.equals(btn[4])) {
	   System.exit(0);
   }
  }
  }
 }
 public static void main(String[] args) {
  
  // TODO Auto-generated method stub
  new CoffeeMachine();
 }
}

