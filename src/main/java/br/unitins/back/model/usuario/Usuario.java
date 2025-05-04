package br.unitins.back.model.usuario;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_telefone",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_telefone"))
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_endereco",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private List<Endereco> enderecos;

    private String nomeImagem;

    public Usuario() {

    }

    public Usuario(UsuarioDTO dto, HashService hashService) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.login = dto.login();
        this.senha = hashService.getHashSenha(dto.senha());
        this.perfil = Perfil.valueOf(dto.perfil());

        if (dto.telefones() != null) {
            this.telefones.clear();
            this.telefones.addAll(dto.telefones().stream().map(Telefone::new).collect(Collectors.toList()));
        }

        if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
            this.enderecos.clear();
            this.enderecos.addAll(dto.enderecos().stream().map(Endereco::new).collect(Collectors.toList()));
        }
    }

    public void atualizarComDTO(UsuarioDTO dto, HashService hashService) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.login = dto.login();

        if (dto.senha() != null && !dto.senha().isEmpty()) {
            this.senha = hashService.getHashSenha(dto.senha());
        }
        this.perfil = Perfil.valueOf(dto.perfil());

        if (dto.telefones() != null && !dto.telefones().isEmpty()) {
            this.telefones = dto.telefones().stream()
                    .map(Telefone::new)
                    .collect(Collectors.toList());
        }

        if (dto.enderecos() != null && !dto.enderecos().isEmpty()) {
            this.enderecos = dto.enderecos().stream()
                    .map(Endereco::new)
                    .collect(Collectors.toList());
        }
    }

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

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + ", login=" + login + ", perfil=" + perfil + "]";
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
}
