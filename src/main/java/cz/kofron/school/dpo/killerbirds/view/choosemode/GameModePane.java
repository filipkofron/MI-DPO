package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cz.kofron.school.dpo.killerbirds.model.GameMode;

/**
 * Added by Filip Kofron on 1.12.14.
 */
public class GameModePane extends JPanel
{
	private GameMode gameMode = GameMode.SIMPLE;

	JRadioButton simpleButton = new JRadioButton();
	JRadioButton hardCoreButton = new JRadioButton();

	public GameModePane(GameMode gameMode)
	{
		setLayout(new FlowLayout());
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(simpleButton);
		buttons.add(hardCoreButton);

		switch(gameMode)
		{
			case SIMPLE:
				simpleButton.setSelected(true);
				break;
			case HARDCORE:
				hardCoreButton.setSelected(true);
				break;
		}

		add(new JLabel("Simple:"));
		add(simpleButton);
		add(new JLabel("HardCore:"));
		add(hardCoreButton);
	}

	public GameMode getGameMode()
	{
		return hardCoreButton.isSelected() ? GameMode.HARDCORE : GameMode.SIMPLE;
	}
}
