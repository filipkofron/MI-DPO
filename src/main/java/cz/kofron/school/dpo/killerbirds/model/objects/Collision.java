package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Collision extends GameObject
{
	public final static String NAME = "collision";

	public Collision(MovementProperty movementProperty, MovementStrategy movementStrategy)
	{
		super(new CollisionProperty(20), movementProperty, movementStrategy, NAME);
	}

	@Override
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
		movementStrategy.visit(this);
	}
}
