package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.APPLEVertexArrayObject;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;

/**
 * Created by kofee on 20/10/14.
 */
public abstract class GLObject
{
	protected int vertexArrayObjectId = 0;
	protected int vertexBufferObjectId = 0;
	protected int texCoordBufferObjectId = 0;
	protected int vertexCount = 0;

	protected void setupGL(float [] vertices, float [] textureCoords)
	{
		FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertices.length);
		vertexCount = vertices.length / 3;

		FloatBuffer texCoordBuffer = BufferUtils.createFloatBuffer(vertices.length + textureCoords.length);
		vertexCount = vertices.length / 3;

		vertexBuffer.put(vertices);
		vertexBuffer.flip();

		texCoordBuffer.put(textureCoords);
		texCoordBuffer.flip();

		vertexBufferObjectId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferObjectId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		texCoordBufferObjectId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, texCoordBufferObjectId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, texCoordBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			vertexArrayObjectId = APPLEVertexArrayObject.glGenVertexArraysAPPLE();
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(vertexArrayObjectId);
		}
		else
		{
			vertexArrayObjectId = GL30.glGenVertexArrays();
			GL30.glBindVertexArray(vertexArrayObjectId);
		}

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexBufferObjectId);
		GL20.glEnableVertexAttribArray(0);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 3 * 4, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, texCoordBufferObjectId);
		GL20.glEnableVertexAttribArray(1);
		GL20.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 2 * 4, 0);

		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(0);
		}
		else
		{
			GL30.glBindVertexArray(0);
		}
	}

	protected void destroyGL()
	{
		GL20.glDisableVertexAttribArray(0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(vertexBufferObjectId);
		GL15.glDeleteBuffers(texCoordBufferObjectId);

		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(0);
			APPLEVertexArrayObject.glDeleteVertexArraysAPPLE(vertexArrayObjectId);
		}
		else
		{
			GL30.glBindVertexArray(0);
			GL30.glDeleteVertexArrays(vertexArrayObjectId);
		}
	}

	public abstract void onInitializeGL(float screenWidth, float screenHeight);

	public abstract void onDestroy();
}
