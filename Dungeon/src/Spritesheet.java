import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet 
{
	public BufferedImage sprite;
	
	public Spritesheet(String path)
	{
			try 
			{
				sprite = ImageIO.read(getClass().getResource(path));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
	}
	
	public BufferedImage getSprite(int coluna, int linha, int width, int height)
	{
			return sprite.getSubimage((coluna*64)-64, (linha*64)-64, width, height);
	}
	public BufferedImage getSpriteOther(int coluna, int linha, int width, int height)
	{
			return sprite.getSubimage(coluna, linha, width, height);
	}

}
