package br.com.rafaellino;

public class App {

  public static final long START_TIME = System.currentTimeMillis();

  public static void main(String[] args) throws Exception {
    final MouseMoveController mouseMoveController = new MouseMoveController(START_TIME);

    final Listener listener = new GlobalScreenListner();
    listener.addKeyListener(() -> mouseMoveController.setPassedTime(System.currentTimeMillis()));
    listener.addMousedListener(() -> mouseMoveController.setPassedTime(System.currentTimeMillis()));

    while (true) {
      mouseMoveController.moveMouse();
    }
  }
}
