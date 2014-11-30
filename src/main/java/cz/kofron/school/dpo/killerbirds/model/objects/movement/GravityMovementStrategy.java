package cz.kofron.school.dpo.killerbirds.model.objects.movement;

import cz.kofron.school.dpo.killerbirds.model.objects.cannon.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 30.11.14.
 */
public abstract class GravityMovementStrategy extends MovementStrategy
{
	@Override
	public void visit(Cannon cannon)
	{
		// none, could be AI
	}

	@Override
	public void visit(Enemy enemy)
	{
		moveByGravity(enemy);
	}

	@Override
	public void visit(Collision collision)
	{
		moveByGravity(collision);
	}

	@Override
	public void visit(Missile missile)
	{
		moveByGravity(missile);
	}

	protected abstract void moveByGravity(GameObject gameObject);
}
