package br.espm.aviao;

import br.espm.cliente.Cliente;
import br.espm.desconto.Desconto;

public class Reserva {
    private Cliente cliente;
    private Assento assento;
    private double valorFinal;
    private double valorOriginal;

    public Reserva(Cliente cliente, Assento assento, double valorOriginal) {
        this.cliente = cliente;
        this.assento = assento;
        this.valorOriginal = valorOriginal;

        calcularValorFinal();
    }

    private void calcularValorFinal() {
        // Pq não verifica se é uma instância de pessoa jurídica? Assim mantém mais genérico caso o sistema aumente
        if (cliente instanceof Desconto) {
            valorFinal = ((Desconto) cliente).aplicarDesconto(valorOriginal);
        }
        else {
            valorFinal = valorOriginal;
        }
    }
}
