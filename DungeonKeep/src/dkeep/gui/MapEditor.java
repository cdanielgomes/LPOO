package dkeep.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MapEditor implements MouseListener{
							
	private JFrame MapEditorframe;
	private JTextField w, h;
	private char[][] mapEditing;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapEditor window = new MapEditor();
					window.MapEditorframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MapEditor() {
		initialize();
	}		

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MapEditorframe = new JFrame();
		MapEditorframe.setBounds(100, 100, 650, 350);
		MapEditorframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapEditorframe.setResizable(false);
		
		MapEditorframe.getContentPane().setLayout(null);

		createOgreButton();
		createHeroButton();
		createFloorButton();
		createHeroClubButton();
		createWallButton();
		createKeyButton();
		createMenuButton();
		createSaveButton();
		createDoorButton();
		w = readWidth();
		h = readHeight();
		checkTextFields();
	}

	public void createOgreButton() {
		JButton OgreButton = new JButton("");
		OgreButton.setBounds(580, 60, 35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/ogre.png"))).getImage();
		OgreButton.setIcon(new ImageIcon(img.getScaledInstance(OgreButton.getWidth() , OgreButton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(OgreButton);
		OgreButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});
	}
	
	public void createPanel(int x, int y) {
		Mapping panel = new Mapping(x,y);
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(12, 60, 256, 214);
		MapEditorframe.getContentPane().add(panel);
	}

	public void createWallButton() {
		JButton WallButton = new JButton("");
		WallButton.setBounds(540, 210, 35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/wall.png"))).getImage();
		WallButton.setIcon(new ImageIcon(img.getScaledInstance(WallButton.getWidth() , WallButton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(WallButton);
		WallButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});

	}
	public void createHeroClubButton() {
		JButton HeroClub = new JButton("");
		HeroClub.setBounds(580, 160, 35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/club.png"))).getImage();
		HeroClub.setIcon(new ImageIcon(img.getScaledInstance(HeroClub.getWidth() , HeroClub.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(HeroClub);
		HeroClub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});
	}
	public void createFloorButton() {
		JButton FloorButton = new JButton("");
		FloorButton.setBounds(500, 160,  35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/cell.png"))).getImage();
		FloorButton.setIcon(new ImageIcon(img.getScaledInstance(FloorButton.getWidth() , FloorButton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(FloorButton);	
		FloorButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			}
		});
	}

	public void createHeroButton() {
		JButton Herobutton = new JButton("");
		Herobutton.setBounds(500, 60, 35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/hero1.png"))).getImage();
		Herobutton.setIcon(new ImageIcon(img.getScaledInstance(Herobutton.getWidth() , Herobutton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(Herobutton);
		Herobutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});
	}


	public void createKeyButton() {
		JButton KeyButton = new JButton("");
		KeyButton.setBounds(500, 110,  35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/key.png"))).getImage();
		KeyButton.setIcon(new ImageIcon(img.getScaledInstance(KeyButton.getWidth() , KeyButton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(KeyButton);
		KeyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});

	}

	public void createDoorButton() {
		JButton DoorButton = new JButton("");
		DoorButton.setBounds(580, 110,  35, 35);
		Image img = (new ImageIcon(MapEditor.class.getResource("/dkeep/gui/img/door.png"))).getImage();
		DoorButton.setIcon(new ImageIcon(img.getScaledInstance(DoorButton.getWidth() , DoorButton.getHeight() , Image.SCALE_FAST)));
		MapEditorframe.getContentPane().add(DoorButton);
		DoorButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			
			}
		});

	}


	public JFrame getFrame() {
		return MapEditorframe;
	}


	public void createMenuButton(){

		JButton Menubutton = new JButton("MENU");
		Menubutton.setBounds(500, 20, 117, 25);
		Menubutton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				System.out.println("1");
				GameWindow.mapE.getFrame().setVisible(false);
				GameWindow.frmDungeonKeep.setVisible(true);
				GameWindow.menuPanel.setVisible(true);


			}

		});

		MapEditorframe.getContentPane().add(Menubutton);

	}

	public void createSaveButton(){

		JButton SaveButton = new JButton("SAVE");
		SaveButton.setBounds(500, 250, 117, 25);
		SaveButton.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){


			}

		});

		MapEditorframe.getContentPane().add(SaveButton);

	}
	
	public JTextField  readWidth() {
		JLabel width = new JLabel("Width");
		width.setBounds(10 , 5 , 100,20);
		MapEditorframe.getContentPane().add(width);
		
		JTextField widthValue = new JTextField();
		widthValue.setBounds(105 , 5 , 100 , 20);
		MapEditorframe.getContentPane().add(widthValue);
		
		return widthValue;
	}
	
	public JTextField readHeight() {
		JLabel height = new JLabel("Heigth");
		height.setBounds(10 , 25 , 100,20);
		MapEditorframe.getContentPane().add(height);
		
		JTextField heightValue = new JTextField();
		heightValue.setBounds(105 , 25 , 100 , 20);
		MapEditorframe.getContentPane().add(heightValue);
		
		return heightValue;
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	int mouseY =  e.getY();
	int mouseX = e.getX();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean fields(String l) {
		
		if(l.equals(""))return true;
		int s= Integer.parseInt(l);
		if (s < 0 || s > 10) return true;
		
		return false;
	}
	
	public void checkTextFields() {
		/*while(fields(w.getText()) || fields(h.getText()) )  {
			
		}*/
		createPanel(2, 4);
	}
}
