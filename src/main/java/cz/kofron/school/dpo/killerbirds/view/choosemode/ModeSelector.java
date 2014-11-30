package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import cz.kofron.school.dpo.killerbirds.KillerBirds;

/**
 * Added by Filip Kofron on 18.11.14.
 */
public class ModeSelector extends JFrame
{
	public ModeSelector() throws HeadlessException
	{
		super("Killer birds - Mode selection");
		setLayout(new BorderLayout());
		add(new JLabel("Choose mode:"), BorderLayout.NORTH);
		add(new ModeButtonPane(this), BorderLayout.CENTER);
		pack();
	}

	public void selectSimple()
	{
		String [] args = {"simple"};
		try
		{
			KillerBirds.main(args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		setVisible(false);
	}

	public void selectRealistic()
	{
		String [] args = {"realistic"};
		try
		{
			KillerBirds.main(args);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		setVisible(false);
	}
}
