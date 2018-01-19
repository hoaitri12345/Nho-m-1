/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameXepGach;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LegenD
 */

public class StatusPane extends JPanel implements ActionListener{
	Main myApp;
	OptionPane option;
	JLabel score;
	public StatusPane(Main app)
	{
		myApp = app;
		setPreferredSize(new Dimension(120, 400));
		setBorder(BorderFactory.createEtchedBorder(Color.red, Color.blue));
                setBackground(new java.awt.Color(204, 255, 204));
		initializeComponents();
	}
	private void initializeComponents() {
		setLayout(new GridLayout( 10, 1));
		
		option = new OptionPane(myApp);
		JButton butStart = new JButton("BẮT ĐẦU");
                butStart.setFont(new java.awt.Font("Tahoma", 1, 16));
		butStart.setPreferredSize(new Dimension(100, 40));
                butStart.setBackground(new java.awt.Color(51, 153, 255));
               	butStart.addActionListener(this);
		this.add(butStart);
		
                JButton butOption = new JButton("CHỌN ĐỘ KHÓ");
                butOption.setFont(new java.awt.Font("Tahoma", 1, 11));
		butOption.setPreferredSize(new Dimension(100, 40));
                butOption.setBackground(new java.awt.Color(255, 255, 53));
		butOption.addActionListener(this);
		this.add(butOption);
		
                score = new JLabel("ĐIỂM: 0");
		this.add(score);
	}
	
	public void scored(int score)
	{
		this.score.setText("ĐIỂM: "  +   Integer.toString(score));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "BẮT ĐẦU"){
			myApp.tetris.board.start();
		}
		else
		{
			myApp.tetris.board.stop();
			option.setVisible(true);
		}
	}
}
