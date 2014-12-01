package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.KillerBirds;

/**
 * Created by kofee on 30.11.2014.
 */
public class InsaneEnemySpawner extends EnemySpawner
{
	public InsaneEnemySpawner()
	{
		super(KillerBirds.model.getSettings().getEnemySpawnerHardCoreProbability(), KillerBirds.model.getSettings().getEnemySpawnerHardCorePerFrame());
	}
}
