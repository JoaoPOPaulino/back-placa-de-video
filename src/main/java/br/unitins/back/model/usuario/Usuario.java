package br.unitins.back.model.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.back.dto.request.usuario.UsuarioDTO;
import br.unitins.back.model.DefaultEntity;
import br.unitins.back.service.hash.HashService;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario extends DefaultEntity {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @NotBlank(message = "O CPF não pode ser vazio.") // Adiciona validação
    private String cpf; // Novo campo

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_telefone",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_telefone"))
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_endereco",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> enderecos = new ArrayList<>();
    private String nomeImagem;

    public Usuario() {
    }

    public Usuario(UsuarioDTO dto, HashService hashService) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.login = dto.login();
        this.senha = hashService.getHashSenha(dto.senha());
        this.perfil = Perfil.valueOf(dto.perfil());
        this.cpf = dto.cpf(); // Adiciona CPF
        if (dto.telefones() != null && !dto.telefones().isEmpty()) {
            this.telefones = dto.telefones().stream().map(Telefone::new).collect(Collectors.toList());
        }
        if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
            this.enderecos = dto.enderecos().stream().map(Endereco::new).collect(Collectors.toList());
        }
    }

    public void atualizarComDTO(UsuarioDTO dto, HashService hashService) {
    this.nome = dto.nome();
    this.email = dto.email();
    this.login = dto.login();
    if (dto.senha() != null && !dto.senha().isEmpty()) {
        this.senha = hashService.getHashSenha(dto.senha());
    }
    this.cpf = dto.cpf();

    switch (dto.perfil()) {
        case 1:
            this.perfil = Perfil.USER;
            break;
        case 2:
            this.perfil = Perfil.ADMIN;
            break;
        default:
            throw new IllegalArgumentException("Perfil inválido: " + dto.perfil());
    }

    this.telefones = new ArrayList<>();
    if (dto.telefones() != null && !dto.telefones().isEmpty()) {
        this.telefones = dto.telefones().stream()
            .map(Telefone::new)
            .collect(Collectors.toList());
    }

    this.enderecos = new ArrayList<>();
    if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
        this.enderecos = dto.enderecos().stream()
                .map(Endereco::new)
                .collect(Collectors.toList());
    }

    this.nomeImagem = dto.nomeImagem();
}

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + ", login=" + login + ", perfil=" + perfil + ", cpf=" + cpf + "]";
    }
}
