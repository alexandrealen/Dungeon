import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player 
{
	
	public boolean up, down, right, left, walk, rel = true, inter;
	public static boolean shootUp, shootDown, shootRight, shootLeft;
	public BufferedImage[] playerwalksprite, playershootsprite;
	public Spritesheet sheet, fullsheet;
	public static int x, y, k1, speed = 3, yy, xx;
	private int frames = 0, maxFrames = 5, curAnimation = 0, maxAnimation = 9, curAnimation1 = 0, maxAnimation1 = 6, frames1 = 0, maxFrames1 = 2;
	public BufferedImage sprite;
	public Health health;
	public static double hp = 175;
	public Rectangle boundsPlayer, boundsSkeleton1, boundsSkeleton2, boundsSkeleton3, boundsSkeleton4;
	public int frameshp = 0;
	
	public Player(int x, int y)
	{
		sheet = new Spritesheet("/playerwalk.png");
		fullsheet = new Spritesheet("/playersheet.png");
		playerwalksprite = new BufferedImage[37];
		playershootsprite = new BufferedImage[24];
		playerwalksprite [0] = sheet.getSprite(1, 1, 64, 64);
		playerwalksprite [1] = sheet.getSprite(1, 1, 64, 64);
		playerwalksprite [2] = sheet.getSprite(2, 1, 64, 64);
		playerwalksprite [3] = sheet.getSprite(3, 1, 64, 64);
		playerwalksprite [4] = sheet.getSprite(4, 1, 64, 64);
		playerwalksprite [5] = sheet.getSprite(5, 1, 64, 64);
		playerwalksprite [6] = sheet.getSprite(6, 1, 64, 64);
		playerwalksprite [7] = sheet.getSprite(7, 1, 64, 64);
		playerwalksprite [8] = sheet.getSprite(8, 1, 64, 64);
		playerwalksprite [9] = sheet.getSprite(9, 1, 64, 64);
		playerwalksprite [10] = sheet.getSprite(1, 2, 64, 64);
		playerwalksprite [11] = sheet.getSprite(2, 2, 64, 64);
		playerwalksprite [12] = sheet.getSprite(3, 2, 64, 64);
		playerwalksprite [13] = sheet.getSprite(4, 2, 64, 64);
		playerwalksprite [14] = sheet.getSprite(5, 2, 64, 64);
		playerwalksprite [15] = sheet.getSprite(6, 2, 64, 64);
		playerwalksprite [16] = sheet.getSprite(7, 2, 64, 64);
		playerwalksprite [17] = sheet.getSprite(8, 2, 64, 64);
		playerwalksprite [18] = sheet.getSprite(9, 2, 64, 64);
		playerwalksprite [19] = sheet.getSprite(1, 3, 64, 64);
		playerwalksprite [20] = sheet.getSprite(2, 3, 64, 64);
		playerwalksprite [21] = sheet.getSprite(3, 3, 64, 64);
		playerwalksprite [22] = sheet.getSprite(4, 3, 64, 64);
		playerwalksprite [23] = sheet.getSprite(5, 3,  64, 64);
		playerwalksprite [24] = sheet.getSprite(6, 3,  64, 64);
		playerwalksprite [25] = sheet.getSprite(7, 3, 64, 64);
		playerwalksprite [26] = sheet.getSprite(8, 3, 64, 64);
		playerwalksprite [27] = sheet.getSprite(9, 3, 64, 64);
		playerwalksprite [28] = sheet.getSprite(1, 4, 64, 64);
		playerwalksprite [29] = sheet.getSprite(2, 4, 64, 64);
		playerwalksprite [30] = sheet.getSprite(3, 4, 64, 64);
		playerwalksprite [31] = sheet.getSprite(4, 4, 64, 64);
		playerwalksprite [32] = sheet.getSprite(5, 4, 64, 64);
		playerwalksprite [33] = sheet.getSprite(6, 4, 64, 64);
		playerwalksprite [34] = sheet.getSprite(7, 4, 64, 64);
		playerwalksprite [35] = sheet.getSprite(8, 4, 64, 64);
		playerwalksprite [36] = sheet.getSprite(9, 4, 64, 64);
		playershootsprite[5] = fullsheet.getSprite(6, 13, 64, 64);
		playershootsprite[11] = fullsheet.getSprite(6, 14, 64, 64);
		playershootsprite[17] = fullsheet.getSprite(6, 15, 64, 64);
		playershootsprite[23] = fullsheet.getSprite(6, 16, 64, 64);
		health = new Health();

		
		this.x = x;
		this.y = y;
	}
	
	public void tick()
	{
		if (right && x <= 964)
			{
				x+= speed;
			}
		else if (left && x >= 45)
			{
				x-= speed;
			}
		if (down && y <= 380)  
			{
				y+= speed;
			}
		else if (up && y >= -10)
			{
				y-= speed;
			}  
		boundsPlayer = new Rectangle(x+10, y+17, 45, 75);
		boundsSkeleton1 = new Rectangle((int)Horda1.skeleton1.x, (int)Horda1.skeleton1.y, 45, 75);
		boundsSkeleton2 = new Rectangle((int)Horda1.skeleton2.x, (int)Horda1.skeleton2.y, 45, 75);
		boundsSkeleton3 = new Rectangle((int)Horda1.skeleton3.x, (int)Horda1.skeleton3.y, 45, 75);
		boundsSkeleton4 = new Rectangle((int)Horda1.skeleton4.x, (int)Horda1.skeleton4.y, 45, 75);
		
		if(boundsPlayer.intersects(boundsSkeleton1) || boundsPlayer.intersects(boundsSkeleton2) || boundsPlayer.intersects(boundsSkeleton3) || boundsPlayer.intersects(boundsSkeleton4))
		{
			if(frameshp == 0)
			{
				hp -= 10;
			}
			frameshp++;
			if(frameshp == 10)
			{
				frameshp = 0;
			}
		}
		if(hp <= 0 && Game.wave1)
		{
			hp = 0;
			Game.restart1 = true;
		}
		if(Horda1.skeleton1.hp1 <= 0 && Horda1.skeleton2.hp2 <= 0 && Horda1.skeleton3.hp3 <= 0 && Horda1.skeleton4.hp4 <= 0)
		{
			Game.ganhouWave1 = true;
		}
		
	}
	public void render(Graphics g)
	{
		if(Game.shoot)
		{
			if(shootLeft)
			{
				sprite = playershootsprite[11];
			}
			else if(shootRight)
			{
				sprite = playershootsprite[23];

			}
			else if(shootUp)
			{
				sprite = playershootsprite[5];

			}
			else if(shootDown)
			{
				sprite = playershootsprite[17];

			}
		}
		else if(walk)
		{
			if(left) 
			{
				sprite = playerwalksprite[curAnimation + 9];
			}
			else if(right)
			{
				sprite = playerwalksprite[curAnimation + 27];
			}
			else if(up)
			{
				sprite = playerwalksprite[curAnimation];
			}
			else if(down)
			{
				sprite = playerwalksprite[curAnimation + 18];
			}
		}
		else if (rel)
		{
			sprite = playerwalksprite[19];
		}

		frames++;
		if(frames>maxFrames)
        {
            frames = 0;
            curAnimation++;
            if(curAnimation > maxAnimation)
            {
            	curAnimation = 1;
            }
        }
		g.drawImage(sprite,x,y,65,90,null);
		health.render(g);
	}
}