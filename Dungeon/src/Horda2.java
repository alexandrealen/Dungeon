import java.awt.Color;
import java.awt.Graphics;

public class Horda2 
{
	public static Skeleton skeleton5, skeleton6, skeleton7, skeleton8;
	public Controller controller;
	public static boolean sk5 = true, sk6 = true, sk7 = true, sk8 = true;
	public Horda2()
	{
		skeleton5 = new Skeleton(0, 0, Skeleton.hp1);
		skeleton6 = new Skeleton(0, 0, Skeleton.hp2);
		skeleton7 = new Skeleton(0, 0, Skeleton.hp3);
		skeleton8 = new Skeleton(0, 0, Skeleton.hp4);
		controller = new Controller(Game.game);
	}
	
	public void tick()
	{
		if(sk5)skeleton5.tick();
		if(sk6)skeleton6.tick();
		if(sk7)skeleton7.tick();
		if(sk8)skeleton8.tick();
	}
	
	public void render(Graphics g)
	{
		if(sk5)skeleton5.render(g);
		if(sk6)skeleton6.render(g);
		if(sk7)skeleton7.render(g);
		if(sk8)skeleton8.render(g);
		if(sk5)g.setColor(Color.GRAY);
		if(sk5)g.fillRect((int)skeleton5.x + 7, (int)skeleton5.y, 50, 10);
		if(sk5)g.setColor(Color.GREEN);
		if(sk5)g.fillRect((int)skeleton5.x + 7, (int)skeleton5.y, skeleton5.hp5/2, 10);
		if(sk6)g.setColor(Color.GRAY);
		if(sk6)g.fillRect((int)skeleton6.x + 7, (int)skeleton6.y, 50, 10);
		if(sk6)g.setColor(Color.GREEN);
		if(sk6)g.fillRect((int)skeleton6.x + 7, (int)skeleton6.y, skeleton6.hp6/2, 10);
		if(sk7)g.setColor(Color.GRAY);
		if(sk7)g.fillRect((int)skeleton7.x + 7, (int)skeleton7.y, 50, 10);
		if(sk7)g.setColor(Color.GREEN);
		if(sk7)g.fillRect((int)skeleton7.x + 7, (int)skeleton7.y, skeleton7.hp7/2, 10);
		if(sk8)g.setColor(Color.GRAY);
		if(sk8)g.fillRect((int)skeleton8.x + 7, (int)skeleton8.y, 50, 10);
		if(sk8)g.setColor(Color.GREEN);
		if(sk8)g.fillRect((int)skeleton8.x + 7, (int)skeleton8.y, skeleton8.hp8/2, 10);
	}
}
