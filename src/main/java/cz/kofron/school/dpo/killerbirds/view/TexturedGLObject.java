package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.opengl.APPLEVertexArrayObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Added by Filip Kofron on 30.11.14.
 */
public abstract class TexturedGLObject extends GLObject
{
	protected int texId;
	protected int texX, texY;
	float screenWidth, screenHeight;
	protected int offsetLoc;

	protected TexturedGLObject()
	{
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

	protected abstract void setupTexture();

	@Override
	public void onInitializeGL(float screenWidth, float screenHeight)
	{
			setupTexture();

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

	@Override
	public void onDestroy()
	{
		destroyGL();
	}

	public void render(float posX, float posY)
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

		GL20.glUniform2f(offsetLoc, posX / (screenWidth / 2.0f),
				posY /  (screenHeight / 2.0f));

		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);

		// Mac OS X has terribly broken OpenGL ..
		if(MacOSXHelper.isMac())
		{
			APPLEVertexArrayObject.glBindVertexArrayAPPLE(0);
		}
		else
		{
			GL30.glBindVertexArray(0);
		}

		GL20.glUseProgram(0);
	}
}
