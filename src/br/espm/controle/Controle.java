package br.espm.controle;
import br.espm.aviao.Assento;
import br.espm.cliente.Cliente;
import br.espm.cliente.PessoaFisica;
import br.espm.cliente.PessoaJuridica;
import br.espm.aviao.Reserva;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    // O List é uma interface que fornece métodos tanto para o LinkedList quanto para o ArrayList, ou seja, os métodos servem para ambos; ele é uma superclasse
    // A  reserva será uma árvore --> Geralmente um map pede por uma inserção com (chave, valor), mas no treeset não precisa da chave
    // Lembrando --> O que é estático independe de objeto para serem chamados os métodos
    private static List<Cliente> listaCliente = new LinkedList<>();
    private static List<Assento> listaAssento = new LinkedList<>();
    private TreeSet<Reserva> listaReserva = new TreeSet<>();

    // Bloco estático --> automaticamente executado e armazenado na memória do computador
    static {
        // Lista de clientes
        listaCliente.add(new PessoaJuridica("ClienteA", "contatoa@gmail", 741L));
        listaCliente.add(new PessoaJuridica("ClienteB", "contatob@gmail", 852L));
        listaCliente.add(new PessoaFisica("ClienteC", "contatoc@gmail", 123L));
        listaCliente.add(new PessoaFisica("ClienteD", "contatod@gmail", 456L));

        // Lista de assentos
        for (int i = 1; i <= 10; i++) {
            listaAssento.add(new Assento(i));
        }
    }


    public void menu() {
        int opcao;

        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));
                switch(opcao) {
                    case 1:
                        reservar();
                        break;
                    case 2:
                        pesquisar();
                        break;
                    case 3:
                        cancelar();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            }
            catch(NumberFormatException e) {
                showMessageDialog(null, "você deve digitar um número");
            }
        }
    }

    private void cancelar() {
    }

    private void pesquisar() {
        
    }

    private void reservar() {
        // Necessário converter string para long
        Long identificador = Long.valueOf(showInputDialog("CPF/CNPJ"));
        Cliente cliente = pesquisarCliente(identificador);
        if (cliente != null) {
            int assento = parseInt(showInputDialog(listarAssento()));
            listaReserva.add(new Reserva(cliente, listaAssento.get(assento), 5000));
            listaAssento.get(assento).setDisponivel(false);
        }
        
    }

    // Se fosse tipo primitivo usariamos ==, mas não é, é Long
    // Aqui fazemos um for pelo objeto
    private Cliente pesquisarCliente(Long identificador) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getIdentificador().equals(identificador)) {
                return cliente;
            }
        }
        return null;
    }

    // E se eu quisesse acessar o objeto assento e pegar o numAssento dele? Retorno por objeto
    // Aqui temos um for que controla índice da lista
    private String listarAssento() {
        String aux = "";
        for (int i = 0; i < listaAssento.size(); i++) {
            aux += "Assento: " + (i + 1) + " ---> ";
            aux += listaAssento.get(i).isDisponivel() ? "Disponível" : "Indisponível";
            aux += "\n";
        }

        return aux;
    }

    private String gerarMenu() {
        String aux = "SISTEMA DE RESERVA DE PASSAGEM AÉREA\n";
        aux += "1. Reservar\n";
        aux += "2. Pesquisar reserva\n";
        aux += "3. Cancelar reserva\n";
        aux += "4. Finalizar";
        return aux;
    }
}
