import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Press
{
	public Press()
	{
		
	}
	public void tick()
	{
		
	}
	public void render(Graphics g)
	{
		g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        g.setColor(new Color(0,0,0));
        g.drawString("Pressione 'ESPAÇO' para começar",220,100);
	}
}
