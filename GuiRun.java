
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;

public class GuiRun {
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		
		Container pane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(pane, BoxLayout.X_AXIS);
		frame.setLayout(layout);
		
		JPanel board = new SwitchBoard();
		board.setMaximumSize( new Dimension(700, 700) );
		pane.add(board);
		//frame.add(new PullGui(new PullUniverse()));
		pane.add(new EpicGui(new Universe()));
		
		frame.setTitle("Gravity");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(700,700);
	}

}