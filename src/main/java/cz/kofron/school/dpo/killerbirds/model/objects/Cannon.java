package cz.kofron.school.dpo.killerbirds.model.objects;

import java.util.Random;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.GameObject;
import cz.kofron.school.dpo.killerbirds.model.Model;

/**
 * Created by kofee on 21.10.14.
 */
public class Cannon extends GameObject
{
	private long lastFire = 0;
	private final static int FIRE_PERIOD_MS = 30;
	private Random random = new Random();

	public final static String NAME = "cannon";
	public final static int CANNON_OFFSET = 50;

	private float angle = (float) Math.PI / 4.0f;

	public Cannon()
	{
		super(-Model.DEFAULT_WIDTH / 2 + CANNON_OFFSET, 0, 20, NAME);
	}

	@Override
	public void update()
	{
		// nothing has to be updated
	}

	public float getAngle()
	{
		return angle;
	}

	public void setAngle(float angle)
	{
		this.angle = angle;
	}

	public void shoot()
	{
		long timeDiff = System.currentTimeMillis() - lastFire;

		if (timeDiff > FIRE_PERIOD_MS)
		{
			for (int i = 0; i < 10; i++)
			{
				lastFire = System.currentTimeMillis();

				float vecX = (float) Math.sin(angle) * 200.0f;
				float vecY = (float) Math.cos(angle) * 200.0f;

				float speedX = vecX + random.nextInt(50) - 25;
				float speedY = vecY + random.nextInt(50) - 25;

				Missile missile = KillerBirds.model.getGameObjectFactory().createMissile(x, y,
						speedX, speedY);

				KillerBirds.model.getObjectPool().addObject(missile);
			}
		}
	}
}
