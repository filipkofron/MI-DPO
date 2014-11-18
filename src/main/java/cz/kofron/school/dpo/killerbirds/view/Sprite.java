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
import java.util.HashSet;

import cz.kofron.school.dpo.killerbirds.model.GameObject;

/**
 * @author kofee
 */
public class Sprite extends GLObject
{
	private int texId;
	private int texX, texY;
	float screenWidth, screenHeight;
	private String textureName;
	private int offsetLoc;
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
	public void onInitializeGL(float screenWidth, float screenHeight)
	{
		if(references == 0)
		{
			texId = ImageManager.getImage(textureName);
			texX = ImageManager.getX(textureName);
			texY = ImageManager.getY(textureName);

			this.screenWidth = screenWidth;
			this.screenHeight = screenHeight;

			offsetLoc = GL20.glGetUniformLocation(ShaderHelper.getProgramShader(), "uni_offset");

			float ratioX = texX / screenWidth;
			float ratioY = texY / screenHeight;
			for (int i = 0; i < spriteVertices.length / 3; i++)
			{
				spriteVertices[i * 3] *= ratioX;
				spriteVertices[i * 3 + 1] *= ratioY;
			}
			setupGL(spriteVertices, spriteTextureCoords);
		}
		references++;
	}

	@Override
	public void onDestroy()
	{
		if(references == 1)
		{
			destroyGL();
			spriteCache.remove(textureName);
		}
		if(references > 0)
		{
			references--;
		}
	}

	public void render(GameObject gameObject)
	{
		GL20.glUseProgram(ShaderHelper.getProgramShader());


		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(vertexArrayObjectId);;
		}
		else
		{
			GL30.glBindVertexArray(vertexArrayObjectId);
		}

		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferObjectId);

		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texId);

		GL20.glUniform2f(offsetLoc, gameObject.getX() / (screenWidth / 2.0f),
				gameObject.getY() /  (screenHeight / 2.0f));

		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);

		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(0);;
		}
		else
		{
			GL30.glBindVertexArray(0);
		}

		GL20.glUseProgram(0);
	}
	
	
}
