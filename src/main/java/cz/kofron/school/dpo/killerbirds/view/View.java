package cz.kofron.school.dpo.killerbirds.view;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.Model;

/**
 * Created by kofee on 20.10.14.
 */
public class View
{
	private LwjglUpdateDispatcher lwjglUpdateDispatcher = new LwjglUpdateDispatcher();
	private boolean running = false;
	private Renderer renderer = new Renderer();

	public LwjglUpdateDispatcher getLwjglUpdateDispatcher()
	{
		return lwjglUpdateDispatcher;
	}

	public Renderer getRenderer()
	{
		return renderer;
	}

	private Thread lwjglThread = new Thread()
	{
		@Override
		public void run()
		{
			loop();
		}
	};

	private void loop()
	{
		try
		{
			PixelFormat pixelFormat = new PixelFormat();
			ContextAttribs contextAtrributes = new ContextAttribs(3, 0)
					.withForwardCompatible(true);

			Display.setDisplayMode(new DisplayMode(Model.DEFAULT_WIDTH, Model.DEFAULT_HEIGHT));
			Display.create(pixelFormat, contextAtrributes);
			Display.setTitle("DPO/Killer birds");

			ShaderHelper.initializeShaders();
			ImageManager.initialize();

			GL11.glViewport(0, 0, Model.DEFAULT_WIDTH, Model.DEFAULT_HEIGHT);

			while (!Display.isCloseRequested())
			{
				Display.sync(60);
				lwjglUpdateDispatcher.update();
				Display.update();
			}

			KillerBirds.model.onExit();
			Display.destroy();
			System.out.println("=== STOP ===");

		} catch (LWJGLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.exit(1);
		}
	}

	public synchronized void init()
	{
		lwjglUpdateDispatcher.addListener(renderer);
		if (!running)
		{
			running = true;
			lwjglThread.start();
		}
		KillerBirds.model.getObjectPool().registerObjectStateListener(new ObjectStateReceiver(this));
	}

	public int getWidth()
	{
		return Model.DEFAULT_WIDTH;
	}

	public int getHeight()
	{
		return Model.DEFAULT_HEIGHT;
	}
}
