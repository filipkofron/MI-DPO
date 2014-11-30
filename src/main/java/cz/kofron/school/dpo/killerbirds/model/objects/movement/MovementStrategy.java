package cz.kofron.school.dpo.killerbirds.model.objects.movement;

import cz.kofron.school.dpo.killerbirds.model.objects.Cannon;
import cz.kofron.school.dpo.killerbirds.model.objects.Collision;
import cz.kofron.school.dpo.killerbirds.model.objects.Enemy;
import cz.kofron.school.dpo.killerbirds.model.objects.Missile;

/**
 * Added by Filip Kofron on 29.11.14.
 */
public abstract class MovementStrategy
{
	public abstract void visit(Cannon cannon);
	public abstract void visit(Enemy enemy);
	public abstract void visit(Collision collision);
	public abstract void visit(Missile missile);
}
