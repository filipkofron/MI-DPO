package cz.kofron.school.dpo.killerbirds.model.objects;

import java.util.LinkedList;
import java.util.Random;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.ManualMovementStrategy;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

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

	private LinkedList<Float> moveXs = new LinkedList<>(); // movements to be done
	private LinkedList<Float> moveYs = new LinkedList<>(); // movements to be done

	private static MovementProperty prepareMovement()
	{
		MovementProperty movementProperty = new MovementProperty();
		movementProperty.posX = -Model.DEFAULT_WIDTH / 2 + CANNON_OFFSET;
		return movementProperty;
	}

	public LinkedList<Float> getMovementsX()
	{
		return moveXs;
	}

	public LinkedList<Float> getMovementsY()
	{
		return moveYs;
	}

	public synchronized void move(float dx, float dy)
	{
		moveXs.add(dx);
		moveYs.add(dy);
	}

	public Cannon()
	{
		super(new CollisionProperty(20), prepareMovement(), new ManualMovementStrategy(), NAME);
	}

	public void shoot()
	{
		long timeDiff = System.currentTimeMillis() - lastFire;

		if (timeDiff > FIRE_PERIOD_MS)
		{
			for (int i = 0; i < 10; i++)
			{
				lastFire = System.currentTimeMillis();

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
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
		movementStrategy.visit(this);
	}
}
