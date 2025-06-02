package br.espm.cliente;

public class PessoaFisica extends Cliente {
    private Long cpf;

    public PessoaFisica(String nome, String contato, Long cpf) {
        super(nome, contato); // super --> Chamada do construtor da SuperClasse para inicializar os atributos
        this.cpf = cpf;
    }

    public PessoaFisica(Long identificador) {
        // Precisa chamar o construtor da super classe.
        this(null, null, identificador);
    }

    // Para implementar o método abstrato usamos a sobrecarga de método --> @Override
    @Override
    public Long getIdentificador() {
        return this.cpf;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
