package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * Created by kofee on 20/10/14.
 */
public class Renderer implements LwjglUpdateListener
{
	private ArrayList<GraphicObject> sprites = new ArrayList<>();
	private ArrayList<GraphicObject> newSprites = new ArrayList<>();
	private ArrayList<GraphicObject> spritesToDelete = new ArrayList<>();
	private ArrayList<GameObject> objectsNotRemovedYet = new ArrayList<>();

	public void addSprite(GraphicObject graphicObject)
	{
		synchronized (sprites)
		{
			newSprites.add(graphicObject);
		}
	}

	public void removeSprite(GraphicObject graphicObject)
	{
		synchronized (graphicObject)
		{
			spritesToDelete.add(graphicObject);
		}
	}

	private void tryRemovedLater()
	{
		ArrayList<GameObject> notRemovedLaterAgain = new ArrayList<>();

		for (GameObject gameObject : objectsNotRemovedYet)
		{
			if(!tryRemoveByObject(gameObject))
			{
				notRemovedLaterAgain.add(gameObject);
			}
		}

		objectsNotRemovedYet = notRemovedLaterAgain;
	}

	private boolean tryRemoveByObject(GameObject gameObject)
	{
		for (GraphicObject graphicObject : sprites)
		{
			if (graphicObject.getGameObject().equals(gameObject))
			{
				spritesToDelete.add(graphicObject);
				return true;
			}
		}
		return false;
	}

	public void removeSpriteByObject(GameObject gameObject)
	{
		synchronized (sprites)
		{
			tryRemovedLater();
			if(!tryRemoveByObject(gameObject))
			{
				objectsNotRemovedYet.add(gameObject);
			}
		}
	}

	public void onUpdate()
	{
		synchronized (sprites)
		{
			View view = KillerBirds.view;

			if (newSprites.size() > 0)
			{
				for (GraphicObject graphicObject : newSprites)
				{
					graphicObject.getSprite().onInitializeGL(view.getWidth(), view.getHeight());

					sprites.add(graphicObject);
				}
				newSprites.clear();
			}

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(0.4f, 0.6f, 0.9f, 0f);

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			for (GraphicObject sprite : sprites)
			{
				sprite.getSprite().render(sprite.getGameObject());
			}

			if (spritesToDelete.size() > 0)
			{
				ArrayList<GraphicObject> notRemovedSprites = new ArrayList<>();
				for (GraphicObject sprite : spritesToDelete)
				{
					if(!sprites.remove(sprite))
					{
						notRemovedSprites.add(sprite);
					}
					else
					{
						sprite.getSprite().onDestroy();
					}
				}
				spritesToDelete.clear();
				spritesToDelete = notRemovedSprites;
			}
		}
	}
}
