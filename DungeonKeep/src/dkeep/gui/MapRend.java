package dkeep.gui;


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MapRend extends JPanel{


	protected ImageIcon wall;
	protected ImageIcon hero;
	protected ImageIcon heroWithKey;
	protected ImageIcon guard;
	protected ImageIcon door;
	protected ImageIcon exit_door;
	protected ImageIcon blank_cell;
	protected ImageIcon key;
	protected ImageIcon ogre;
	protected ImageIcon club;
	protected ImageIcon heroArmed;
	protected ImageIcon asleep;
	protected ImageIcon ogrestun;

	public MapRend() {
		super();
	}

	protected  void getImages(char[][] map){

		hero = new ImageIcon(this.getClass().getResource("img/hero.png"));
		guard = new ImageIcon(this.getClass().getResource("img/guard.png"));
		heroWithKey = new ImageIcon(this.getClass().getResource("img/heroKey.png"));
		key = new ImageIcon(this.getClass().getResource("img/key.png"));
		blank_cell = new ImageIcon(this.getClass().getResource("img/cell.png"));
		exit_door = new ImageIcon(this.getClass().getResource("img/exit_door.png"));
		door = new ImageIcon(this.getClass().getResource("img/door.png"));
	    wall = new ImageIcon(this.getClass().getResource("img/wall.png"));
	    ogre = new ImageIcon(this.getClass().getResource("img/ogre.png"));
	    club = new ImageIcon(this.getClass().getResource("img/club.png"));
	    heroArmed = new ImageIcon(this.getClass().getResource("img/heroArmed.png"));
	    asleep = new ImageIcon(this.getClass().getResource("img/asleep.png"));
	    ogrestun = new ImageIcon(this.getClass().getResource("img/stunned.png"));

		scaleAll(map);
		

	}

	private ImageIcon scaleImage(ImageIcon previous , char[][] map) {

		Image img = previous.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / map.length, this.getHeight() / map.length, Image.SCALE_FAST);

		return new ImageIcon(newimg);
	}
	
	private void scaleAll(char[][] map) {
		wall = scaleImage(wall,map);
		guard = scaleImage(guard,map);
		heroWithKey = scaleImage(heroWithKey,map);
		key = scaleImage(key,map); 
		blank_cell = scaleImage(blank_cell,map);
		exit_door = scaleImage(exit_door,map); 
		door = scaleImage(door,map);
		hero = scaleImage(hero,map);
		ogre = scaleImage(ogre , map);
		club = scaleImage(club , map);
		heroArmed = scaleImage(heroArmed , map);
		asleep =  scaleImage(asleep, map);
		ogrestun =  scaleImage(ogrestun, map);
			
	}

	public void paintMap(char[][] map){

		for (int i = 0 ; i < map.length ; i++){
			for (int u = 0 ; u < map[i].length ; u++){

				switch ( map[i][u]){
					case 'X':
						this.add(new JLabel(wall));
						break;
					case 'H':
						this.add(new JLabel(hero)); 
						break;
					case 'G':
						this.add(new JLabel(guard));
						break;
					case 'K':
						this.add(new JLabel(heroWithKey));
						break;
					case 'I':
						this.add(new JLabel(door));
						break;
					case 'S':
						this.add(new JLabel(exit_door));
						break;
					case 'k':  
						this.add(new JLabel(key));
						break;
					case '*':
						this.add(new JLabel(club));
						break;			
					case 'O':
						this.add(new JLabel(ogre));
						break;
					case 'A':
						this.add(new JLabel(heroArmed));
						break;
					case 'g':
						this.add(new JLabel(asleep));
						break;
					case '8':
						this.add(new JLabel(ogrestun));
						break;
					default:
						this.add(new JLabel(blank_cell));
						break;
				}
			}
		}

	}

 public void repaintMap(char[][] map){
 		removeAll();

		repaint();
		
		paintMap(map);
		
		revalidate();
 		
 }



}
