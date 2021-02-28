import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Health 
{
	public Spritesheet sheet;
	public BufferedImage hpgray, hpgreen, hpheart;
	
	public Health()
	{
		sheet = new Spritesheet("/hp.png");
		hpgray = sheet.getSpriteOther(8, 32, 175, 16);
		hpgreen = sheet.getSpriteOther(8, 8, 175, 16);
		hpheart = sheet.getSpriteOther(192, 11, 30, 26);
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(hpgray, 65, 20, 175, 16,null);
		g.drawImage(hpgreen, 65, 20, (int)Player.hp, 16,null);
		g.drawImage(hpheart, 250, 20, 20, 16, null);
	}
}
