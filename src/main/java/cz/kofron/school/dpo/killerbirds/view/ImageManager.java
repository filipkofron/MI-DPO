package cz.kofron.school.dpo.killerbirds.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL12;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by kofee on 19.10.14.
 */
public class ImageManager
{
	private final static HashMap<String, Integer> images = new HashMap<>();
	private final static HashMap<String, Integer> dimXs = new HashMap<>();
	private final static HashMap<String, Integer> dimYs = new HashMap<>();

	public static void initialize()
	{
		String[] names = {"cannon", "collision", "enemy1", "enemy2", "missile"};
		for (String name : names)
		{
			BufferedImage img = loadImage(name);
			int texId = loadTexture(img);
			System.out.println("Texture file: " + name + " id = " + texId);
			images.put(name, texId);
			dimXs.put(name, img.getWidth());
			dimYs.put(name, img.getHeight());
		}
	}

	public static int getImage(String name)
	{
		return images.get(name);
	}
	public static int getX(String name)
	{
		return dimXs.get(name);
	}
	public static int getY(String name)
	{
		return dimYs.get(name);
	}

	private static final int BYTES_PER_PIXEL = 4;
	public static int loadTexture(BufferedImage image){

		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

		ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL); //4 for RGBA, 3 for RGB

		for(int y = 0; y < image.getHeight(); y++){
			for(int x = 0; x < image.getWidth(); x++){
				int pixel = pixels[y * image.getWidth() + x];
				buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red component
				buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green component
				buffer.put((byte) (pixel & 0xFF));               // Blue component
				buffer.put((byte) ((pixel >> 24) & 0xFF));    // Alpha component. Only for RGBA
			}
		}

		buffer.flip(); //FOR THE LOVE OF GOD DO NOT FORGET THIS

		// You now have a ByteBuffer filled with the color data of each pixel.
		// Now just create a texture ID and bind it. Then you can load it using
		// whatever OpenGL method you want, for example:

		int textureID = glGenTextures(); //Generate texture ID
		glBindTexture(GL_TEXTURE_2D, textureID); //Bind texture ID

		//Setup wrap mode
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);

		//Setup texture scaling filtering
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

		//Send texel data to OpenGL
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

		//Return the texture ID so we can bind it later again

		return textureID;
	}

	private static BufferedImage loadImage(String name)
	{
		try
		{
			return ImageIO.read(ImageManager.class.getResourceAsStream("images/" + name + ".png"));
		}
		catch (IOException e)
		{
		}
		return null;
	}
}
