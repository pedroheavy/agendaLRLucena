package models;

import io.ebean.*;
import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;


@Entity
public class Contato extends Model{
    @Id
    public Integer id;
    public String nome;
    public String email;
    public String telefone;

    @ManyToOne
    public Usuario usuario;
    
    public Contato(Integer id, String nome, String email, String telefone){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public static final Finder<Integer, Contato> find = new Finder<>(Contato.class);
}