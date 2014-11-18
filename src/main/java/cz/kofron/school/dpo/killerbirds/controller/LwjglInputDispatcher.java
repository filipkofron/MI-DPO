package cz.kofron.school.dpo.killerbirds.controller;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

import cz.kofron.school.dpo.killerbirds.view.LwjglUpdateListener;

/**
 * Created by kofee on 20/10/14.
 */
public class LwjglInputDispatcher implements LwjglUpdateListener
{
	private ArrayList<KeyboardListener> listeners = new ArrayList<>();

	public void addListener(KeyboardListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(KeyboardListener listener)
	{
		listeners.remove(listener);
	}

	public void onUpdate()
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			for (KeyboardListener listener : listeners)
			{
				listener.onPressed(Key.SPACE);
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			for (KeyboardListener listener : listeners)
			{
				listener.onPressed(Key.UP);
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			for (KeyboardListener listener : listeners)
			{
				listener.onPressed(Key.DOWN);
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			for (KeyboardListener listener : listeners)
			{
				listener.onPressed(Key.LEFT);
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			for (KeyboardListener listener : listeners)
			{
				listener.onPressed(Key.RIGHT);
			}
		}
	}
}
