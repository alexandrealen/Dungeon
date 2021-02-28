import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TaLoading 
{
	public String[] pontinho;
	private int frames = 0, maxFrames = 30, curAnimation = 0, maxAnimation = 8;
	public int WIDTH = 1100, HEIGHT = 600;
	
	public TaLoading()
	{
		pontinho = new String[8];
		pontinho[0] = ".";
		pontinho[1] = "..";
		pontinho[2] = "...";
		pontinho[3] = "";
		pontinho[4] = ".";
		pontinho[5] = "..";
		pontinho[6] = "...";
		pontinho[7] = "";
		
	}
	
	public void tick()
	{
		frames++;
		if(frames>maxFrames)
		{
			frames = 0;
			curAnimation++;
			if(curAnimation == 8)
			{
				Game.loading = false;
				Game.jogao = true;
				Game.press = true;
				Game.wave1 = true;
			}
		}
	}
	
	public void render(Graphics  g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(new Font("Impact",Font.PLAIN,60));
        g.setColor(Color.white);
        g.drawString("Carregante" + pontinho[curAnimation],10,HEIGHT - 65);
		
	}

}
