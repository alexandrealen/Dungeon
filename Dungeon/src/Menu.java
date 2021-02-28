import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

	public class Menu 
	{
		
		public Image background;
		public int WIDTH = 1100, HEIGHT = 600, lButt = 240, aButt = 70;
		public Image playButton, quitButton, logo, jogar, sair;
		
	
		
		public Menu()
		{
			background = this.getImage("background.png");
			playButton = this.getImage("botao.png");
			quitButton = this.getImage("botao.png");
			logo = this.getImage("textin.png");
			jogar = this.getImage("jogar.png");
			sair = this.getImage("sair.png");;
		}
		
		public void tick()
		{			
			if(Game.click)
			{
				if((Game.xix >= ((WIDTH/2)-125) && Game.xix <=(((WIDTH/2)-125) + lButt) ) && (Game.xiy >= 300 && Game.xiy <= 300 + aButt))
				{
					Game.inicio = false;
					Game.loading = true;
					//Game.jogao = true;
					//Game.press = true;
				}
				
				else if( (Game.xix >= (WIDTH/2)-125 && Game.xix <= ((WIDTH/2)-125) + lButt) && (Game.xiy >= 380 && Game.xiy <= 380 + aButt))
				{
					System.exit(0);
				}
				Game.click = false;
			}
		}
		
		public void render(Graphics g)
		{
			g.drawImage(background,0,0,WIDTH,HEIGHT,null);
			g.drawImage(logo, ((WIDTH - 800) / 2), 10, 800, 100, null);
			g.drawImage(playButton,(WIDTH/2)-125, 300, lButt, aButt, null);
			g.drawImage(jogar,(WIDTH/2)-70, 316, 200 - 70, aButt - 30, null);
			g.drawImage(quitButton,(WIDTH/2)-125, 380, lButt, aButt, null);
			g.drawImage(sair,(WIDTH/2)-65, 396, 200 - 80, aButt - 30, null);
		}
		public Image getImage(String path) 
		{
	        URL imageURL = getClass().getResource(path);
	        if (imageURL == null) return null;
	        return new ImageIcon(imageURL).getImage();
	    }

		
		
	}
