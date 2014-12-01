package cz.kofron.school.dpo.killerbirds.model.objects;

import org.junit.Test;

import cz.kofron.school.dpo.killerbirds.model.objects.collision.CollisionProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.MovementProperty;
import cz.kofron.school.dpo.killerbirds.model.objects.util.GameObjectCollisionImpl;

import static org.junit.Assert.*;

public class GameObjectCollisionTest
{
	private GameObject setupObjectA()
	{
		CollisionProperty collisionProperty = new CollisionProperty(20); // radius of 20
		MovementProperty movementProperty = new MovementProperty(-5, -5, 0, 0, 0);
		return new GameObjectCollisionImpl(collisionProperty, movementProperty);
	}

	private GameObject setupObjectB()
	{
		CollisionProperty collisionProperty = new CollisionProperty(20); // radius of 20
		MovementProperty movementProperty = new MovementProperty(5, 5, 0, 0, 0);
		return new GameObjectCollisionImpl(collisionProperty, movementProperty);
	}

	private GameObject setupObjectC()
	{
		CollisionProperty collisionProperty = new CollisionProperty(20); // radius of 20
		MovementProperty movementProperty = new MovementProperty(46, 46, 0, 0, 0);
		return new GameObjectCollisionImpl(collisionProperty, movementProperty);
	}

	@Test
	public void testCollidesWith() throws Exception
	{
		GameObject objA = setupObjectA();
		GameObject objB = setupObjectB();
		GameObject objC = setupObjectC();

		assertTrue(objA.collidesWith(objB));
		assertFalse(objB.collidesWith(objC));
	}
}