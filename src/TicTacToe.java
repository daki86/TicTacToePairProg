import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TicTacToe extends JFrame {

	private int counter = 1;
	
	private ArrayList<Player> playerList;
	
	private CardLayout cl;
	private GridLayout gl;
	
	private JPanel contentPane;
	private JPanel startPanel;
	private JPanel addPlayerPanel;
	private JPanel addPlayerPanelCenter;
	private JPanel addPlayerPanelBottom;
	private JPanel addPlayerPanelLeft;
	private JPanel addPlayerPanelRight;
	private JPanel playGamePanel;
	private JPanel playGamePanelCenter;
	private JPanel playGamePanelTop;
	private JPanel playGamePanelBottom;
	private JPanel playGamePanelLeft;
	private JPanel playGamePanelRight;
	
	private JTextField txtPlayerName;
	
	private JLabel lblEnterPlayerName;
	private JLabel lblPlayerName;
	private JLabel lblPlayerOne = new JLabel();
	private JLabel lblPlayerTwo = new JLabel();
	
	private JButton btnPlay;
	private JButton btnExit;
	private JButton btnBack;
	private JButton btnAddPlayer;
	private JButton btnStartGame;
	private JButton btnGameMarker [][];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe frame = new TicTacToe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		cl = new CardLayout();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(cl);
		
		setTitle("TicTacToe!");
		
		this.add(contentPane);
		contentPane.add(startPanel(), "startPanel");
		contentPane.add(addPlayerPanel(), "addPlayerPanel");
		contentPane.add(playGamePanel(), "playGamePanel");
		cl.show(contentPane, "startPanel");
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
	}
	
	public JPanel startPanel(){
		
		startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.PAGE_AXIS));
		
		btnPlay = new JButton("Play");
		btnPlay.setMaximumSize(new Dimension(100, btnPlay.getMinimumSize().height));
		btnPlay.setFocusable(false);
		btnPlay.setAlignmentX(CENTER_ALIGNMENT);
		
		btnExit = new JButton("Exit");
		btnExit.setMaximumSize(new Dimension(100, btnPlay.getMinimumSize().height));
		btnExit.setFocusable(false);
		btnExit.setAlignmentX(CENTER_ALIGNMENT);
		
		//Button order
		startPanel.add(Box.createVerticalGlue());
		startPanel.add(btnPlay);
		startPanel.add(Box.createVerticalStrut(25));
		startPanel.add(btnExit);
		startPanel.add(Box.createVerticalGlue());
		
		//startPanel.setBackground(Color.blue);
		
		btnPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				cl.show(contentPane, "addPlayerPanel");
			}
		});
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
		return startPanel;
	}
	
	public JPanel addPlayerPanel(){
		playerList = new ArrayList<>();
		
		addPlayerPanel = new JPanel(new BorderLayout());
		
		addPlayerPanelCenter = new JPanel();
		addPlayerPanelCenter.setLayout(new BoxLayout(addPlayerPanelCenter, BoxLayout.PAGE_AXIS));
		addPlayerPanelCenter.setPreferredSize(new Dimension(250, 200));
		//addPlayerPanelCenter.setBackground(Color.BLUE);
		
		addPlayerPanelBottom = new JPanel();
		//addPlayerPanelBottom.setBackground(Color.green);
		
		addPlayerPanelLeft = new JPanel();
		addPlayerPanelLeft.setPreferredSize(new Dimension(100, 100));
		//addPlayerPanelLeft.setBackground(Color.red);
		
		addPlayerPanelRight = new JPanel();
		addPlayerPanelRight.setPreferredSize(new Dimension(100, 100));
		//addPlayerPanelRight.setBackground(Color.red);
		
		btnBack = new JButton("Back");
		btnBack.setFocusable(false);
		btnBack.setMaximumSize(new Dimension(80, btnBack.getMinimumSize().height));
		
		btnAddPlayer = new JButton("Add Player");
		btnAddPlayer.setFocusable(false);
		btnAddPlayer.setAlignmentX(CENTER_ALIGNMENT);
		btnAddPlayer.setMaximumSize(new Dimension(150, btnAddPlayer.getMinimumSize().height));
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.setFocusable(false);
		btnStartGame.setMaximumSize(new Dimension(150, btnStartGame.getMinimumSize().height));
		btnStartGame.setAlignmentX(CENTER_ALIGNMENT);
		btnStartGame.setVisible(false);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setMaximumSize(new Dimension(150, txtPlayerName.getMinimumSize().height));
		txtPlayerName.setAlignmentX(CENTER_ALIGNMENT);
		
		lblEnterPlayerName = new JLabel("Enter player name");
		lblEnterPlayerName.setAlignmentX(CENTER_ALIGNMENT);
		
		lblPlayerName = new JLabel("");
		lblPlayerName.setBackground(Color.YELLOW);
		//lblPlayerName.setPreferredSize(new Dimension(100, 100));
		lblPlayerName.setOpaque(true);
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Border border = lblPlayerName.getBorder(); 
		//Border margin = new EmptyBorder(0,165,0,50);
		
		//lblPlayerName.setBorder(new CompoundBorder(border, margin));
		
		addPlayerPanelCenter.add(Box.createVerticalGlue());
		addPlayerPanelCenter.add(lblEnterPlayerName);
		addPlayerPanelCenter.add(Box.createVerticalStrut(10));
		addPlayerPanelCenter.add(txtPlayerName);
		addPlayerPanelCenter.add(Box.createVerticalStrut(10));
		addPlayerPanelCenter.add(btnStartGame);
		//addPlayerPanelCenter.add(Box.createVerticalStrut(10));
		addPlayerPanelCenter.add(btnAddPlayer);
		addPlayerPanelCenter.add(Box.createVerticalStrut(10));
		addPlayerPanelCenter.add(lblPlayerName);
		addPlayerPanelCenter.add(Box.createVerticalGlue());
		
		addPlayerPanelBottom.add(btnBack);
		
		addPlayerPanel.add(addPlayerPanelCenter, BorderLayout.CENTER);
		addPlayerPanel.add(addPlayerPanelLeft, BorderLayout.LINE_START);
		addPlayerPanel.add(addPlayerPanelRight, BorderLayout.LINE_END);
		addPlayerPanel.add(addPlayerPanelBottom, BorderLayout.PAGE_END);
		
		txtPlayerName.addKeyListener(new KeyAdapter(){
    		public void keyPressed(KeyEvent e){
    			
    			if(e.getKeyCode() == KeyEvent.VK_ENTER){
    				addPlayerName(txtPlayerName.getText());
    			}
    			
    		}
    	});
		
		btnAddPlayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				addPlayerName(txtPlayerName.getText());
			}
		});
		
		btnStartGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				resetComponents();
				cl.show(contentPane, "playGamePanel");
				lblPlayerOne.setText(""+playerList.get(0).toString());
				lblPlayerTwo.setText(""+playerList.get(1).toString());
			}
		});
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				playerList.clear();
				resetComponents();
				cl.show(contentPane, "startPanel");
			}
		});
		
		return addPlayerPanel;
	}
	
	public JPanel playGamePanel(){
		playGamePanel = new JPanel(new BorderLayout());
		//playGamePanel.setBackground(Color.green);
		
		btnBack = new JButton("Back");
		btnBack.setFocusable(false);
		
		gl = new GridLayout(3,3);
		
		playGamePanelCenter = new JPanel();
		playGamePanelCenter.setLayout(gl);
		
		playGamePanelTop = new JPanel();
		//playGamePanelTop.setLayout(new BoxLayout(playGamePanelTop, BoxLayout.LINE_AXIS));
		//playGamePanelTop.setPreferredSize(new Dimension(500, 100));
		
		playGamePanelBottom = new JPanel();
		playGamePanelBottom.setPreferredSize(new Dimension(500, 100));
		
		playGamePanelLeft = new JPanel();
		playGamePanelLeft.setPreferredSize(new Dimension(100, 100));
		
		playGamePanelRight = new JPanel();
		playGamePanelRight.setPreferredSize(new Dimension(100, 100));
		
		btnGameMarker = new JButton[3][3];
		
		for(int i=0; i<3; i++ ){
			for(int a=0; a<3; a++){
				btnGameMarker[i][a] = new JButton();
				btnGameMarker[i][a].setPreferredSize(new Dimension(10, 10));
				playGamePanelCenter.add(btnGameMarker[i][a]);
			}
		}
		
		playGamePanelTop.add(lblPlayerOne);
		playGamePanelTop.add(Box.createHorizontalStrut(120));
		playGamePanelTop.add(lblPlayerTwo);
		
		playGamePanelBottom.add(btnBack);
		
		playGamePanel.add(playGamePanelTop, BorderLayout.PAGE_START);
		playGamePanel.add(playGamePanelBottom, BorderLayout.PAGE_END);
		playGamePanel.add(playGamePanelLeft, BorderLayout.LINE_START);
		playGamePanel.add(playGamePanelRight, BorderLayout.LINE_END);
		playGamePanel.add(playGamePanelCenter, BorderLayout.CENTER);
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				playerList.clear();
				cl.show(contentPane, "startPanel");
			}
		});
		
		return playGamePanel;
	}
	
	public void resetComponents(){
		txtPlayerName.setText("");
		
		btnAddPlayer.setVisible(true);
		btnStartGame.setVisible(false);	
		txtPlayerName.setEnabled(true);
		
		lblEnterPlayerName.setText("Enter player name");
		lblPlayerName.setText("");
		counter = 1;
	}
	
	public void addPlayerName(String inputName){ 
		String name = "";
		int x = 1;
		
		if(!txtPlayerName.getText().trim().isEmpty()){
		
		if(counter <= 2){
				playerList.add(new Player(inputName));
				
				for(Player p : playerList){
					name += "Player"+x+": "+p.getName()+"<br>";	
					x++;	
				}
				lblPlayerName.setText("<html>"+name+"</html>");
				txtPlayerName.setText("");
				counter++;				
		}
		if(counter > 2){
				btnAddPlayer.setVisible(false);
				btnStartGame.setVisible(true);	
				txtPlayerName.setEnabled(false);
				lblEnterPlayerName.setText("You are ready go!");
			}
		}
	}

}
