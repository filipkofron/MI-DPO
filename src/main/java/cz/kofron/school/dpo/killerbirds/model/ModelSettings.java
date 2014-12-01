package cz.kofron.school.dpo.killerbirds.model;

import java.io.Serializable;

/**
 * Added by Filip Kofron on 1.12.14.
 */
public class ModelSettings implements Serializable
{
	private GameMode gameMode = GameMode.SIMPLE;
	private float enemySpawnerModerateProbability = 0.02f;
	private float enemySpawnerHardCoreProbability = 1.0f;
	private int enemySpawnerModeratePerFrame = 1;
	private int enemySpawnerHardCorePerFrame = 10;
	private int cannonSingleShootPeriod = 500;
	private int cannonSingleShootAmount = 1;
	private int cannonMultipleShootPeriod = 30;
	private int cannonMultipleShootAmount = 3;

	public ModelSettings()
	{
	}

	public ModelSettings(GameMode gameMode, float enemySpawnerModerateProbability, float enemySpawnerHardCoreProbability, int enemySpawnerModeratePerFrame, int enemySpawnerHardCorePerFrame, int cannonSingleShootPeriod, int cannonSingleShootAmount, int cannonMultipleShootPeriod, int cannonMultipleShootAmount)
	{
		this.gameMode = gameMode;
		this.enemySpawnerModerateProbability = enemySpawnerModerateProbability;
		this.enemySpawnerHardCoreProbability = enemySpawnerHardCoreProbability;
		this.enemySpawnerModeratePerFrame = enemySpawnerModeratePerFrame;
		this.enemySpawnerHardCorePerFrame = enemySpawnerHardCorePerFrame;
		this.cannonSingleShootPeriod = cannonSingleShootPeriod;
		this.cannonSingleShootAmount = cannonSingleShootAmount;
		this.cannonMultipleShootPeriod = cannonMultipleShootPeriod;
		this.cannonMultipleShootAmount = cannonMultipleShootAmount;
	}

	public GameMode getGameMode()
	{
		return gameMode;
	}

	public void setGameMode(GameMode gameMode)
	{
		this.gameMode = gameMode;
	}

	public float getEnemySpawnerModerateProbability()
	{
		return enemySpawnerModerateProbability;
	}

	public void setEnemySpawnerModerateProbability(float enemySpawnerModerateProbability)
	{
		this.enemySpawnerModerateProbability = enemySpawnerModerateProbability;
	}

	public float getEnemySpawnerHardCoreProbability()
	{
		return enemySpawnerHardCoreProbability;
	}

	public void setEnemySpawnerHardCoreProbability(float enemySpawnerHardCoreProbability)
	{
		this.enemySpawnerHardCoreProbability = enemySpawnerHardCoreProbability;
	}

	public int getEnemySpawnerModeratePerFrame()
	{
		return enemySpawnerModeratePerFrame;
	}

	public void setEnemySpawnerModeratePerFrame(int enemySpawnerModeratePerFrame)
	{
		this.enemySpawnerModeratePerFrame = enemySpawnerModeratePerFrame;
	}

	public int getEnemySpawnerHardCorePerFrame()
	{
		return enemySpawnerHardCorePerFrame;
	}

	public void setEnemySpawnerHardCorePerFrame(int enemySpawnerHardCorePerFrame)
	{
		this.enemySpawnerHardCorePerFrame = enemySpawnerHardCorePerFrame;
	}

	public int getCannonSingleShootPeriod()
	{
		return cannonSingleShootPeriod;
	}

	public void setCannonSingleShootPeriod(int cannonSingleShootPeriod)
	{
		this.cannonSingleShootPeriod = cannonSingleShootPeriod;
	}

	public int getCannonSingleShootAmount()
	{
		return cannonSingleShootAmount;
	}

	public void setCannonSingleShootAmount(int cannonSingleShootAmount)
	{
		this.cannonSingleShootAmount = cannonSingleShootAmount;
	}

	public int getCannonMultipleShootPeriod()
	{
		return cannonMultipleShootPeriod;
	}

	public void setCannonMultipleShootPeriod(int cannonMultipleShootPeriod)
	{
		this.cannonMultipleShootPeriod = cannonMultipleShootPeriod;
	}

	public int getCannonMultipleShootAmount()
	{
		return cannonMultipleShootAmount;
	}

	public void setCannonMultipleShootAmount(int cannonMultipleShootAmount)
	{
		this.cannonMultipleShootAmount = cannonMultipleShootAmount;
	}
}
