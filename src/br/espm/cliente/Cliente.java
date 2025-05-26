package br.espm.cliente;

// A Superclasse precisa ser abstrata para conter métodos abstratos...
// A SuperClasse não será instanciada, ela não gera objeto, mas sim agrupa atributos e métodos para compartilhar.
public abstract class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    
    public abstract Long getIdentificador();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
