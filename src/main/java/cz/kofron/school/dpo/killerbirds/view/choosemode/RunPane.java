package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Added by Filip Kofron on 18.11.14.
 */
public class RunPane extends JPanel
{
	public RunPane(SettingsWindow settingsWindow)
	{
		setLayout(new FlowLayout());

		JButton runButton = new JButton("Run");
		runButton.addActionListener(new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				settingsWindow.runGame();
			}
		});

		add(runButton);
	}
}
