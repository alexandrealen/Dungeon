import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fireball 
{
    public BufferedImage[] shootsprite;
    public Spritesheet shootsheet;
    public double x, y;
    public boolean up, right, left, down;

    public Fireball(double x, double y, Game game)
    {
    	this.x = x;
    	this.y = y;	
        shootsheet = new Spritesheet("/fireshoot.png");
        shootsprite = new BufferedImage[2];
		if(Player.shootUp)
		{
			up = true;
			shootsprite[0] = shootsheet.getSprite(3, 2, 64, 64);
		}
		else if(Player.shootDown)
		{
			down = true;
			shootsprite[0] = shootsheet.getSprite(1, 2, 64, 64);
		}
		else if(Player.shootLeft)
		{
			left = true;
			shootsprite[0] = shootsheet.getSprite(3, 1, 64, 64);
		}
		else if(Player.shootRight)
		{
			shootsprite[0] = shootsheet.getSprite(1, 1, 64, 64);
			right = true;
		}
    }

    public void tick()
    {
    	if(up)
    	{
    		y -= 10;
    	}
    	if(down)
    	{
    		y += 10;
    	}
    	if(left)
    	{
    		x -= 10;
    	}
    	if(right)
    	{
    		x += 10;
    	}
    }


    public void render(Graphics g)
    {
    	
        	g.drawImage(shootsprite[0], (int)x, (int)y, 34, 30,null);
    }
    public double getY()
    {
    	return y;
    }
    public double getX()
    {
    	return x;
    }
}
