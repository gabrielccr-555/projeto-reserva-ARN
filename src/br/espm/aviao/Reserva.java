package br.espm.aviao;

import br.espm.cliente.Cliente;
import br.espm.cliente.PessoaFisica;
import br.espm.desconto.Desconto;

public class Reserva implements Comparable<Reserva> {
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

    public Reserva(Long identificador) {
        this.cliente = new PessoaFisica(identificador);
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

    // Estamos usando o compareTo que está dentro da classe long
    // Usado internamente na árvore para comparar objetos
    @Override
    public int compareTo(Reserva reserva) {
        return cliente.getIdentificador().compareTo(reserva.cliente.getIdentificador());
    }

    // PAra usar contains precisamos do equals.
    // Toda classe automaticamente já tem o equals implementado. Iremos sobrescrever ele.
    // O parâmetro precisa ser Object --> Casting para Reserva para que possamos acessar a reserva.
    // A comparação é com o Long (identificador) e ele já tem o equals dentro dele.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reserva) {
            Reserva reserva = (Reserva) obj;
            return cliente.getIdentificador().equals(reserva.cliente.getIdentificador());
        }
        return false;
    }
}
