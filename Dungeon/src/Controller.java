import java.awt.Graphics;
import java.util.LinkedList;

public class Controller 
{
	
	public static LinkedList<Fireball> b = new LinkedList<Fireball>();
	Fireball tempFireball;
	Game game;
	
	public Controller(Game game)
	{
		this.game = game;
	}
	
	public void tick()
	{
		for(int i=0; i < b.size(); i++)
		{
			tempFireball = b.get(i);
			tempFireball.tick();
		}
		
	}
	
	public void render(Graphics g)
	{
		for(int i=0; i < b.size(); i++)
		{
			tempFireball = b.get(i);
			tempFireball.render(g);
			if(tempFireball.getY() >= 480)
			{
				removeFireball(tempFireball);
			}
			else if(tempFireball.getY() <= 55)
			{
				removeFireball(tempFireball);
			}
			else if(tempFireball.getX() >=  990)
			{
				removeFireball(tempFireball);
			}
			else if(tempFireball.getX() <= 60)
			{
				removeFireball(tempFireball);
			}
			if(tempFireball.getY() >= Horda1.skeleton1.y && tempFireball.getY() <= (Horda1.skeleton1.y + 90) && tempFireball.getX() >= Horda1.skeleton1.x && tempFireball.getX() <= (Horda1.skeleton1.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp1 -= 5;
			}
			if(tempFireball.getY() >= Horda1.skeleton2.y && tempFireball.getY() <= (Horda1.skeleton2.y + 90) && tempFireball.getX() >= Horda1.skeleton2.x && tempFireball.getX() <= (Horda1.skeleton2.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp2 -= 5;
			}
			if(tempFireball.getY() >= Horda1.skeleton3.y && tempFireball.getY() <= (Horda1.skeleton3.y + 90) && tempFireball.getX() >= Horda1.skeleton3.x && tempFireball.getX() <= (Horda1.skeleton3.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp3 -= 5;
			}
			if(tempFireball.getY() >= Horda1.skeleton4.y && tempFireball.getY() <= (Horda1.skeleton4.y + 90) && tempFireball.getX() >= Horda1.skeleton4.x && tempFireball.getX() <= (Horda1.skeleton4.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp4 -= 5;
			}
			if(tempFireball.getY() >= Horda2.skeleton5.y && tempFireball.getY() <= (Horda2.skeleton5.y + 90) && tempFireball.getX() >= Horda2.skeleton5.x && tempFireball.getX() <= (Horda2.skeleton5.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp5 -= 5;
			}
			if(tempFireball.getY() >= Horda2.skeleton6.y && tempFireball.getY() <= (Horda2.skeleton6.y + 90) && tempFireball.getX() >= Horda2.skeleton6.x && tempFireball.getX() <= (Horda2.skeleton6.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp6 -= 5;
			}
			if(tempFireball.getY() >= Horda2.skeleton7.y && tempFireball.getY() <= (Horda2.skeleton7.y + 90) && tempFireball.getX() >= Horda2.skeleton7.x && tempFireball.getX() <= (Horda2.skeleton7.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp7 -= 5;
			}
			if(tempFireball.getY() >= Horda2.skeleton8.y && tempFireball.getY() <= (Horda2.skeleton8.y + 90) && tempFireball.getX() >= Horda2.skeleton8.x && tempFireball.getX() <= (Horda2.skeleton8.x + 65))
			{
				removeFireball(tempFireball);
				Skeleton.hp8 -= 5;
			}
			
		}
	}
	
	public void addFireball(Fireball block)
	{
		b.add(block);
	}
	
	public static void removeFireball(Fireball block)
	{
		b.remove(block);
	}
	
	public static void clear()
	{
		for(int i=0; i < b.size(); i++)
		{
			b.remove(i);
			
		}
	}

}
