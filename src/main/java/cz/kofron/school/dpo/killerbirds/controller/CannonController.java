package cz.kofron.school.dpo.killerbirds.controller;

import java.util.List;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.cannon.Cannon;

/**
 * Created by kofee on 21.10.14.
 */
public class CannonController implements KeyboardListener
{
	@Override
	public void onPressed(Key key)
	{
		List<GameObject> resultCannons = KillerBirds.model.getObjectPool().getObjectsByName("cannon");

		for(GameObject gameObjectCannon : resultCannons)
		{
			float moveY = 0.0f;
			float angleChange = 0.0f;
			Cannon cannon = (Cannon) gameObjectCannon; // we know it's cannon

			if (key == Key.UP)
			{
				moveY += 100.0f;
			}

			if (key == Key.DOWN)
			{
				moveY -= 100.0f;
			}

			if (key == Key.SPACE)
			{
				cannon.shoot();
			}

			if (key == Key.LEFT)
			{
				angleChange -= 0.05;
			}

			if (key == Key.RIGHT)
			{
				angleChange += 0.05;
			}

			if (key == Key.M)
			{
				cannon.toggleState();
			}

			moveY /= (float) Model.TIMER_PERIOD_MS;
			cannon.move(0, moveY);
			cannon.getMovementProperty().angle = cannon.getMovementProperty().angle + angleChange;
		}
	}
}
