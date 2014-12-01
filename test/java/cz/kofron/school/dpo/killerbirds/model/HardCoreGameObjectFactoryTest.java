package cz.kofron.school.dpo.killerbirds.model;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import cz.kofron.school.dpo.killerbirds.model.objects.EnemyType;
import cz.kofron.school.dpo.killerbirds.model.objects.movement.HardCoreMovementStrategy;

import static org.junit.Assert.*;

public class HardCoreGameObjectFactoryTest
{

	@Test
	public void testCreateEnemy() throws Exception
	{
		HardCoreGameObjectFactory hardCoreGameObjectFactory = new HardCoreGameObjectFactory();
		assertThat(hardCoreGameObjectFactory.createEnemy(0, 0, EnemyType.ONE).getMovementStrategy(), CoreMatchers.instanceOf(HardCoreMovementStrategy.class));
	}
}