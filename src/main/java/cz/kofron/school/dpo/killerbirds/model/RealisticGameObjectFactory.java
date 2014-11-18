package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.RealisticEnemy;
import cz.kofron.school.dpo.killerbirds.model.objects.RealisticMissile;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class RealisticGameObjectFactory extends AbstractGameObjectFactory
{
	@Override
	public Enemy createEnemy(float x, float y, EnemyType type)
	{
		return new RealisticEnemy(x, y, type);
	}

	@Override
	public Missile createMissile(float x, float y, float speedX, float speedY)
	{
		return new RealisticMissile(x, y, speedX, speedY);
	}
}
