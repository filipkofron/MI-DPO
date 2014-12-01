package cz.kofron.school.dpo.killerbirds.model.objects.util;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Created by kofee on 1.12.14.
 */
public class GameObjectMovementImpl extends Missile
{
	public GameObjectMovementImpl(MovementProperty movementProperty, MovementStrategy movementStrategy)
	{
		super(movementProperty, movementStrategy);
	}
}
