import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author hophuong
 *
 */
public class CFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 500;
	private final int HEIGHT = 150;
	
	JLabel valueLabel;
	JPanel panel;
	
	JTextField setTextField;
	JButton setButton;
	JButton addButton;
	JButton minusButton;
	JButton resetButton;
	
	private void createLabel() {
		valueLabel = new JLabel();
		valueLabel.setText("0");
		valueLabel.setFont(new Font(valueLabel.getFont().getName(), Font.PLAIN, 36));
		panel.add(valueLabel);
	}
	
	private void createSetTextField() {
		setTextField = new JTextField(3);
		setTextField.setText("0");
		panel.add(setTextField);
	}
	
	private void createSetButton(){
		setButton = new JButton("Set");
		setButton.addActionListener(new SetButtonListener());
		panel.add(setButton);
	}
	
	private void createAddButton() {
		addButton = new JButton("+");
		addButton.addActionListener(new AddButtonListener());
		panel.add(addButton);
	}
	
	private void createMinusButton() {
		minusButton = new JButton("-");
		minusButton.addActionListener(new MinusButtonListener());
		panel.add(minusButton);
	}
	
	private void createResetButton() {
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ResetButtonListener());
		panel.add(resetButton);
	}
	
	class SetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int newValue = Integer.parseInt(setTextField.getText());
			valueLabel.setText(""+newValue);
		}
	}
	
	class AddButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int value = Integer.parseInt(valueLabel.getText());
			value++;
			valueLabel.setText(""+ value);
		}
	}
	
	class MinusButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int value = Integer.parseInt(valueLabel.getText());
			value--;
			valueLabel.setText(""+ value);
		}
	}
	
	class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			valueLabel.setText("0");
		}
	}
	
	public CFrame() {
		setSize(WIDTH,HEIGHT);
		panel = new JPanel();
		createLabel();
		createSetTextField();
		createSetButton();
		createAddButton();
		createMinusButton();
		createResetButton();
		add(panel);
	}
}
