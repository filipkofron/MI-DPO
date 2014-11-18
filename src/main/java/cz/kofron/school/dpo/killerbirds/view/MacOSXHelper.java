package cz.kofron.school.dpo.killerbirds.view;

/**
 * Created by kofee on 21/10/14.
 */
public class MacOSXHelper
{
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static boolean mac = OS.indexOf("mac") >= 0;

	public static boolean isMac()
	{
		return mac;
	}
}
