package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.Collider;
import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionCleaner;

/**
 * @author Filip Kofron
 */
public class Model
{
	public final static int TIMER_PERIOD_MS = 16;
	public final static int DEFAULT_WIDTH = 1100;
	public final static int DEFAULT_HEIGHT = 800;
	private ObjectPool objectPool = new ObjectPool();
	private GameTimer timer = null;
	private Collider collider = new Collider();
	private EnemySpawner enemySpawner = new EnemySpawner();
	private CollisionCleaner collisionCleaner = new CollisionCleaner();
	private AbstractGameObjectFactory gameObjectFactory;

	public void initialize()
	{
		timer = new GameTimer(TIMER_PERIOD_MS);
		timer.start();
		timer.registerRunnable(objectPool);
		timer.registerRunnable(collider);
		timer.registerRunnable(enemySpawner);
		timer.registerRunnable(collisionCleaner);
	}

	public Model(GameMode gameMode)
	{
		switch (gameMode)
		{
			case SIMPLE:
				gameObjectFactory = new SimpleGameObjectFactory();
				break;
			case REALISTIC:
				gameObjectFactory = new RealisticGameObjectFactory();
				break;
			default:
		}
	}

	public void startup()
	{
		objectPool.addObject(new Cannon());
	}

	public void onExit()
	{
		timer.stop();
	}

	public ObjectPool getObjectPool()
	{
		return objectPool;
	}

	public Collider getCollider()
	{
		return collider;
	}

	public AbstractGameObjectFactory getGameObjectFactory()
	{
		return gameObjectFactory;
	}
}
