package cz.kofron.school.dpo.killerbirds.view;

import java.util.ArrayList;

/**
 * Created by kofee on 20/10/14.
 */
public class LwjglUpdateDispatcher
{
	private ArrayList<LwjglUpdateListener> lwjglUpdateListeners = new ArrayList<>();

	public void addListener(LwjglUpdateListener listener)
	{
		lwjglUpdateListeners.add(listener);
	}

	public void removeListener(LwjglUpdateListener listener)
	{
		lwjglUpdateListeners.remove(listener);
	}

	public void update()
	{
		for(LwjglUpdateListener listener : lwjglUpdateListeners)
		{
			listener.onUpdate();
		}
	}
}
