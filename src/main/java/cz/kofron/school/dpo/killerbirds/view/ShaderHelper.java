package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.glu.GLU;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by kofee on 20/10/14.
 */
public class ShaderHelper
{
	private static int vertexShader = -1;
	private static int fragmentShader = -1;
	private static int programShader = -1;

	public static void initializeShaders()
	{
		vertexShader = loadShader("vertex.glsl", GL20.GL_VERTEX_SHADER);
		fragmentShader = loadShader("fragment.glsl", GL20.GL_FRAGMENT_SHADER);

		int errorCheckValue = GL11.glGetError();

		programShader = GL20.glCreateProgram();
		GL20.glAttachShader(programShader, vertexShader);
		GL20.glAttachShader(programShader, fragmentShader);

		GL20.glBindAttribLocation(programShader, 0, "in_vertex");
		GL20.glBindAttribLocation(programShader, 1, "in_texCoord");

		GL20.glLinkProgram(programShader);
		GL20.glValidateProgram(programShader);

		errorCheckValue = GL11.glGetError();
		if (errorCheckValue != GL11.GL_NO_ERROR)
		{
			System.out.println("ERROR - Could not create the shaders:" + GLU.gluErrorString(errorCheckValue));
		}
		System.out.println("Shaders compiled.");
	}

	public static int loadShader(String shaderFilename, int type)
	{
		StringBuilder shaderSource = new StringBuilder();
		int shaderID = 0;

		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					ShaderHelper.class.getResourceAsStream("shaders/" + shaderFilename)));
			String line;
			while ((line = reader.readLine()) != null)
			{
				shaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (Exception e)
		{
			System.err.println("Could not read file.");
			e.printStackTrace();
		}

		shaderID = GL20.glCreateShader(type);
		GL20.glShaderSource(shaderID, shaderSource);
		GL20.glCompileShader(shaderID);

		if (GL20.glGetShader(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE)
		{

			System.err.println("Could not compile shader: " + shaderFilename
					+ " because " + GL20.glGetShaderInfoLog(shaderID, 1024));
		}

		return shaderID;
	}

	public static int getProgramShader()
	{
		return programShader;
	}
}
