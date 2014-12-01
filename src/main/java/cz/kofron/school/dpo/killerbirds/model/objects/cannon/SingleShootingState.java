package cz.kofron.school.dpo.killerbirds.model.objects.cannon;

import java.util.Random;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;

/**
 * Created by kofee on 30.11.2014.
 */
public class SingleShootingState extends ShootingState
{
	private long lastFire = 0;
	private final int FIRE_PERIOD_MS = KillerBirds.model.getSettings().getCannonSingleShootPeriod();
	private Random random = new Random();

	@Override
	public void shoot(MovementProperty movementProperty)
	{
		long timeDiff = System.currentTimeMillis() - lastFire;

		if (timeDiff > FIRE_PERIOD_MS)
		{
			lastFire = System.currentTimeMillis();

			for(int i = 0; i < KillerBirds.model.getSettings().getCannonSingleShootAmount(); i++)
			{
				float vecX = (float) Math.sin(movementProperty.angle) * 200.0f;
				float vecY = (float) Math.cos(movementProperty.angle) * 200.0f;

				float speedX = vecX + random.nextInt(50) - 25;
				float speedY = vecY + random.nextInt(50) - 25;

				Missile missile = KillerBirds.model.getGameObjectFactory().createMissile(movementProperty.posX, movementProperty.posY, movementProperty.speedX + speedX, movementProperty.speedY + speedY);

				KillerBirds.model.getObjectPool().addObject(missile);
			}
		}
	}

	@Override
	public ShootingState nextState()
	{
		return new MultipleShootingState();
	}
}
