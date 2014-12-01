/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kofron.school.dpo.killerbirds.model;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kofee
 */
public class GameTimer
{
	private final ThreadRunner threadRunner = new ThreadRunner();
	private ThreadTimer threadTimer = new ThreadTimer();
	private Thread timerThread = null;
	private final Thread runnerThread = new Thread(threadRunner);
	private final long periodMs;
	private final ArrayList<GameUpdateListener> runnables = new ArrayList<GameUpdateListener>();
	private CyclicBarrier barrier = new CyclicBarrier(2);
	private boolean stopAtNext = false;

	private class ThreadRunner implements Runnable
	{
		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException ex)
				{
					Logger.getLogger(GameTimer.class.getName()).log(Level.SEVERE, null, ex);
				}

				runnables.stream().forEach(GameUpdateListener::onUpdate);
			}
		}
	}

	private class ThreadTimer implements Runnable
	{

		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException ex)
				{
					Logger.getLogger(GameTimer.class.getName()).log(Level.SEVERE, null, ex);
				}
				if (stopAtNext)
				{
					stopAtNext = false;
					timerThread = null;
					break;
				}
				try
				{
					Thread.sleep(periodMs);
				} catch (InterruptedException ex)
				{
					Logger.getLogger(GameTimer.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public GameTimer(long periodMs)
	{
		this.periodMs = periodMs;
		runnerThread.start();
	}

	public void start()
	{
		if (timerThread == null)
		{
			timerThread = new Thread(threadTimer);
			timerThread.start();
		}
	}

	public void stop()
	{
		stopAtNext = true;
	}

	public void registerRunnable(GameUpdateListener listener)
	{
		runnables.add(listener);
	}

	public void unregisterRunnable(GameUpdateListener listener)
	{
		runnables.remove(listener);
	}
}
