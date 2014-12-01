package cz.kofron.school.dpo.killerbirds.model.objects.util;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Created by kofee on 1.12.14.
 */
public class GameObjectCollisionImpl extends GameObject
{

	public GameObjectCollisionImpl(CollisionProperty collisionProperty, MovementProperty movementProperty)
	{
		super(collisionProperty, movementProperty, null, null);
	}

	@Override
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
	}
}
