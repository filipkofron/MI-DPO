package cz.kofron.school.dpo.killerbirds.view;

import cz.kofron.school.dpo.killerbirds.model.ObjectStateListener;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Created by kofee on 21.10.14.
 */
public class ObjectStateReceiver implements ObjectStateListener
{
	private View view;

	public ObjectStateReceiver(View view)
	{
		this.view = view;
	}

	@Override
	public void onObjectAdded(GameObject gameObject)
	{
		view.getRenderer().addSprite(new GraphicObject(gameObject));
	}

	@Override
	public void onObjectRemoved(GameObject gameObject)
	{
		view.getRenderer().removeSpriteByObject(gameObject);
	}
}
