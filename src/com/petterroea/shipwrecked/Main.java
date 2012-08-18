package com.petterroea.shipwrecked;

import java.applet.Applet;

import javax.swing.JFrame;

public class Main extends Applet implements Runnable{
	boolean running = true;
	Thread gameThread;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Shipwrecked");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		Main main = new Main();
		main.init();
		frame.add(main);
		frame.setVisible(true);
		main.start();
	}
	Screen currentScreen;
	Input input;
	@Override
	public void init() {
		input = new Input(this);
		this.addKeyListener(input);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
		this.addFocusListener(input);
		gameThread = new Thread(this);
	}
	@Override
	public void start() {
		gameThread.start();
	}
	@Override
	public void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		long lastUpdate = System.currentTimeMillis();
		int fps = 0;
		int frames = 0;
		long lastFpsUpdate = System.currentTimeMillis();
		while(running){
			//Stuff related to how good the game runs(FPS, delta, stuff like that)
			int delta = (int)(System.currentTimeMillis()-lastUpdate);
			lastUpdate = System.currentTimeMillis();
			if(System.currentTimeMillis()-lastFpsUpdate>1000)
			{
				fps = frames;
				frames = 0;
				lastFpsUpdate = System.currentTimeMillis();
				System.out.println("FPS: " + fps);
			}
			frames++;
		}
	}

}
