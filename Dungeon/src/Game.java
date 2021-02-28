import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener
{
	
	public static int WIDTH = 1100;
	public static int HEIGHT = 600;
	public JFrame frame;
	public boolean isRunning, sr = true, sd = true, sl = true, su = true;
	public static boolean inicio  = true, loading, jogao /*= true*/, press, wave1/* = true*/, restart1, apertouR;
	public static boolean ganhouWave1, wave2;
	public BufferedImage image;
	public Menu menu;
	public static double xix, xiy;
	public static boolean click, shoot = false;
	public TaLoading taLoading;
	public Image fase1;
	public Player player;
	public Controller controller;
	public Press press1;
	public Horda1 horda1;
	public static Game game;
	public Horda2 horda2;
	public Fireball tempFireball;
	
	
	
	public Game()
	{
		frame = new JFrame("Ragatanga");
		frame.add(this);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addKeyListener(this);
		addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		menu = new Menu();
		taLoading = new TaLoading();
		fase1 = this.getImage("fase1.png");
		player = new Player(500, 180);
		controller = new Controller(this);
		press1 = new Press();
		horda1 = new Horda1();
		horda2 = new Horda2();
		
	}
	
	
	public static void main (String [] args)
	{
		Game game = new Game();
		game.start();
		new Thread(game).start();
	}
	
	public void start()
	{
		isRunning = true;
		Thread thread = new Thread();
		thread.start();
	}
	
	
	public void tick()
	{
		if(hasFocus())
		{
			frame.requestFocus();
		}
		if(inicio)
		{
		menu.tick();
		}
		if(loading)
		{
			taLoading.tick();
		}
		if (jogao)
		{
			if(press)
			{
				press1.tick();
			}
			else if(wave1)
			{
				player.tick();
				controller.tick();
				horda1.tick();
			}
			else if(wave2)
			{
				player.tick();
				controller.tick();
				horda2.tick();
			}
		}
	}
	
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) 
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        g = bs.getDrawGraphics();
        
        if(inicio)
        {
        	menu.render(g);
        }
        else if(loading)
        {
        	
        	taLoading.render(g);
        }
        if(jogao)
        {
        	if(press)
        	{
        		g.drawImage(fase1, 0, 0, WIDTH-10, HEIGHT-40, null);
            	player.render(g);
            	controller.render(g);
            	press1.render(g);

        	}
        	else if(wave1)
        	{
        		g.drawImage(fase1, 0, 0, WIDTH-10, HEIGHT-35, null);
        		player.render(g);
        		controller.render(g);
        		horda1.render(g);
        		if(restart1)
                {
                	g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
                    g.setColor(new Color(0,0,0));
                    g.drawString("Você perdeu, pressione 'R' para recomeçar",130,100);
                    
                    wave1 = false;
                }
        		if(ganhouWave1)
        		{
        			wave1 = false;
        			g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
                    g.setColor(new Color(0,0,0));
                    g.drawString("Boa cabaço, pressione 'Enter' para a proxima",130,100);


        		}
        	}
        	else if(wave2)
        	{
        		
        		g.drawImage(fase1, 0, 0, WIDTH-10, HEIGHT-35, null);
        		player.render(g);
        		controller.render(g);
        		horda2.render(g);
        	}
        }
        
        g.dispose();
        bs.show();
        
	}

	@Override
	public void run() 
	{
		long lastTime = System.nanoTime();
		double delta = 0;
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		
		while(isRunning)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1)
			{
			delta--;
			tick();
			render();
			}
		}	
		
	}


	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}


	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_D) 
        {
            player.right = true;
            player.walk = true;
            player.rel = false;
        }
        if(e.getKeyCode()  == KeyEvent.VK_A) 
        {
            player.left = true;
            player.walk = true;
            player.rel = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) 
        {
            player.up = true;
            player.walk = true;
            player.rel = false;
        }
        if(e.getKeyCode()  == KeyEvent.VK_S) 
        {
            player.down = true;
            player.walk = true;
            player.rel = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && restart1 == false && ganhouWave1 == false) 
        {
            Player.shootRight = true;
            shoot = true;
            if(sr)
            {
            controller.addFireball(new Fireball(player.x+80, player.y+55, this));
            }
            sr = false;
        }
        if(e.getKeyCode()  == KeyEvent.VK_LEFT && restart1 == false && ganhouWave1 == false) 
        {
            Player.shootLeft = true;
            shoot = true;
            if(sl)
            {
            controller.addFireball(new Fireball(player.x, player.y+55, this));
            }
            sl = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP && restart1 == false && ganhouWave1 == false) 
        {
            Player.shootUp = true;
            shoot = true;
            if(su)
            {
            controller.addFireball(new Fireball(player.x+40, player.y, this));
            }
            su = false;
        }
        if(e.getKeyCode()  == KeyEvent.VK_DOWN && restart1 == false && ganhouWave1 == false) 
        {
            Player.shootDown = true;
            shoot = true;
            if(sd)
            {
            controller.addFireball(new Fireball(player.x+40, player.y+110, this));
            }
            sd = false;
        }

	}


	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_D) 
        {
            player.right = false;
            player.walk = false;
            player.rel = true;
        }
        if(e.getKeyCode()  == KeyEvent.VK_A) 
        {
            player.left = false;
            player.walk = false;
            player.rel = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) 
        {
            player.up = false;
            player.walk = false;
            player.rel = true;
        }
        if(e.getKeyCode()  == KeyEvent.VK_S) 
        {
            player.down = false;
            player.walk = false;
            player.rel = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            Player.shootRight = false;
            shoot = false;
            sr = true;
        }
        if(e.getKeyCode()  == KeyEvent.VK_LEFT) 
        {
            Player.shootLeft = false;
			shoot = false;
			sl = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) 
        {
            Player.shootUp = false;
            shoot = false;
            su = true;
        }
        if(e.getKeyCode()  == KeyEvent.VK_DOWN) 
        {
            Player.shootDown = false;
            shoot = false;
            sd = true;
        }
        if(press)
        {
        	if(e.getKeyCode() == KeyEvent.VK_SPACE) 
            {
                press = false;
                wave1 = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER && ganhouWave1) 
        {
            wave2 = true;
            Player.x = 500;
        	Player.y = 180; 
        	Horda2.skeleton5.x = 500;
        	Horda2.skeleton5.y = 20;
        	Horda2.skeleton6.x = 500;
        	Horda2.skeleton6.y = 400;
        	Horda2.skeleton7.x = 50;
        	Horda2.skeleton7.y = 200;
        	Horda2.skeleton8.x = 959;
        	Horda2.skeleton8.y = 200;
        	ganhouWave1 = false;
        	
        }
        if(e.getKeyCode() == KeyEvent.VK_R) 
        {
            if(restart1)
            {
            	restart1 = false;
            	Horda1.skeleton1.hp1 = 50;
            	Horda1.skeleton2.hp2 = 50;
            	Horda1.skeleton3.hp3 = 50;
            	Horda1.skeleton4.hp4 = 50;
            	
            	Horda1.skeleton1.x = 500;
            	Horda1.skeleton1.y = 20; 
            	Horda1.skeleton2.x = 500;
            	Horda1.skeleton2.y = 400;
            	Horda1.skeleton3.x = 50;
            	Horda1.skeleton3.y = 200;
            	Horda1.skeleton4.x = 959;
            	Horda1.skeleton4.y = 200;
            	Horda1.sk1 = true;
            	Horda1.sk2 = true;
            	Horda1.sk3 = true;
            	Horda1.sk4 = true;
            	
            	Player.hp = 175;
            	Player.x = 500;
            	Player.y = 180;
            	wave1 = true;
            	
            }
        }

	}


	@Override
	public void mouseClicked(MouseEvent e) 
	{
		xix = e.getX();
		xiy = e.getY();
		click = true;
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Image getImage(String path) 
	{
        URL imageURL = getClass().getResource(path);
        if (imageURL == null) return null;
        return new ImageIcon(imageURL).getImage();
    }
}
