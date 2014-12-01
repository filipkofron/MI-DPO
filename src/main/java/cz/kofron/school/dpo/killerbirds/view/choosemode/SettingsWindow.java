package cz.kofron.school.dpo.killerbirds.view.choosemode;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cz.kofron.school.dpo.killerbirds.KillerBirds;
import cz.kofron.school.dpo.killerbirds.model.Model;
import cz.kofron.school.dpo.killerbirds.model.ModelMementoStore;
import cz.kofron.school.dpo.killerbirds.model.ModelSettings;

/**
 * Added by Filip Kofron on 18.11.14.
 */
public class SettingsWindow extends JFrame
{
	private GameModePane gameModePane;
	private FloatOption enemySpawnerModereateProbabilityPanel;
	private IntegerOption enemySpawnerModeratePerFramePanel;
	private FloatOption enemySpawnerHardCoreProbabilityPanel;
	private IntegerOption enemySpawnerHardCorePerFramePanel;
	private IntegerOption cannonSingleShootPeriodPanel;
	private IntegerOption cannonSingleShootAmountPanel;
	private IntegerOption cannonMultipleShootPeriodPanel;
	private IntegerOption cannonMultipleShootAmountPanel;

	private ModelSettings modelSettings;

	public void loadSettingsFromMemento()
	{
		Model.ModelMemento memento = ModelMementoStore.getInstance().load();

		if(memento == null)
		{
			memento = KillerBirds.model.createMemento();
		}
		KillerBirds.model.setMemento(memento);
		modelSettings = KillerBirds.model.getSettings();
	}

	private void readOptions()
	{
		modelSettings.setGameMode(gameModePane.getGameMode());

		modelSettings.setEnemySpawnerModerateProbability(enemySpawnerModereateProbabilityPanel.getValue());
		modelSettings.setEnemySpawnerModeratePerFrame(enemySpawnerModeratePerFramePanel.getValue());
		modelSettings.setEnemySpawnerHardCoreProbability(enemySpawnerHardCoreProbabilityPanel.getValue());
		modelSettings.setEnemySpawnerHardCorePerFrame(enemySpawnerHardCorePerFramePanel.getValue());

		modelSettings.setCannonSingleShootPeriod(cannonSingleShootPeriodPanel.getValue());
		modelSettings.setCannonSingleShootAmount(cannonSingleShootAmountPanel.getValue());
		modelSettings.setCannonMultipleShootPeriod(cannonMultipleShootPeriodPanel.getValue());
		modelSettings.setCannonMultipleShootAmount(cannonMultipleShootAmountPanel.getValue());
	}

	public void runGame()
	{
		readOptions();

		Model.ModelMemento memento = KillerBirds.model.createMemento();

		ModelMementoStore.getInstance().save(memento);

		KillerBirds.startGameWith(modelSettings);
		setVisible(false);
	}

	private void setupOptions()
	{
		gameModePane = new GameModePane(modelSettings.getGameMode());
		enemySpawnerModereateProbabilityPanel = new FloatOption("Enemy spawner moderate probability:", modelSettings.getEnemySpawnerModerateProbability());
		enemySpawnerModeratePerFramePanel = new IntegerOption("Enemy spawner moderate per frame:", modelSettings.getEnemySpawnerModeratePerFrame());
		enemySpawnerHardCoreProbabilityPanel = new FloatOption("Enemy spawner hardcore probability:", modelSettings.getEnemySpawnerHardCoreProbability());
		enemySpawnerHardCorePerFramePanel = new IntegerOption("Enemy spawner hardcore per frame:", modelSettings.getEnemySpawnerHardCorePerFrame());
		cannonSingleShootPeriodPanel = new IntegerOption("Cannon single shoot period ms:", modelSettings.getCannonSingleShootPeriod());
		cannonSingleShootAmountPanel = new IntegerOption("Cannon single shoot amount:", modelSettings.getCannonSingleShootAmount());
		cannonMultipleShootPeriodPanel= new IntegerOption("Cannon multiple shoot period ms:", modelSettings.getCannonMultipleShootPeriod());
		cannonMultipleShootAmountPanel= new IntegerOption("Cannon multiple shoot amount:", modelSettings.getCannonMultipleShootAmount());
	}

	public SettingsWindow() throws HeadlessException
	{
		super("Killer birds - Settings");
		loadSettingsFromMemento();
		JPanel listPanel = new JPanel();

		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		listPanel.add(new JLabel("Select mode:"));

		setupOptions();
		listPanel.add(gameModePane);
		listPanel.add(enemySpawnerModereateProbabilityPanel);
		listPanel.add(enemySpawnerModeratePerFramePanel);
		listPanel.add(enemySpawnerHardCoreProbabilityPanel);
		listPanel.add(enemySpawnerHardCorePerFramePanel);
		listPanel.add(cannonSingleShootPeriodPanel);
		listPanel.add(cannonSingleShootAmountPanel);
		listPanel.add(cannonMultipleShootPeriodPanel);
		listPanel.add(cannonMultipleShootAmountPanel);
		listPanel.add(new RunPane(this));
		add(listPanel);
		pack();
	}
}
