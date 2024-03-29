package cz.kofron.school.dpo.killerbirds.model.objects.movement;

import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Added by Filip Kofron on 29.11.14.
 */
public class SimpleMovementStrategyStrategy extends GravityMovementStrategy
{
	private static MovementProperty movementProperty = new MovementProperty();

	protected void moveByGravity(GameObject gameObject)
	{
		synchronized (movementProperty)
		{
			float timeDelta = 1.0f / Model.TIMER_PERIOD_MS;

			MovementProperty objProp = gameObject.getMovementProperty();

			movementProperty.reset();

			movementProperty.posX = objProp.posX + objProp.speedX * timeDelta * 1.0f;
			movementProperty.posY = objProp.posY + objProp.speedY * timeDelta * 1.0f;

			movementProperty.speedX = objProp.speedX;
			movementProperty.speedY = objProp.speedY - timeDelta * 40.0f;

			objProp.setFrom(movementProperty);
			gameObject.setMovementProperty(objProp);
		}
	}

	@Override
	public void visit(Enemy enemy)
	{
		// do nothing, enemies don't move around
	}
}
