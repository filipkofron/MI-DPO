package cz.kofron.school.dpo.killerbirds.model.objects.cannon;

import java.util.LinkedList;
import java.util.Random;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.ManualMovementStrategy;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;

/**
 * Created by kofee on 21.10.14.
 */
public class Cannon extends GameObject
{
	public final static String NAME = "cannon";
	public final static int CANNON_OFFSET = 50;
	private ShootingState shootingState = new SingleShootingState();

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
		shootingState.shoot(movementProperty);
	}

	public void toggleState()
	{
		shootingState = shootingState.nextState();
	}

	@Override
	public void acceptMovementStrategy(MovementStrategy movementStrategy)
	{
		movementStrategy.visit(this);
	}

	@Override
	public void onDespawned()
	{
		KillerBirds.model.getObjectPool().addObject(new Cannon());
	}
}
