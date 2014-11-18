package cz.kofron.school.dpo.killerbirds.model;

import java.util.List;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class CollisionCleaner implements GameUpdateListener
{
	private final static int COLLISION_TTL = 800;

	@Override
	public void onUpdate()
	{
		ObjectPool objectPool = KillerBirds.model.getObjectPool();
		List<GameObject> collisions = objectPool.getObjectsByName(Collision.NAME);

		long timeNow = System.currentTimeMillis();

		for(GameObject gameObject : collisions)
		{
			if(timeNow - gameObject.getTimeCreated() > COLLISION_TTL)
			{
				objectPool.removeObject(gameObject);
			}
		}
	}
}
