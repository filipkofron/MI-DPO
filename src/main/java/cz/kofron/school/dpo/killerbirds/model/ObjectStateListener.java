package cz.kofron.school.dpo.killerbirds.model;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Created by kofee on 21.10.14.
 */
public interface ObjectStateListener
{
	public void onObjectAdded(GameObject gameObject);
	public void onObjectRemoved(GameObject gameObject);
}
