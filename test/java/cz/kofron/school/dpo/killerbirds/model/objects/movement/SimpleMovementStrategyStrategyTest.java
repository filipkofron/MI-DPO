package cz.kofron.school.dpo.killerbirds.model.objects.movement;

import org.junit.Test;
import org.mockito.Mockito;

import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.util.GameObjectMovementImpl;

import static org.junit.Assert.*;

public class SimpleMovementStrategyStrategyTest
{

	@Test
	public void testStrategyVisitor() throws Exception
	{
		MovementProperty movementProperty = new MovementProperty(0, 0, 0, 0, 0);
		SimpleMovementStrategyStrategy mock = Mockito.mock(SimpleMovementStrategyStrategy.class);
		GameObjectMovementImpl gameObjectMovement = new GameObjectMovementImpl(movementProperty, mock);
		gameObjectMovement.acceptMovementStrategy(mock);
		Mockito.verify(mock).visit(gameObjectMovement);
	}

	@Test
	public void testMoveByGravityPhysics() throws Exception
	{
		MovementProperty movementProperty = new MovementProperty(0, 0, 10, 10, 0);
		float xChangedTo = (1.0f / Model.TIMER_PERIOD_MS) * movementProperty.speedX;
		float yChangedTo = (1.0f / Model.TIMER_PERIOD_MS) * movementProperty.speedY;
		float delta = 0.001f;
		SimpleMovementStrategyStrategy movementStrategyStrategy = new SimpleMovementStrategyStrategy();
		GameObjectMovementImpl gameObjectMovement = new GameObjectMovementImpl(movementProperty, movementStrategyStrategy);
		gameObjectMovement.acceptMovementStrategy(movementStrategyStrategy);
		System.out.println("gameObjectMovement.getMovementProperty().posX: " + gameObjectMovement.getMovementProperty().posX);
		assertEquals(xChangedTo, gameObjectMovement.getMovementProperty().posX, delta);
		assertEquals(yChangedTo, gameObjectMovement.getMovementProperty().posY, delta);
	}
}