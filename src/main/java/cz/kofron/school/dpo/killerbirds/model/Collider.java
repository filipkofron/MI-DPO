package cz.kofron.school.dpo.killerbirds.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Collider implements GameUpdateListener
{
	private Set<GameObject> checkCollisions()
	{
		ObjectPool objectPool = KillerBirds.model.getObjectPool();
		List<GameObject> missiles = new ArrayList<>(objectPool.getObjectsByName(Missile.NAME));
		List<GameObject> enemies = new ArrayList<>();
		enemies.addAll(objectPool.getObjectsByName(Enemy.NAME_1));
		enemies.addAll(objectPool.getObjectsByName(Enemy.NAME_2));

		Set<GameObject> collidedObjects = new TreeSet<>();

		for(GameObject missile : missiles)
		{
			enemies.stream().filter(enemy -> missile.collidesWith(enemy)).forEach(enemy -> {
				collidedObjects.add(enemy);
				collidedObjects.add(missile);
			});
		}

		return collidedObjects;
	}

	@Override
	public void onUpdate()
	{
		Set<GameObject> collisions = checkCollisions();

		ObjectPool objectPool = KillerBirds.model.getObjectPool();

		for(GameObject gameObject : collisions)
		{
			if(gameObject.getName().equals(Enemy.NAME_1) || gameObject.getName().equals(Enemy.NAME_2))
			{
				objectPool.addObject(new Collision(gameObject));
			}
			objectPool.removeObject(gameObject);
		}
	}
}
