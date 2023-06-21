package jm.web.game;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class BeeMacro {

	public static void main(String[] args) throws Exception {
		try {
			pressMouse();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_1);
			robot.keyRelease(KeyEvent.VK_1);
			Thread.sleep(50);
			robot.keyPress(KeyEvent.VK_F3);
			robot.keyRelease(KeyEvent.VK_F3);

			System.out.println("Key 1 pressed.");
			int count = 0;
			while (true) {
				if (count == 3000) {
					count = 0;
					pressMouse();
//					keyClick(robot, 15, KeyEvent.VK_W);
//					keyClick(robot, 15, KeyEvent.VK_A);
//					keyClick(robot, 7, KeyEvent.VK_S);
//					keyClick(robot, 5, KeyEvent.VK_D);
				}
				System.out.println("count=" + count);
				count++;
				keyClick(robot, 3, KeyEvent.VK_D);
				keyClick(robot, 3, KeyEvent.VK_S);
				keyClick(robot, 3, KeyEvent.VK_A);
				keyClick(robot, 3, KeyEvent.VK_W);
				
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	private static void keyClick(Robot robot, int dist, int key) throws InterruptedException {
		for (int i = 0; i < dist; i++) {
			robot.keyPress(key);
			Thread.sleep(100);
			robot.keyRelease(key);
		}
	}

	private static void pressMouse() throws InterruptedException {
		int x = 630;
		int y = 593;
		try {
			Robot robot = new Robot();
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(50);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			System.out.println("x=" + x + ", y=" + y + " clicked.");
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
