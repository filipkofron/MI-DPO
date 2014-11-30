package cz.kofron.school.dpo.killerbirds.controller;

import java.util.List;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.objects.Cannon;

/**
 * Created by kofee on 21.10.14.
 */
public class CannonController implements KeyboardListener
{
	@Override
	public void onPressed(Key key)
	{
		float moveY = 0.0f;
		float angleChange = 0.0f;

		List<GameObject> resultCannon = KillerBirds.model.getObjectPool().getObjectsByName("cannon");

		Cannon cannon = null;
		if(resultCannon.size() > 0)
		{
			cannon = (Cannon) resultCannon.get(0);
		}
		else
		{
			return;
		}

		if(key == Key.UP)
		{
			moveY += 100.0f;
		}

		if(key == Key.DOWN)
		{
			moveY -= 100.0f;
		}

		if(key == Key.SPACE)
		{
			cannon.shoot();
		}

		if(key == Key.LEFT)
		{
			angleChange -= 0.05;
		}

		if(key == Key.RIGHT)
		{
			angleChange += 0.05;
		}

		moveY /= (float) Model.TIMER_PERIOD_MS;
		cannon.move(0, moveY);
		cannon.getMovementProperty().angle = cannon.getMovementProperty().angle + angleChange;
	}
}
