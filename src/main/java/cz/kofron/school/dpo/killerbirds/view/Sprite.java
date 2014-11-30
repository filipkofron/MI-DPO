/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.opengl.APPLEVertexArrayObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.util.HashMap;

import cz.kofron.school.dpo.killerbirds.model.objects.GameObject;

/**
 * @author kofee
 */
public class Sprite extends TexturedGLObject
{
	private String textureName;
	private int references = 0;
	private static HashMap<String, Sprite> spriteCache = new HashMap<>();

	public static Sprite getSpriteForName(String name)
	{
		Sprite sprite = spriteCache.get(name);

		if(sprite == null)
		{
			sprite = new Sprite(name);
			spriteCache.put(name, sprite);
		}
		return sprite;
	}

	private Sprite(String name)
	{
		this.textureName = name;
	}

	private float[] spriteVertices = {

			-1.0f, 1.0f, 0f,
			-1.0f, -1.0f, 0f,
			1.0f, -1.0f, 0f,
			1.0f, -1.0f, 0f,
			1.0f, 1.0f, 0f,
			-1.0f, 1.0f, 0f
	};

	private final static float[] spriteTextureCoords = {

			0.0f, 0.0f,
			0.0f, 1.0f,
			1.0f, 1.0f,
			1.0f, 1.0f,
			1.0f, 0.0f,
			0.0f, 0.0f,
	};

	@Override
	protected void setupTexture()
	{
		texId = ImageManager.getImage(textureName);
		texX = ImageManager.getX(textureName);
		texY = ImageManager.getY(textureName);
	}

	@Override
	public void onInitializeGL(float screenWidth, float screenHeight)
	{
		if(references == 0)
		{
			super.onInitializeGL(screenWidth, screenHeight);
		}
		references++;
	}

	public void render(GameObject gameObject)
	{
		render(gameObject.getMovementProperty().posX, gameObject.getMovementProperty().posY);
	}

	@Override
	public void onDestroy()
	{
		if(references == 1)
		{
			super.onDestroy();
			spriteCache.remove(textureName);
		}
		if(references > 0)
		{
			references--;
		}
	}
}
