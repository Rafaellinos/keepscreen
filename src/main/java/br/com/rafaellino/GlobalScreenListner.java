package br.com.rafaellino;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class GlobalScreenListner implements Listener {

  public GlobalScreenListner() {
    try {
      GlobalScreen.registerNativeHook();
    } catch (NativeHookException e) {
      System.err.println("Failed");
      System.exit(1);
    }
  }


  @Override
  public void addMousedListener(Executor executor) {
    GlobalScreen.addNativeMouseListener(new NativeMouseListener() {
      @Override
      public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        executor.execute();
      }

      @Override
      public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        executor.execute();
      }

      @Override
      public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        executor.execute();
      }
    });
    GlobalScreen.addNativeMouseMotionListener(new NativeMouseMotionListener() {
      @Override
      public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        executor.execute();
      }

      @Override
      public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
        executor.execute();
      }
    });
  }

  @Override
  public void addKeyListener(Executor executor) {
    GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
      @Override
      public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        executor.execute();
      }

      @Override
      public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        executor.execute();
      }

      @Override
      public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        executor.execute();
      }
    });
  }
}
