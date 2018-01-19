/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameXepGach;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author LegenD
 */

public class Tetris extends JFrame {

    JLabel statusbar;
    Board board;
    Main myApp;
    StatusPane statuspane;
    public Tetris(Main app) {
    	myApp = app;
        setSize(500, 600);
        setTitle(" Game Xếp Gạch_Nhóm 1");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeComponents();
        setVisible(true);
   }

   private void initializeComponents() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu;
		JMenuItem menuitem;
		
		this.setJMenuBar(menubar);
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menuitem = new JMenuItem("Chơi Lại");
		menuitem.setMnemonic(KeyEvent.VK_N);
		menuitem.addActionListener(new MenuHandler(this));
		menu.add(menuitem);
		menu.addSeparator();
		menuitem = new JMenuItem("Thoát");
		menuitem.setMnemonic(KeyEvent.VK_X);
		menuitem.addActionListener(new MenuHandler(this));
		menu.add(menuitem);
		menubar.add(menu);
		
		statuspane = new StatusPane(myApp);
		statusbar = new JLabel("Mời nhấn BẮT ĐẦU để chơi game!");
		board = new Board(myApp, this);
		this.add(statuspane, BorderLayout.EAST);
		this.add(board);
		this.add(statusbar, BorderLayout.SOUTH);
	}

   public JLabel getStatusBar() {
       return statusbar;
   }
   
   public class MenuHandler implements ActionListener
   {
	   Tetris ter;
	   public MenuHandler(Tetris ter)
	   {
		   this.ter = ter;
	   }
	   public void actionPerformed(ActionEvent e) {
		   String s = e.getActionCommand();
		   if(s == "Chơi lại")
		   {
			   board.start();
		   }
		   else if(s == "Thoát")
		   {
			   ter.dispose();
		   }
	   }
   }
	
}