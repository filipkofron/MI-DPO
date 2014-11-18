package cz.kofron.school.dpo.killerbirds.model.objects;

import java.util.Random;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class RealisticEnemy extends Enemy
{
	public RealisticEnemy(float x, float y, EnemyType type)
	{
		super(x, y, type);
	}

	private int r = new Random().nextInt(30);

	@Override
	public void update()
	{
	//	float time = 0.001f * ((int) (getTimeCreated() - System.currentTimeMillis()));

	//	x += (float) Math.sin(time) * r;
	//	y += (float) Math.cos(time) * r;
	}
}
