package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Created by kofee on 21.10.14.
 */
public class Missile extends GameObject
{
	public final static String NAME = "missile";

	public Missile(MovementProperty movementProperty, MovementStrategy movementStrategy)
	{
		super(new CollisionProperty(20), movementProperty, movementStrategy, NAME);
	}

	@Override
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
		movementStrategy.visit(this);
	}
}
