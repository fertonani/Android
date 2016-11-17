package atividade.usjt.com.br.atividade1.model;


import java.io.Serializable;

public class Login implements Serializable {
    private String agencia, conta, senha;

    public Login(String agencia, String conta, String senha) {
        this.senha = senha;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;

        Login login = (Login) o;

        if (agencia != null ? !agencia.equals(login.agencia) : login.agencia != null) return false;
        if (conta != null ? !conta.equals(login.conta) : login.conta != null) return false;
        return senha != null ? senha.equals(login.senha) : login.senha == null;

    }
}
