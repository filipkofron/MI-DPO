package cz.kofron.school.dpo.killerbirds.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by kofee on 1.12.14.
 */
public class ModelMementoStore
{
	private static ModelMementoStore modelMementoStore = null;
	private static String mementoPath = System.getProperty("user.home") + File.separator + "killerbirds.spam";

	public static synchronized ModelMementoStore getInstance()
	{
		if(modelMementoStore == null)
		{
			modelMementoStore = new ModelMementoStore();
		}
		return modelMementoStore;
	}

	public void save(Model.ModelMemento modelMemento)
	{
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(mementoPath)))
		{
			objectOutputStream.writeObject(modelMemento);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public Model.ModelMemento load()
	{
		Model.ModelMemento memento = null;

		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(mementoPath)))
		{
			memento = (Model.ModelMemento) objectInputStream.readObject();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return memento;
	}
}
