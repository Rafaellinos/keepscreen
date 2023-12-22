package br.com.rafaellino;

import java.awt.*;
import java.util.Random;

public class MouseMoveController {

  public static long MOVE_MOUSE_IN_MILLI = 5_000;
  public static final int MAX_Y = 400;
  public static final int MAX_X = 400;
  private long passedTime;
  private final Robot robot;
  private final Random random;

  private boolean isSleeping = false;

  public MouseMoveController(long startTime, long moveMouseInMilli) {
    MOVE_MOUSE_IN_MILLI = moveMouseInMilli;
    passedTime = startTime;
    this.random = new Random();
    try {
      this.robot = new Robot();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  public MouseMoveController(long startTime) {
    this(startTime, MOVE_MOUSE_IN_MILLI);
  }

  public long getPassedTime() {
    return passedTime;
  }

  public void setPassedTime(long passedTime) {
    System.out.println("resetting passed time");
    if (!isSleeping) {
      this.passedTime = passedTime;
      sleep();
    }
  }

  private void sleep() {
    isSleeping = true;
    try {
      Thread.sleep(MOVE_MOUSE_IN_MILLI - 500);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    isSleeping = false;
    passedTime = System.currentTimeMillis();
  }

  public boolean moveMouse() throws InterruptedException {
    long currentTime = System.currentTimeMillis();
    if (currentTime - this.passedTime >= MOVE_MOUSE_IN_MILLI) {
      System.out.println(MOVE_MOUSE_IN_MILLI / 1000 + " seconds passed, moving mouse");
      Point p = MouseInfo.getPointerInfo().getLocation();
      robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
      robot.mouseMove(p.x, p.y);
      sleep();
      return true;
    }
    return false;
  }
}
