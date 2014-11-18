package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public abstract class AbstractGameObjectFactory
{
	public abstract Enemy createEnemy(float x, float y, EnemyType type);

	public abstract Missile createMissile(float x, float y, float speedX, float speedY);

	public Cannon createCannon()
	{
		return new Cannon();
	}
}
