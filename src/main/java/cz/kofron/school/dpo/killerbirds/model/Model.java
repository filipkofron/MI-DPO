package cz.kofron.school.dpo.killerbirds.model;

import java.io.Serializable;

import cz.kofron.school.dpo.killerbirds.model.objects.cannon.Cannon;
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
	private EnemySpawner enemySpawner = null;
	private CollisionCleaner collisionCleaner = new CollisionCleaner();
	private AbstractGameObjectFactory gameObjectFactory;

	private ModelSettings settings = new ModelSettings();

	public static class ModelMemento implements Serializable
	{
		private ModelSettings settings;

		private ModelMemento(Model model)
		{
			this.settings = model.settings;
		}

		private void updateModel(Model model)
		{
			model.settings = this.settings;
		}
	}

	public void initialize(ModelSettings modelSettings)
	{
		settings = modelSettings;
		switch (settings.getGameMode())
		{
			case SIMPLE:
				gameObjectFactory = new SimpleGameObjectFactory();
				enemySpawner = new ModerateEnemySpawner();
				break;
			case HARDCORE:
				gameObjectFactory = new HardCoreGameObjectFactory();
				enemySpawner = new InsaneEnemySpawner();
				break;
			default:
		}

		timer = new GameTimer(TIMER_PERIOD_MS);
		timer.start();
		timer.registerRunnable(objectPool);
		timer.registerRunnable(collider);
		timer.registerRunnable(enemySpawner);
		timer.registerRunnable(collisionCleaner);
	}

	public Model()
	{
	}
	public ModelMemento createMemento()
	{
		return new ModelMemento(this);
	}

	public ModelSettings getSettings()
	{
		return settings;
	}

	public void setMemento(ModelMemento memento)
	{
		memento.updateModel(this);
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
