package br.com.rafaellino;

import java.util.function.Function;

public interface Listener {

  void addMousedListener(Executor executor);
  void addKeyListener(Executor executor);
}
