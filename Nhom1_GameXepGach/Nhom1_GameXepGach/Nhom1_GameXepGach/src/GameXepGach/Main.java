/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameXepGach;
/**
 *
 * @author LegenD
 */

public class Main {
	Tetris tetris;
	public Main()
	{
		tetris = new Tetris(this);
        tetris.setLocationRelativeTo(null);
	}
	
	 public static void main(String[] args) {
		 new Main();
	 } 

}
