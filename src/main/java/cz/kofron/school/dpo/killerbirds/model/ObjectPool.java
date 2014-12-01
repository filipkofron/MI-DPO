package cz.kofron.school.dpo.killerbirds.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Created by kofee on 21.10.14.
 */
public class ObjectPool implements GameUpdateListener
{
	private HashMap<String, ArrayList<GameObject>> gameObjects = new HashMap<>();
	private ArrayList<ObjectStateListener> objectStateListeners = new ArrayList<>();

	public void registerObjectStateListener(ObjectStateListener listener)
	{
		objectStateListeners.add(listener);
	}

	public void removeObjectStateListener(ObjectStateListener listener)
	{
		objectStateListeners.remove(listener);
	}

	public void addObject(GameObject gameObject)
	{
		synchronized (gameObjects)
		{
			ArrayList list = gameObjects.get(gameObject.getName());
			if (list != null)
			{
				list.add(gameObject);
			} else
			{
				list = new ArrayList();
				list.add(gameObject);
				gameObjects.put(gameObject.getName(), list);
			}
		}
		for (ObjectStateListener listener : objectStateListeners)
		{
			listener.onObjectAdded(gameObject);
		}
	}

	public void removeObject(GameObject gameObject)
	{
		ArrayList list;
		synchronized (gameObjects)
		{
			list = gameObjects.get(gameObject.getName());
			if (list != null)
			{
				gameObject.onDespawned();
				list.remove(gameObject);
				for (ObjectStateListener listener : objectStateListeners)
				{
					listener.onObjectRemoved(gameObject);
				}
			}
		}
	}

	public List<GameObject> getObjectsByName(String name)
	{
		List list;
		synchronized (gameObjects)
		{
			list = gameObjects.get(name);
		}
		if (list == null)
		{
			return new ArrayList<>();
		}
		return new ArrayList<GameObject>(list);
	}

	@Override
	public void onUpdate()
	{
		ArrayList<GameObject> toRemove = new ArrayList<>();

		synchronized (gameObjects)
		{
			for (List<GameObject> gameObjectLists : gameObjects.values())
			{
				for (GameObject gameObject : gameObjectLists)
				{
					if (gameObject.getMovementProperty().posX > Model.DEFAULT_WIDTH
							|| gameObject.getMovementProperty().posX < -Model.DEFAULT_WIDTH
							|| gameObject.getMovementProperty().posY < -Model.DEFAULT_HEIGHT)
					{
						toRemove.add(gameObject);
					}

					gameObject.update();
				}
			}
		}

		for (GameObject gameObject : toRemove)
		{
			removeObject(gameObject);
		}
	}
}
