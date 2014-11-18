package cz.kofron.school.dpo.killerbirds.controller;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.view.View;

/**
 * Created by kofee on 20/10/14.
 */
public class Controller
{
	private LwjglInputDispatcher lwjglInputDispatcher = new LwjglInputDispatcher();

	public LwjglInputDispatcher getLwjglInputDispatcher()
	{
		return lwjglInputDispatcher;
	}

	public void init()
	{
		KillerBirds.view.getLwjglUpdateDispatcher().addListener(lwjglInputDispatcher);
		getLwjglInputDispatcher().addListener(new CannonController());
	}
}
