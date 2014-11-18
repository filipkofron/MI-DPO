package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.GameObject;
import cz.kofron.school.dpo.killerbirds.model.Model;

/**
 * Created by kofee on 21.10.14.
 */
public class Missile extends GameObject
{
	public final static String NAME = "missile";

	private float speedX;
	private float speedY;

	protected Missile(float x, float y, float speedX, float speedY)
	{
		super(x, y, 20, NAME);

		this.speedX = speedX;
		this.speedY = speedY;
	}

	@Override
	public void update()
	{
		float timeConstant = Model.TIMER_PERIOD_MS;

		x += speedX / timeConstant;
		y += speedY / timeConstant;

		speedX *= 1.0f - (0.05f / timeConstant);
		speedY *= 1.0f - (0.05f / timeConstant);

		//speedX -= x * 1.0f / timeConstant;
		//speedY -= y * 1.0f / timeConstant;

		speedX *= 1.0f - (0.1f / timeConstant);
		speedY -= 20.0f / timeConstant;
	}
}
