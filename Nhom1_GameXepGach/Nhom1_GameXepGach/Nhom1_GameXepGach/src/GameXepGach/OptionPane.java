/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameXepGach;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author LegenD
 */

public class OptionPane extends JDialog implements ChangeListener, ActionListener{
	Main myApp;
	private JSlider speed;
	private JButton button;
	private JLabel label;
	private JRadioButton radio;
	private ButtonGroup group = new ButtonGroup();
	private JPanel panel;
	private int preSpeed = 3;
	private int difficulty = 1;
	public OptionPane(Main app)
	{
		myApp = app;
		initializeComponents();
		setModal(true);
                setSize(300, 200);
	}
	
	private void initializeComponents() {
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Game speed"));
		label = new JLabel("Current speed: 3");
		panel.add(label, BorderLayout.NORTH);
		speed = new JSlider(1, 5, 3);
		speed.addChangeListener(this);
		speed.setPreferredSize(new Dimension(250, 50));
		panel.add(speed, BorderLayout.CENTER);
		this.add(panel, BorderLayout.NORTH);
		panel.setVisible(false);
		
		panel = new JPanel();
                panel.setBackground(new java.awt.Color(204, 204, 204));
		panel.setBorder(BorderFactory.createTitledBorder("Độ Khó"));
		radio = new JRadioButton("Dễ");
		radio.addActionListener(this);
		radio.setSelected(true);
		group.add(radio);
		panel.add(radio);
		radio = new JRadioButton("Bình Thường");
		radio.addActionListener(this);
		group.add(radio);
		panel.add(radio);
		radio = new JRadioButton("Khó");
		radio.addActionListener(this);
		group.add(radio);
		panel.add(radio);
		this.add(panel, BorderLayout.CENTER);
		
		panel = new JPanel();
		button = new JButton("OK");
		button.setPreferredSize(new Dimension(100, 50));
		button.addActionListener(this);
		panel.add(button, BorderLayout.WEST);
		button = new JButton("Thoát");
		button.setPreferredSize(new Dimension(100, 50));
		button.addActionListener(this);
		panel.add(button, BorderLayout.EAST);
		this.add(panel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com == "OK")
		{
			myApp.tetris.board.setSpeed(speed.getValue());
			switch(difficulty)
			{
				case 1:
					myApp.tetris.board.setDifficulty(7);
					break;
				case 2:
					myApp.tetris.board.setDifficulty(10);
					break;
				case 3:
					myApp.tetris.board.setDifficulty(13);
					break;
			}
			preSpeed = speed.getValue();
			myApp.tetris.board.grabFocus();
			this.setVisible(false);
		}
		else if(com == "Dễ")
		{
			difficulty = 1;
		}
		else if(com == "Bình Thường")
		{
			difficulty = 2;
		}
		else if(com == "Khó")
		{
			difficulty = 3;
		}
		else if(com == "Thoát")
		{
			myApp.tetris.board.grabFocus();
			this.setVisible(false);
		}
	}

	public void stateChanged(ChangeEvent e) {
		if(e.getSource().getClass().toString().endsWith("JSlider"))
		{
			label.setText("Current speed: " + speed.getValue());
		}
	}
}
