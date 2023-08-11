package levelbuilder.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import levelbuilder.controller.PanelSwitchingController;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 */
public class SplashScreenView extends JPanel {
	private Application app;
	private JTextField levelNumField;
	
	public SplashScreenView(final Application app ) {
		setLayout(null);
		
		this.app = app;
		
		JLabel lblSixesWildLevel = new JLabel("SIXES WILD LEVEL BUILDER");
		lblSixesWildLevel.setFont(new Font("Levenim MT", Font.ITALIC, 30));
		lblSixesWildLevel.setBounds(188, 51, 403, 50);
		add(lblSixesWildLevel);
		
		JButton btnNewButton = new JButton("CREATE A NEW LEVEL");
		btnNewButton.setFont(new Font("Levenim MT", Font.PLAIN, 45));
		btnNewButton.setBounds(101, 184, 571, 131);
		add(btnNewButton);
		
		JButton btnEditButton = new JButton("EDIT");
		btnEditButton.setFont(new Font("Dialog", Font.PLAIN, 45));
		btnEditButton.setBounds(101, 345, 161, 131);
		add(btnEditButton);
		
		JLabel lblEditLabel = new JLabel("LEVEL");
		lblEditLabel.setFont(new Font("Dialog", Font.PLAIN, 45));
		lblEditLabel.setBounds(292, 368, 145, 82);
		add(lblEditLabel);
		
		levelNumField = new JTextField();
		levelNumField.setHorizontalAlignment(SwingConstants.CENTER);
		levelNumField.setFont(new Font("Dialog", Font.PLAIN, 45));
		levelNumField.setText("1");
		levelNumField.setBounds(449, 383, 90, 50);
		add(levelNumField);
		levelNumField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent beta) {
				new PanelSwitchingController(SplashScreenView.this.app).switchViews();
			}
		});
		
		btnEditButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent beta){
				new PanelSwitchingController(SplashScreenView.this.app).switchViews(SplashScreenView.this.levelNumField.getText());
			}
		});
	}
}
