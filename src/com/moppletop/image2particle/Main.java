package com.moppletop.image2particle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		File file = new File("test.png");

		if (!file.exists())
		{
			return;
		}

		try
		{
			BufferedImage image = ImageIO.read(file);
			List<String> result = new ArrayList<>(image.getHeight());

			for (int x = 0; x < image.getHeight(); x++)
			{
				StringBuilder builder = new StringBuilder("\"");

				for (int y = 0; y < image.getWidth(); y++)
				{
					int[] pixel = image.getRaster().getPixel(x, y, new int[4]);
					builder.append(pixel[0])
							.append(",")
							.append(pixel[1])
							.append(",")
							.append(pixel[2])
							.append("/");
				}

				result.add(builder.append("\",").toString());
			}

			for (String l : result)
			{
				System.out.println(l);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
