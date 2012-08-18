package com.petterroea.shipwrecked;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, FocusListener{
	public static boolean[] keys;
	public static int mouseX = 0;
	public static int mouseY = 0;
	public static boolean focused = true;
	private Main main;
	//Constructor ;)
	public Input(Main main) {
		keys = new boolean[600];
		for(int i = 0; i < 600; i++)
		{
			keys[i]=false;
		}
		this.main = main;
	}
	public enum MouseButton{
		LEFT,
		MIDDLE,
		RIGHT,
		UNKNOWN
	}
	public MouseButton getButton(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			return MouseButton.LEFT;
		if(e.getButton()==MouseEvent.BUTTON2)
			return MouseButton.MIDDLE;
		if(e.getButton()==MouseEvent.BUTTON3)
			return MouseButton.RIGHT;
		return MouseButton.UNKNOWN;
	}
	/*
	 * Listeners
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		mouseX=arg0.getX();
		mouseY=arg0.getY();
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		mouseX=arg0.getX();
		mouseY=arg0.getY();
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		main.currentScreen.click(arg0);
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// We dont need this
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// We dont need this
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		main.currentScreen.mousePress(getButton(arg0));
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		main.currentScreen.mouseRelease(getButton(arg0));
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()<600){
			keys[arg0.getKeyCode()]=true;
		}
		main.currentScreen.keyPressed(arg0);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()<600){
			keys[arg0.getKeyCode()]=false;
		}
		main.currentScreen.keyReleased(arg0);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// Not needed for games
		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		focused=true;
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		focused=false;
		
	}

}
