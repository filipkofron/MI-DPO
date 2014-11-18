package cz.kofron.school.dpo.killerbirds.model.objects;

import cz.kofron.school.dpo.killerbirds.model.GameObject;

/**
 * Added by Filip Kofron on 4.11.14.
 */
public class Enemy extends GameObject
{
	public final static String NAME_1 = "enemy1";
	public final static String NAME_2 = "enemy2";

	private static String getTypeString(EnemyType type)
	{
		switch (type)
		{
			case ONE:
				return NAME_1;
			case SECOND:
			default:
				return NAME_2;
		}
	}

	protected Enemy(float x, float y, EnemyType type)
	{
		super(x, y, 20, getTypeString(type));
	}

	@Override
	public void update()
	{

	}
}
