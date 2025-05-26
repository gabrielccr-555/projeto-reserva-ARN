package br.espm.cliente;

import java.util.Random;

import br.espm.desconto.Desconto;

public class PessoaJuridica extends Cliente implements Desconto {
    private Long cnpj;

    public PessoaJuridica(String nome, String contato, Long cnpj) {
        super(nome, contato);
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    // Método da SuperClasse
    @Override
    public Long getIdentificador() {
        return this.cnpj;
    }

    // Método da interface
    @Override
    public double aplicarDesconto(double valor) {
        Random random = new Random();
        double porcentagem = random.nextInt(1, 11);
        return valor - (valor * (porcentagem / 100));
    }

}
