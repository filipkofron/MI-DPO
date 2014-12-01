package cz.kofron.school.dpo.killerbirds.model.objects.movement;


import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Added by Filip Kofron on 29.11.14.
 */
public class HardCoreMovementStrategy extends GravityMovementStrategy
{
	protected void moveByGravity(GameObject gameObject)
	{
		float timeDelta = 1.0f / Model.TIMER_PERIOD_MS;

		MovementProperty movementProperty = new MovementProperty();
		MovementProperty objProp = gameObject.getMovementProperty();


		movementProperty.posX = objProp.posX + objProp.speedX * timeDelta * 1.0f;
		movementProperty.posY = objProp.posY + objProp.speedY * timeDelta * 1.0f;

		movementProperty.speedX = objProp.speedX;
		movementProperty.speedY = objProp.speedY - timeDelta * 40.0f;

		movementProperty.speedX = objProp.speedX - objProp.speedX * timeDelta * 0.1f;
		movementProperty.speedY = objProp.speedY - objProp.speedY * timeDelta * 0.1f - timeDelta * 40.0f;

		gameObject.setMovementProperty(movementProperty);
	}
}
