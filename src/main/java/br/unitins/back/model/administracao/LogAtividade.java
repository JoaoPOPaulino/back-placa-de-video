package br.unitins.back.model.administracao;

import java.time.LocalDateTime;

import br.unitins.back.model.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LogAtividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String acao;
    private LocalDateTime data;
    
    @ManyToOne
    private Usuario usuario;
}