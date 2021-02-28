import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Horda1 
{
	public static Skeleton skeleton1, skeleton2, skeleton3, skeleton4;
	public Controller controller;
	public static boolean sk1 = true, sk2 = true, sk3 = true, sk4 = true;
	public Horda1()
	{
		skeleton1 = new Skeleton(500, 20, Skeleton.hp1);
		skeleton2 = new Skeleton(500, 400, Skeleton.hp2);
		skeleton3 = new Skeleton(50, 200, Skeleton.hp3);
		skeleton4 = new Skeleton(959, 200, Skeleton.hp4);
		controller = new Controller(Game.game);
	}
	
	public void tick()
	{
		if(sk1)skeleton1.tick();
		if(sk2)skeleton2.tick();
		if(sk3)skeleton3.tick();
		if(sk4)skeleton4.tick();
	}
	
	public void render(Graphics g)
	{
		if(sk1)skeleton1.render(g);
		if(sk2)skeleton2.render(g);
		if(sk3)skeleton3.render(g);
		if(sk4)skeleton4.render(g);
		if(sk1)g.setColor(Color.GRAY);
		if(sk1)g.fillRect((int)skeleton1.x + 7, (int)skeleton1.y, 50, 10);
		if(sk1)g.setColor(Color.GREEN);
		if(sk1)g.fillRect((int)skeleton1.x + 7, (int)skeleton1.y, skeleton1.hp1, 10);
		if(sk2)g.setColor(Color.GRAY);
		if(sk2)g.fillRect((int)skeleton2.x + 7, (int)skeleton2.y, 50, 10);
		if(sk2)g.setColor(Color.GREEN);
		if(sk2)g.fillRect((int)skeleton2.x + 7, (int)skeleton2.y, skeleton2.hp2, 10);
		if(sk3)g.setColor(Color.GRAY);
		if(sk3)g.fillRect((int)skeleton3.x + 7, (int)skeleton3.y, 50, 10);
		if(sk3)g.setColor(Color.GREEN);
		if(sk3)g.fillRect((int)skeleton3.x + 7, (int)skeleton3.y, skeleton3.hp3, 10);
		if(sk4)g.setColor(Color.GRAY);
		if(sk4)g.fillRect((int)skeleton4.x + 7, (int)skeleton4.y, 50, 10);
		if(sk4)g.setColor(Color.GREEN);
		if(sk4)g.fillRect((int)skeleton4.x + 7, (int)skeleton4.y, skeleton4.hp4, 10);
	}

}
