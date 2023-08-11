package game.view;

import game.controller.SplashScreenButtonAction;
import game.controller.SplashScreenToLevelSelectController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 */
public class SplashScreenView extends JPanel {
	/** The application.*/
	private GameViewApplication app;
	protected int level_number;
	
	/**
	 * The constructor that initializes the start game button
	 * and renders the credits of the Sixes Wild application.
	 * @param app
	 */
	public SplashScreenView(GameViewApplication app, int level_number){
		super();
		this.app = app;
		this.level_number = level_number;
		this.setBounds(0,0,750,666);
		setLayout(null);
		
		JLabel lblSixesWild = new JLabel("Sixes Wild");
		lblSixesWild.setFont(new Font("Trajan Pro", Font.PLAIN, 35));
		lblSixesWild.setHorizontalAlignment(SwingConstants.CENTER);
		lblSixesWild.setBounds(242, 135, 230, 63);
		add(lblSixesWild);
		
		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		btnStartGame.setBounds(294, 288, 133, 23);
		add(btnStartGame);
		btnStartGame.addActionListener(new SplashScreenButtonAction(this.app, level_number));
		
		JButton btnLevelSelect = new JButton("LEVEL SELECT");
		btnLevelSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent beta) {
				new SplashScreenToLevelSelectController(SplashScreenView.this.app).switchPanels();
			}
		});
		btnLevelSelect.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		btnLevelSelect.setBounds(294, 333, 133, 23);
		add(btnLevelSelect);
		
		JLabel lblNewLabel = new JLabel("CREATED BY:");
		lblNewLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(299, 503, 115, 23);
		add(lblNewLabel);
		
		JLabel lblNameLabel = new JLabel("YAO YUAN CHOW");
		lblNameLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameLabel.setBounds(299,530,115,18);
		add(lblNameLabel);
		
		JLabel lblJonathanFriedman = new JLabel("JONATHAN FRIEDMAN");
		lblJonathanFriedman.setHorizontalAlignment(SwingConstants.CENTER);
		lblJonathanFriedman.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblJonathanFriedman.setBounds(284, 549, 145, 18);
		add(lblJonathanFriedman);
		
		JLabel lblIsamuNakagawa = new JLabel("ISAMU NAKAGAWA");
		lblIsamuNakagawa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsamuNakagawa.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblIsamuNakagawa.setBounds(293, 568, 127, 18);
		add(lblIsamuNakagawa);
		
		JLabel lblAlexanderObrien = new JLabel("ALEXANDER O'BRIEN");
		lblAlexanderObrien.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexanderObrien.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblAlexanderObrien.setBounds(284, 586, 145, 18);
		add(lblAlexanderObrien);
		
		JLabel lblGregoryPort = new JLabel("GREGORY PORT");
		lblGregoryPort.setHorizontalAlignment(SwingConstants.CENTER);
		lblGregoryPort.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblGregoryPort.setBounds(292, 604, 128, 18);
		add(lblGregoryPort);
		
		
	}
}
