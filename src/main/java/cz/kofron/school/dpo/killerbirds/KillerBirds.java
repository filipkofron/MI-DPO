package cz.kofron.school.dpo.killerbirds;

import cz.kofron.school.dpo.killerbirds.controller.Controller;
import cz.kofron.school.dpo.killerbirds.model.GameMode;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.view.View;
import cz.kofron.school.dpo.killerbirds.view.choosemode.ModeSelector;

/**
 * Created by kofee on 21.10.14.
 */
public class KillerBirds
{
	public static Model model;
	public static View view = new View();
	public static Controller controller = new Controller();

	public static void main(String[] args) throws Exception
	{
		if(args.length == 0 || args.length > 1)
		{
			new ModeSelector().setVisible(true);
			return;
		}

		if(args[0].equals("realistic"))
		{
			model = new Model(GameMode.REALISTIC);
		}

		if(args[0].equals("simple"))
		{
			model = new Model(GameMode.SIMPLE);
		}

		if(model == null)
		{
			throw new Exception("Invalid arguments. Use simple or realistic arguments.");
		}

		model.initialize();

		view.init();
		controller.init();

		model.startup();

	}
}
