package cz.kofron.school.dpo.killerbirds;

import cz.kofron.school.dpo.killerbirds.controller.Controller;
import cz.kofron.school.dpo.killerbirds.model.GameMode;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.view.View;

/**
 * Created by kofee on 21.10.14.
 */
public class KillerBirds
{
	public static Model model;
	public static View view = new View();
	public static Controller controller = new Controller();

	public static void main(String[] args)
	{
		if(args.length == 1)
		{
			model = new Model(args[0].equals("real") ? GameMode.REALISTIC : GameMode.SIMPLE);
		}
		else
		{
			model = new Model(GameMode.SIMPLE);
		}

		model.initialize();

		view.init();
		controller.init();

		model.startup();
	}
}
