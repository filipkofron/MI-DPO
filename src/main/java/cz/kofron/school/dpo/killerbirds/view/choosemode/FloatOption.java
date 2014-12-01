package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Added by Filip Kofron on 1.12.14.
 */
public class FloatOption extends JPanel
{
	private JTextField textField = new JTextField();

	public FloatOption(String label, float value)
	{
		setLayout(new FlowLayout());
		add(new JLabel(label));
		textField.setText(Float.toString(value));
		textField.setColumns(12);
		add(textField);
	}

	public float getValue()
	{
		return Float.parseFloat(textField.getText());
	}
}
