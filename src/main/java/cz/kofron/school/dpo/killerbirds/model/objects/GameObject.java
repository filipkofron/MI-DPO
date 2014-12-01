package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementStrategy;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;

/**
 * @author Filip Kofron
 */
public abstract class GameObject implements Comparable
{
	protected static long counter = 0;
	protected long id = 0;
	protected CollisionProperty collisionProperty;
	protected MovementProperty movementProperty;
	protected MovementStrategy movementStrategy;
	protected long timeCreated = System.currentTimeMillis();
	protected String name;

	public GameObject(CollisionProperty collisionProperty,
	                  MovementProperty movementProperty,
	                  MovementStrategy movementStrategy,
	                  String name)
	{
		this.collisionProperty = collisionProperty;
		this.movementProperty = movementProperty;
		this.movementStrategy = movementStrategy;
		this.name = name;

		id = counter++;
	}

	public boolean collidesWith(GameObject gameObject)
	{
		float rSum = collisionProperty.radius + gameObject.collisionProperty.radius;
		float xd = movementProperty.posX - gameObject.movementProperty.posX;
		float yd = movementProperty.posY - gameObject.movementProperty.posY;

		float dist = (float) Math.sqrt(xd * xd + yd * yd);

		return dist < rSum;
	}

	public CollisionProperty getCollisionProperty()
	{
		return collisionProperty;
	}

	public void setCollisionProperty(CollisionProperty collisionProperty)
	{
		this.collisionProperty = collisionProperty;
	}

	public MovementProperty getMovementProperty()
	{
		return movementProperty;
	}

	public void setMovementProperty(MovementProperty movementProperty)
	{
		this.movementProperty = movementProperty;
	}

	public long getId()
	{
		return id;
	}

	public final void update()
	{
		acceptMovementStrategy(movementStrategy);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public int compareTo(Object o)
	{
		long res = id - ((GameObject) o).id;

		if(res < 0)
		{
			return -1;
		}
		else
		{
			if(res > 0)
			{
				return 1;
			}
		}
		return 0;
	}

	public MovementStrategy getMovementStrategy()
	{
		return movementStrategy;
	}

	public abstract void acceptMovementStrategy(MovementStrategy movementStrategy);

	public long getTimeCreated()
	{
		return timeCreated;
	}

	public void onDespawned()
	{
		// not needed to override
	}
}
