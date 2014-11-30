package cz.kofron.school.dpo.killerbirds.model.objects.collision;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.GameUpdateListener;
import cz.kofron.school.dpo.killerbirds.model.ObjectPool;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Collider implements GameUpdateListener
{
	private class CollisionPair implements Comparable<CollisionPair>
	{
		public GameObject a;
		public GameObject b;

		public CollisionPair(GameObject a, GameObject b)
		{
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(CollisionPair collisionPair)
		{
			return a.compareTo(collisionPair.a);
		}
	}

	private Set<CollisionPair> checkCollisions()
	{
		ObjectPool objectPool = KillerBirds.model.getObjectPool();
		List<GameObject> missiles = new ArrayList<>(objectPool.getObjectsByName(Missile.NAME));
		List<GameObject> enemies = new ArrayList<>();
		enemies.addAll(objectPool.getObjectsByName(Enemy.NAME_1));
		enemies.addAll(objectPool.getObjectsByName(Enemy.NAME_2));

		Set<CollisionPair> collidedObjects = new TreeSet<>();

		for(GameObject missile : missiles)
		{
			enemies.stream().filter(enemy -> missile.collidesWith(enemy)).forEach(enemy -> {
				collidedObjects.add(new CollisionPair(enemy, missile));
			});
		}

		return collidedObjects;
	}

	@Override
	public void onUpdate()
	{
		Set<CollisionPair> collisions = checkCollisions();

		ObjectPool objectPool = KillerBirds.model.getObjectPool();

		for(CollisionPair pair : collisions)
		{
			MovementProperty movementProperty = new MovementProperty();
			movementProperty.posX = pair.a.getMovementProperty().posX;
			movementProperty.posY = pair.a.getMovementProperty().posY;
			movementProperty.speedX = 2.0f * pair.b.getMovementProperty().speedX - pair.a.getMovementProperty().speedX;
			movementProperty.speedY = 2.0f * pair.b.getMovementProperty().speedY - pair.a.getMovementProperty().speedY;

			objectPool.addObject(
						KillerBirds.model.getGameObjectFactory().createCollision(
								movementProperty));
			objectPool.removeObject(pair.a);
			objectPool.removeObject(pair.b);
		}
	}
}
