package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.GameObject;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Collision extends GameObject
{
	public final static String NAME = "collision";

	public Collision(GameObject gameObject)
	{
		super(gameObject.getX(), gameObject.getY(), gameObject.getR(), NAME);
	}

	@Override
	public void update()
	{

	}
}
