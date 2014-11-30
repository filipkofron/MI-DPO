package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.cannon.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public abstract class AbstractGameObjectFactory
{
	public abstract Enemy createEnemy(float x, float y, EnemyType type);

	public abstract Missile createMissile(float x, float y, float speedX, float speedY);

	public abstract Collision createCollision(MovementProperty movementProperty);

	public Cannon createCannon()
	{
		return new Cannon();
	}
}
