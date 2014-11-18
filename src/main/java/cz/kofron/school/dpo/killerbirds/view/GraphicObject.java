package cz.kofron.school.dpo.killerbirds.view;

import cz.kofron.school.dpo.killerbirds.model.GameObject;

/**
 * Added by Filip Kofron on 10.11.14.
 */
public class GraphicObject
{
	private Sprite sprite;
	private GameObject gameObject;

	public GraphicObject(GameObject gameObject)
	{
		this.sprite = Sprite.getSpriteForName(gameObject.getName());
		this.gameObject = gameObject;
	}

	public Sprite getSprite()
	{
		return sprite;
	}

	public GameObject getGameObject()
	{
		return gameObject;
	}
}
