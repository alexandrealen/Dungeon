import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Skeleton 
{
	public double x, y;
	private double VELOCITY = 1;
	public Spritesheet sheet;
	public BufferedImage skeletonL[], skeletonR[], skeletonD[], skeletonU[], sprite;
	private int frames = 0, maxFrames = 5, curAnimation = 0, maxAnimation = 1;
	public double catetox;
	public double catetoy;
	public double distanceFromPlayer;
	public static int hp1 = 50, hp2 = 50, hp3  = 50, hp4 = 50, hp5 = 100, hp6 = 100, hp7  = 100, hp8 = 100;
	
	public Skeleton(double x, double y, int hp)
	{
		this.x = x;
		this.y = y;
		sheet = new Spritesheet("/skeleton.png");
		skeletonL = new BufferedImage[2];
		skeletonR = new BufferedImage[2];
		skeletonD = new BufferedImage[2];
		skeletonU = new BufferedImage[2];
		skeletonL[0] = sheet.getSprite(3, 10, 64, 64);
		skeletonL[1] = sheet.getSprite(9, 10, 64, 64);
		skeletonR[0] = sheet.getSprite(3, 12, 64, 64);
		skeletonR[1] = sheet.getSprite(9, 12, 64, 64);
		skeletonD[0] = sheet.getSprite(3, 11, 64, 64);
		skeletonD[1] = sheet.getSprite(9, 11, 64, 64);
		skeletonU[0] = sheet.getSprite(3, 9, 64, 64);
		skeletonU[1] = sheet.getSprite(9, 9, 64, 64);
		sprite = sheet.getSprite(1, 3, 64, 64);
		
	}
	
	public void tick()
	{
		catetox = Player.x - x;
		catetoy = Player.y - y;
		distanceFromPlayer = Math.hypot((catetox),(catetoy));
		
		if(distanceFromPlayer <= 200 && Game.wave1) followPlayer();
		if(distanceFromPlayer <= 400 && Game.wave2)
		{
			VELOCITY = 2;
			followPlayer();
		}
		if(hp1 <= 0) 
			{
				Horda1.sk1 = false;
				Horda1.skeleton1.x = 0;
				Horda1.skeleton1.y = 0;
			}
		if(hp2 <= 0) 
			{
				Horda1.sk2 = false;
				Horda1.skeleton2.x = 0;
				Horda1.skeleton2.y = 0;
			}
		if(hp3 <= 0) 
			{
				Horda1.sk3 = false;
				Horda1.skeleton3.x = 0;
				Horda1.skeleton3.y = 0;
			}
		if(hp4 <= 0)
			{
				Horda1.sk4 = false;
				Horda1.skeleton4.x = 0;
				Horda1.skeleton4.y = 0;
			}
		if(hp5 <= 0) 
		{
			Horda2.sk5= false;
			Horda2.skeleton5.x = 0;
			Horda2.skeleton5.y = 0;
		}
	if(hp6 <= 0) 
		{
			Horda2.sk6 = false;
			Horda2.skeleton6.x = 0;
			Horda2.skeleton6.y = 0;
		}
	if(hp7 <= 0) 
		{
			Horda2.sk7 = false;
			Horda2.skeleton7.x = 0;
			Horda2.skeleton7.y = 0;
		}
	if(hp8 <= 0)
		{
			Horda2.sk8 = false;
			Horda2.skeleton8.x = 0;
			Horda2.skeleton8.y = 0;
		}
	}
	
	public void render(Graphics g)
	{
		if(x < Player.x) 
        {
			frames++;
			if(frames>maxFrames)
	        {
	            frames = 0;
	            curAnimation++;
	            if(curAnimation > maxAnimation)
	            {
	            	curAnimation = 0;
	            }
	        }
			g.drawImage(sprite, (int)x, (int)y, 65, 90,null);

        }
		else if(x > Player.x) 
        {
        	frames++;
			if(frames>maxFrames)
	        {
	            frames = 0;
	            curAnimation++;
	            if(curAnimation > maxAnimation)
	            {
	            	curAnimation = 0;
	            }
	        }
			g.drawImage(sprite, (int)x, (int)y, 65, 90,null);
        }
		else if(y < Player.y) 
        {
			frames++;
			if(frames>maxFrames)
	        {
	            frames = 0;
	            curAnimation++;
	            if(curAnimation > maxAnimation)
	            {
	            	curAnimation = 0;
	            }
	        }
			g.drawImage(sprite, (int)x, (int)y, 65, 90,null);

        }
		else if(y > Player.y) 
        {
        	frames++;
			if(frames>maxFrames)
	        {
	            frames = 0;
	            curAnimation++;
	            if(curAnimation > maxAnimation)
	            {
	            	curAnimation = 0;
	            }
	        }
			g.drawImage(sprite, (int)x, (int)y, 65, 90,null);
        }
        else
        {
        	sprite = sheet.getSprite(1, 3, 64, 64);
        	g.drawImage(sprite, (int)x, (int)y, 65, 90,null);
        }
	}
	
	public void followPlayer()
	{
		if(y < Player.y) 
        {
            y += VELOCITY;
            sprite = skeletonD[curAnimation];
        }
        if(y > Player.y) 
        {
            y -= VELOCITY;
            sprite = skeletonU[curAnimation];
        }
        if(x < Player.x) 
        {
            x += VELOCITY;
            sprite = skeletonR[curAnimation];
        }
        if(x > Player.x) 
        {
            x -= VELOCITY;
            sprite = skeletonL[curAnimation];
        }
	}
	

}
