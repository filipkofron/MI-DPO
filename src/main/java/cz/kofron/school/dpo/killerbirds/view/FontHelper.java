package cz.kofron.school.dpo.killerbirds.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Added by Filip Kofron on 30.11.14.
 */
public class FontHelper
{
	public static Font loadTrueTypeFont(String filename)
	{
		InputStream inputStream = FontHelper.class.getResourceAsStream("fonts" + File.separator + filename);

		Font awtFont;
		try
		{
			awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(18f);
			return awtFont;

		} catch (FontFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
