package cz.kofron.school.dpo.killerbirds.model;

import java.util.Random;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.cannon.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class EnemySpawner implements GameUpdateListener
{
	private Random random = new Random();
	private int framePossibilities;
	private int perFrame;

	public EnemySpawner(float frameProbability, int perFrame)
	{
		this.framePossibilities = (int) (1.0f / frameProbability);
		if(framePossibilities < 0)
		{
			framePossibilities = 1;
		}
		this.perFrame = perFrame;
	}

	@Override
	public void onUpdate()
	{
		ObjectPool objectPool = KillerBirds.model.getObjectPool();

		for(int i = 0; i < perFrame; i++)
		{
			if (random.nextInt(framePossibilities) == 0)
			{
				int cannonOffset = Cannon.CANNON_OFFSET * 2;
				float x = Model.DEFAULT_WIDTH / 2 - random.nextInt(Model.DEFAULT_WIDTH - cannonOffset)
						+ cannonOffset;
				float y = Model.DEFAULT_HEIGHT / 2 - random.nextInt(Model.DEFAULT_HEIGHT);

				Enemy enemy = KillerBirds.model.getGameObjectFactory().createEnemy(x, y,
						random.nextBoolean() ? EnemyType.ONE : EnemyType.SECOND);

				objectPool.addObject(enemy);
			}
		}
	}
}
