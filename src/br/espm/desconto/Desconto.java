// Começaremos pela interface Desconto, que define o método aplicarDesconto

package br.espm.desconto;

// Não sabemos qual é a implementação dele, então utilizamos o método abstrato. Se não colocar, ele já assume por padrão que é abstrato
// Quando tu bota ; ele é um método abstrato. Se tu tira a palavrinha abstract ele já entende.
public interface Desconto {
    public abstract double aplicarDesconto(double valor);
}