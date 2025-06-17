package models.usuarios;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Usuario {

    public int id;
    public String nome;
    public int cpf;
    public LocalDate dataDeNascimento;
    public String email;
    public String senha;

    public Usuario(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return getId() == usuario.getId() && getCpf() == usuario.getCpf() && Objects.equals(getNome(), usuario.getNome()) && Objects.equals(getDataDeNascimento(), usuario.getDataDeNascimento()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getSenha(), usuario.getSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getDataDeNascimento(), getEmail(), getSenha());
    }

	
	@Override


    @Override

    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", dataDeNascimento=" + dataDeNascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
