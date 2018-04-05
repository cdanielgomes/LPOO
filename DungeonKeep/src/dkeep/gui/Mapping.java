package dkeep.gui;

import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

public class Mapping extends MapRend {

	private static final long serialVersionUID = 7637590126641479471L;
	
	public Mapping(int x, int y) {
		super(x,y);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(x,y));
		this.setSize(400, 400);
		this.setVisible(true);
		//getImages();
	}
	
}
