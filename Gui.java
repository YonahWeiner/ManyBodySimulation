import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gui extends JPanel implements ActionListener{

	public static int P_SIZE = 10;
	public static double T_INTERVAL = .1;
	protected Universe uni;
	public javax.swing.Timer t = new Timer(1, this);
	protected double shiftX = 0, shiftY = 0;

	
	public Gui(Universe u){
		super();
		setBackground(Color.WHITE);
		setSize(700,700);
		uni = u;
		t.start();
		
		JButton button1 = new JButton("<<Add Thing>>");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add random particle
				double mass = 100 + Math.random()* 800;
				double xpos = Math.random() * getWidth();
				double ypos = Math.random() * getHeight();
				Thing newp = new Thing(mass, new Vector(xpos,ypos), new Vector());
				uni.addParticle(newp);
				repaint();
			}
		});
		this.add(button1);
		final JButton button2 = new JButton("<<Pause>>");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(button2.getText().equals("<<Play>>")){
					t.start();
					button2.setText("<<Pause>>");
				}else{
					t.stop();
					button2.setText("<<Play>>");
				}
			}
		});
		this.add(button2);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		ArrayList<Thing> p = uni.getParticles();
		for (int i = 0; i < p.size(); i++)
				g.fillOval((int)(p.get(i).getPos().getX()-P_SIZE/2), (int)(p.get(i).getPos().getY()-P_SIZE/2),
                        (int)(.005*p.get(i).getMass()*P_SIZE), (int)(.005*p.get(i).getMass()*P_SIZE));
	}
	public void actionPerformed(ActionEvent e){
		uni.next(T_INTERVAL);
		repaint();
	}
}
