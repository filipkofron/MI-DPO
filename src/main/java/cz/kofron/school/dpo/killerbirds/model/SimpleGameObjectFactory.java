package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.SimpleMovementStrategyStrategy;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class SimpleGameObjectFactory extends AbstractGameObjectFactory
{
	@Override
	public Enemy createEnemy(float x, float y, EnemyType type)
	{
		MovementProperty movementProperty = new MovementProperty();
		movementProperty.posX = x;
		movementProperty.posY = y;
		return new Enemy(movementProperty, type, new SimpleMovementStrategyStrategy());
	}

	@Override
	public Missile createMissile(float x, float y, float speedX, float speedY)
	{
		MovementProperty movementProperty = new MovementProperty();
		movementProperty.posX = x;
		movementProperty.posY = y;
		movementProperty.speedX = speedX;
		movementProperty.speedY = speedY;
		return new Missile(movementProperty, new SimpleMovementStrategyStrategy());
	}

	@Override
	public Collision createCollision(MovementProperty movementProperty)
	{
		return new Collision(movementProperty, new SimpleMovementStrategyStrategy());
	}
}
