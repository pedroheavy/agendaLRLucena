package models;

import io.ebean.*;
import java.util.*;
import javax.persistence.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Usuario extends Model{
    @Id
    public Integer id;
    public String email;
    public String senha;

    @OneToMany(mappedBy="usuario")
    public List<Contato> contatos;

    public Usuario(Integer id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public static final Finder <Integer, Usuario> find = new Finder<>(Usuario.class);
}

