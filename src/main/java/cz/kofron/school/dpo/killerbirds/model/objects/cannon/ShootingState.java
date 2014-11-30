package cz.kofron.school.dpo.killerbirds.model.objects.cannon;

import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;

/**
 * Created by kofee on 30.11.2014.
 */
public abstract class ShootingState
{
	public abstract void shoot(MovementProperty movementProperty);

	public abstract ShootingState nextState();
}
