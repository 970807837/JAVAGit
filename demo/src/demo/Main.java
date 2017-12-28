package demo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main extends Thread implements ActionListener {
	String[] s= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};

private  boolean threadSuspended=false;
	JFrame frame=new JFrame("点名使用");
	JButton btn=new JButton("停止");
	JTextField tf=new JTextField(); 
	public Main(){
		frame.setLayout(null);
		frame.setBounds(300, 400, 300, 350);
		tf.setBounds(100, 40, 120, 30);
		tf.setFont(new Font("Monospaced", 23, 30));
		btn.setBounds(80, 120, 150, 100);
		frame.add(btn);
		frame.add(tf);
		frame.setVisible(true);
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Main m=new Main();
		m.start();
	}
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==btn){
				if(btn.getText().equals("开始")){
					this.resume();
				
					btn.setText("停止");
					
				}else{
					this.suspend();
					
					btn.setText("开始");
				}
				
			}
		}

	public void run(){
		for (int i = 1; i <=21; i++) {

			tf.setText(s[i-1]);
			
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(i==21) i=1;
			
		}
	}
	
}