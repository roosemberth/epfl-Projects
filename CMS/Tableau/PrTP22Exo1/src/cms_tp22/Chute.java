package cms_tp22;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.util.ArrayList;

public class Chute extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6159473337256212371L;
	public final double  GameVersion = 0.1;
	ChutePanel   AnimationPanel = new ChutePanel();
	JButton StartButton = new JButton("Start");
	JButton StopButton = new JButton("Stop");
	RandomAccessFile GameDatabase = null;
	JLabel Status = new JLabel(new String("Bouncy Ball v" + GameVersion));
	Timer AnimationEngine = new Timer((int)(1000/60), this);
	int topScore = 0;
	int RecordScores[] = {0};
	String[] RecordNames = {"Bouncy Ball"};
	
	public Chute(){
		// Window Initialization
		setTitle("Chute");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 250, 350);
		getContentPane().setPreferredSize(new Dimension(250, 300));
		
		// Add to main window
		add(AnimationPanel, BorderLayout.CENTER);
		add(StartButton, BorderLayout.NORTH);

		JPanel SouthPanel = new JPanel(new FlowLayout());
		add(SouthPanel, BorderLayout.SOUTH);
		SouthPanel.add(StopButton);
		
		JButton Reset = new JButton("Reset");
		JButton Quit = new JButton("Quit");
		SouthPanel.add(Reset);
		SouthPanel.add(Quit);
		Reset.addActionListener(this);
		Quit.addActionListener(this);
		
		SouthPanel.setVisible(true);
		Quit.setVisible(true);
		
		setVisible(true);
		AnimationPanel.setVisible(true);
		StartButton.setVisible(true);
		StartButton.setFont(new Font("Arial", Font.BOLD, 20));
		StartButton.setForeground(Color.BLUE);
		StopButton.setVisible(true);
		
		// Add listeners
		StartButton.addActionListener(this);
		StopButton.addActionListener(this);
		
		/// End Window Initialization
		
		// Game Database //TODO: Add Callum's Record to 62
		boolean retryGameDatabaseFileLoad = false;
		String GameDatabaseFileLocation = "/tmp/BouncyBall.dat";
		do{
			try{
				GameDatabase = new RandomAccessFile(GameDatabaseFileLocation, "rws");
				retryGameDatabaseFileLoad=false;
			} catch(FileNotFoundException fnfE){
				try{
					Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(GameDatabaseFileLocation), "utf-8"));
					writer.write("");
					writer.close();
					if (GameDatabaseFileLocation.equals("/tmp/BouncyBall.dat")) retryGameDatabaseFileLoad = true;
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Could not create Game Database File on " + GameDatabaseFileLocation + (GameDatabaseFileLocation.equals("/tmp/BouncyBall.dat")?", retrying on application path":", Giving up..."));
					System.out.println(ex.getMessage() + "\n\nRetrying on application path");
					GameDatabaseFileLocation = "BouncyBall.dat";
					if (GameDatabaseFileLocation.equals("/tmp/BouncyBall.dat")) retryGameDatabaseFileLoad=true;
				} 
			} catch(SecurityException sE){
				JOptionPane.showMessageDialog(null, "Could acess Game Database file due to insufficient permissions on  " + GameDatabaseFileLocation + (GameDatabaseFileLocation.equals("/tmp/BouncyBall.dat")?", retrying on application path":", Giving up..."));
				System.out.println(sE.getMessage() + "\n\nRetrying on application path");
				GameDatabaseFileLocation = "BouncyBall.dat";
				if (GameDatabaseFileLocation.equals("/tmp/BouncyBall.dat")) retryGameDatabaseFileLoad=true;
			}
		} while (retryGameDatabaseFileLoad);
		
		if (GameDatabase!=null){
			String tmp;
			ArrayList<String> Names = new ArrayList<String>();
			ArrayList<Integer> Scores = new ArrayList<Integer>();
			try{
				while (true){
					tmp = GameDatabase.readUTF();
					Scores.add(Integer.parseInt(tmp.substring(0, tmp.indexOf(' ')-1)));
					Names.add(tmp.substring(tmp.indexOf(' ')));
				}
			} catch (EOFException eofE){
				
			}catch (IOException ioE){
				JOptionPane.showMessageDialog(null, "Error while Reading Game Database File!");
				System.out.println(ioE.getMessage());
			}
			//RecordScores = Scores.toArray();
			//RecordNames = Names.toArray();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getSource().getClass().toString()){
			case "class javax.swing.JButton":
				switch(e.getActionCommand()){
					case "Start":
						AnimationPanel.reset();
						AnimationEngine.start();
						break;
					case "Stop":
						AnimationEngine.stop();
						break;
					case "Reset":
						AnimationEngine.stop();
						AnimationPanel.reset();
						break;
					case "Quit":
						System.exit(0);
						break;
					default:
						System.out.println("Bug!, I recieved " + e.getActionCommand() + " as action command!");
				}
				break;
			case "class javax.swing.Timer":
				AnimationPanel.repaint();
				break;
			default:
				System.out.println("[BUG] Recieved (weird?) action event: " + e.getSource().getClass());
		}
		AnimationPanel.requestFocusInWindow();
	}
	
	class ChutePanel extends JPanel{
		/**
		 * 
		 */
		private static final long	serialVersionUID	= -1583579691959634162L;
		// Render
		private double scale = 1000000;
		private int Radius=10;
		private int LowerBarOffset=20;
		
		//Initial Physics
		private double Position = 0;
		private double Speed = 0;
		private double Acceleration = 10;

		// Internals
		private long lastTime = 0;
		private int lastBallX = 0;
		private int lastBallY = 0;
		private boolean gameover = false;
		private final double defAccel = 10;
		private double jerk = 0.05;
		private long bounces=0;
		public ChutePanel(){
			requestFocusInWindow();			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mouseClicked(e);
					int ClickX=e.getPoint().x;
					int ClickY=e.getPoint().y;
					double distance = Math.sqrt((Math.pow(ClickX-lastBallX, 2)+Math.pow(ClickY-lastBallY, 2)));
					if (distance<4*Radius){
						Speed*=-1.1;
						bounces++;
					}
					AnimationPanel.requestFocusInWindow();
				}
			});
			addKeyListener(new KeyAdapter(){
				@Override
				public void keyTyped(KeyEvent e) {
					switch(e.getKeyCode()){
						case KeyEvent.VK_ENTER:
						case KeyEvent.VK_UP:
							AnimationEngine.start();
							break;
						case KeyEvent.VK_SPACE:
						case KeyEvent.VK_DOWN:
							AnimationEngine.stop();
							break;
						default:
							
					}
					AnimationPanel.requestFocusInWindow();
				};
			});
		}
		
		public void setRadius(int newRadius){
			Radius = newRadius>10?newRadius:Radius;
		}
		public void setAcceleration(double newAccel){
			lastTime=0;
			Acceleration=(newAccel>=0?newAccel:Acceleration);
		}
		public double getAcceleration(){
			return Acceleration;
		}
		private void updatePosition(){
			// dt in miliseconds
			double dt=(System.nanoTime())/(1000000)-lastTime;
			lastTime+=dt;
			Acceleration += jerk*dt;
			Speed += Acceleration*dt;
			Position += Speed*dt; 
		}
		private int getNextHeight(){
			updatePosition();
			double nextPos =Position/scale;
			if (nextPos>(getSize().height-(2*Radius+LowerBarOffset))){
				Position=(getSize().height-(2*Radius+LowerBarOffset))*scale;
				Speed*=-1;
				if (!gameover){
					System.out.println("Game over!");
					gameover=true;
					JOptionPane.showInputDialog("Congratulations! Your record is " + bounces + "!\n Enter your name for the wall of fame!");
				}
			} else if (nextPos<0){
				Acceleration=Math.abs(Acceleration);
				Speed*=-1;
				Position=0;
			}
			return (int) (nextPos);
		}
		public void reset(){
			System.out.println("New Game!");
			bounces=0;
			lastTime=0;
			Position=0;
			Speed=0;
			Acceleration = defAccel;
			gameover=false;
			repaint();
		}
		@Override
		public void paint(Graphics g){
			super.paint(g);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 9));
			//g.drawString("Acceleration: " + Acceleration + ", Speed: " + Speed + ", Position: " + Position, 0, 10);
			g.drawString("Bounces: " + bounces, 0, 10);
			g.setColor(Color.RED);
			lastBallX=this.getSize().width/2-Radius;
			if (lastTime==0) lastTime=System.nanoTime()/1000000;
			lastBallY= getNextHeight();
			g.fillOval(lastBallX, lastBallY, 2*Radius, 2*Radius);
			lastBallX+=Radius;
			lastBallY+=Radius;
			if (gameover) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.BLUE);
			}
			g.drawLine(this.getSize().width/3, this.getSize().height-LowerBarOffset, this.getSize().width*2/3, this.getSize().height-LowerBarOffset);
			Toolkit.getDefaultToolkit().sync();
			if (gameover) AnimationEngine.stop();
		}
	}
}