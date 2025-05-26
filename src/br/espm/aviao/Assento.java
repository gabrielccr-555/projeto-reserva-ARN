package br.espm.aviao;

public class Assento {
  private boolean disponivel;
  private int numAssento;

  // Não recebo disponivel como parâmetro! Isto não é controlado na criação do objeto
  public Assento(int numAssento) {
    this.numAssento = numAssento;
    this.disponivel = true;
  }
}
