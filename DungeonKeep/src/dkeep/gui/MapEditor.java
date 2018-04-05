package dkeep.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;

public class MapEditor implements MouseListener{
							
	private JFrame MapEditorframe;
	private char[][] mapEditing;
	private JTextField h ,w;
	private Mapping mapPanel;
	
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
		
		createPanel(10,10);
		getWidth();
		getHeight();
		
		
		
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
		mapPanel = new Mapping(x,y);
		
		mapPanel.setBackground(Color.BLACK);
		
		mapPanel.setBounds(12, 60, 256, 214);
		
		MapEditorframe.getContentPane().add(mapPanel);
		mapPanel.setVisible(false);
	
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
	
	public void getWidth() {
		JLabel width = new JLabel("Width");
		width.setBounds(10 , 5 , 100,20);
		MapEditorframe.getContentPane().add(width);
		
		w= new JTextField();
		w.setBounds(105 , 5 , 100 , 20);
		w.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}			
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}
			}
			
		});
		MapEditorframe.getContentPane().add(w);
		
	}
	
	public void getHeight() {
		
		JLabel height = new JLabel("Heigth");
		height.setBounds(10 , 25 , 100,20);
		MapEditorframe.getContentPane().add(height);
		
		h = new JTextField();
		h.setBounds(105 , 25 , 100 , 20);
		h.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}				
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				int i = checkHeight();
				int u = checkWidth();
				if ((i >= 3 && i <= 10) && (u >= 3 && u <= 10)) {
					mapPanel.setLayout(new GridLayout(u,i));
					mapPanel.setVisible(true);
				}
			}
			
		});
		MapEditorframe.getContentPane().add(h);
	
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
	
	
	
	
	
	public int checkWidth() {
		int width;
		try {
			width = Integer.parseInt(w.getText());
			
		}catch(Exception e){
			return 0;
		}
		
		return (width);
		
	}
	
	public int checkHeight() {
		int height;
		try {
			height = Integer.parseInt(h.getText());
			
		}catch(Exception e){
			return 0;
		}
		
		return ( height);
		
	}
	

	
	
	
}
