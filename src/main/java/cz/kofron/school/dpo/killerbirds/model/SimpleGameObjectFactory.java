package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class SimpleGameObjectFactory extends AbstractGameObjectFactory
{
	@Override
	public Enemy createEnemy(float x, float y, EnemyType type)
	{
		return null;
	}

	@Override
	public Missile createMissile(float x, float y, float speedX, float speedY)
	{
		return null;
	}
}
