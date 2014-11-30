package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Added by Filip Kofron on 18.11.14.
 */
public class ModeButtonPane extends JPanel
{
	public ModeButtonPane(ModeSelector modeSelector)
	{
		setLayout(new FlowLayout());

		JButton simpleButton = new JButton("Simple");
		simpleButton.addActionListener(new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				modeSelector.selectSimple();
			}
		});

		JButton realisticButton = new JButton("Realistic");
		realisticButton.addActionListener(new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				modeSelector.selectRealistic();
			}
		});

		add(simpleButton);
		add(realisticButton);
	}
}
