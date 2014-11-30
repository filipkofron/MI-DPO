package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Enemy extends GameObject
{
	public final static String NAME_1 = "enemy1";
	public final static String NAME_2 = "enemy2";

	private static String getTypeString(EnemyType type)
	{
		switch (type)
		{
			case ONE:
				return NAME_1;
			case SECOND:
			default:
				return NAME_2;
		}
	}

	public Enemy(MovementProperty movementProperty, EnemyType type, MovementStrategy movementStrategy)
	{
		super(new CollisionProperty(20), movementProperty, movementStrategy, getTypeString(type));
	}

	@Override
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
		movementStrategy.visit(this);
	}
}
