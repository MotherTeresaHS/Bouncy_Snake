// Created by Peter Zhu
// Created on Jan 2019
// This is Button
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Button {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private boolean enabled;
	private boolean pressed;
	
	private String text;
	private final Font font = new Font("Verdana", Font.PLAIN, 14);
	private ActionListener listener;
	
	//Constructor
	public Button(ActionListener listener, String text, int x, int y, int width, int height) {
		this.listener = listener;
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		enabled = true;
	}
	
	public void render(Graphics2D graph) {
		if(pressed) {
			graph.setColor(Color.blue);
		}else {
			graph.setColor(Color.YELLOW);
		}
		
		if(enabled) {
			graph.fillRect(x, y, width, height);
			graph.setFont(font);
			graph.setColor(Color.black);
			int stringWidth = graph.getFontMetrics().stringWidth(text);
			graph.drawString(text, x + width / 2 - stringWidth / 2, y + height / 2);
		}
		
	}
	
	private boolean isPressed(int x, int y) {
		
		return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
		
	}
	
	public void mousePressed(MouseEvent event) {
		if(isPressed(event.getX(), event.getY())) {
			pressed = true;
		}
	}
	
	public void mouseReleased(MouseEvent event) {
		if(pressed && enabled) {
			listener.actionPerformed(new ActionEvent(this));
			pressed = false;
		}
	}

}
