package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.KillerBirds;

/**
 * Created by kofee on 30.11.2014.
 */
public class ModerateEnemySpawner extends EnemySpawner
{
	public ModerateEnemySpawner()
	{
		super(KillerBirds.model.getSettings().getEnemySpawnerModerateProbability(), KillerBirds.model.getSettings().getEnemySpawnerModeratePerFrame());
	}
}
