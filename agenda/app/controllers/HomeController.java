package controllers;

import views.html.*;
import java.util.*;
import play.mvc.*;
import models.Usuario;
import play.data.*;
import java.io.*;
import play.mvc.Result;
import play.mvc.Controller;
import javax.inject.Inject;

public class HomeController extends Controller {
    @Inject
    private FormFactory formFactory;

    public Result login() {
        Form<Usuario> usuarioForm = formFactory.form(Usuario.class);
        return ok(views.html.login.render(usuarioForm));
    }

    public Result autenticar(){
        DynamicForm form = formFactory.form().bindFromRequest();
        String email = form.get("email");
        String senha = form.get("senha");

        Usuario usuario = Usuario.find.query()
                .where()
                .eq("email",email)
                .eq("senha",senha).findOne();

        if (email.equals(usuario.email) & senha.equals(usuario.senha)){
            session("id",usuario.id+"");
        }
        if (!session().containsKey("id")){
            return login();
        }
        return redirect(routes.ContatosController.index());
    }

    public Result sair(){
        session().clear();
        return login();
    }
}
