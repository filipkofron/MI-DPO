package cz.kofron.school.dpo.killerbirds;

import javax.swing.SwingUtilities;

import cz.kofron.school.dpo.killerbirds.controller.Controller;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.ModelSettings;
import cz.kofron.school.dpo.killerbirds.view.View;
import cz.kofron.school.dpo.killerbirds.view.choosemode.SettingsWindow;

/**
 * Created by kofee on 21.10.14.
 */
public class KillerBirds
{
	public static Model model;
	public static View view = new View();
	public static Controller controller = new Controller();

	public static void startGameWith(ModelSettings modelSettings)
	{
		model.initialize(modelSettings);

		view.init();
		controller.init();

		model.startup();
	}

	public static void main(String[] args) throws Exception
	{
		model = new Model();

		SwingUtilities.invokeLater(() -> new SettingsWindow().setVisible(true));
	}
}
