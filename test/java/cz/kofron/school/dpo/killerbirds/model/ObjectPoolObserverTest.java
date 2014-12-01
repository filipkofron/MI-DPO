package cz.kofron.school.dpo.killerbirds.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;


@RunWith(MockitoJUnitRunner.class)
public class ObjectPoolObserverTest
{
	@Mock
	ObjectStateListener objectStateListener;

	@Test
	public void testAddObjectListenerCall()
	{
		ObjectPool objectPool = new ObjectPool();
		objectPool.registerObjectStateListener(objectStateListener);

		GameObject gameObject = Mockito.mock(GameObject.class);

		objectPool.addObject(gameObject);

		Mockito.verify(objectStateListener).onObjectAdded(gameObject);
	}

	@Test
	public void testRemoveObjectListenerCall()
	{
		ObjectPool objectPool = new ObjectPool();
		objectPool.registerObjectStateListener(objectStateListener);

		GameObject gameObject = Mockito.mock(GameObject.class);

		objectPool.addObject(gameObject);
		objectPool.removeObject(gameObject);

		Mockito.verify(objectStateListener).onObjectRemoved(gameObject);
	}
}