package cz.kofron.school.dpo.killerbirds.model.objects.movement;

import cz.kofron.school.dpo.killerbirds.model.objects.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 29.11.14.
 */
public class ManualMovementStrategy extends MovementStrategy
{
	@Override
	public void visit(Cannon cannon)
	{
		MovementProperty movementProperty = new MovementProperty(cannon.getMovementProperty());
		for(Float x : cannon.getMovementsX())
		{
			movementProperty.posX += x;
		}
		for(Float y : cannon.getMovementsY())
		{
			movementProperty.posY += y;
		}
		cannon.getMovementsX().clear();
		cannon.getMovementsY().clear();
		cannon.setMovementProperty(movementProperty);
	}

	@Override
	public void visit(Enemy enemy)
	{
		// not manually controlled
	}

	@Override
	public void visit(Collision collision)
	{
		// not manually controlled
	}

	@Override
	public void visit(Missile missile)
	{
		// not manually controlled
	}
}
