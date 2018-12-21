package controllers;

import views.html.*;
import java.util.*;
import play.mvc.*;
import models.*;
import play.data.*;
import java.io.*;
import play.mvc.Result;
import play.mvc.Controller;
import javax.inject.Inject;

public class ContatosController extends Controller {
    @Inject
    private FormFactory formFactory;
    
    public Result index(){ //ok
        if (!session().containsKey("id")){
            session().put("uri", request().uri());
            return redirect(routes.HomeController.login());
        }
        List<Contato> contatos = Contato.find.all();
        return ok(views.html.index.render(contatos));
    }

    public Result create(){
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Form<Contato> formContato = formFactory.form(Contato.class);
        return ok(views.html.create.render(formContato));
    }

    public Result save(){
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Form<Contato> formContato = formFactory.form(Contato.class).bindFromRequest();
        Contato contato = formContato.get();
        contato.save();
        return redirect(routes.ContatosController.index());
    }

    public Result edit(Integer id){ //Meio certo
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Contato contato = Contato.find.byId(id);
        if (contato==null) {
                return notFound("Contato não encontrado.");
        }
        Form<Contato> formContato = formFactory.form(Contato.class).fill(contato);
        return ok(views.html.formulario.render(formContato));
    }

    public Result update(){ //ok ou não
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Form<Contato> formContato = formFactory.form(Contato.class).bindFromRequest();
        Contato contato = formContato.get();
        Contato contatoAntigo = Contato.find.byId(contato.id);
        if (contatoAntigo==null) {
            return notFound("Contato não encontrado.");
        }
        contatoAntigo.nome = contato.nome;
        contatoAntigo.email = contato.email;
        contatoAntigo.telefone = contato.telefone;
        contatoAntigo.update();
        return redirect(routes.ContatosController.index());
    }

    public Result show (Integer id){ //ok
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Contato contato = Contato.find.byId(id);
        if(contato==null) {
            return notFound("Contato não encontrado.");
        }
        return ok(views.html.show.render(contato));
    }

    public Result destroy(Integer id){ //ok
        if (!session().containsKey("id")){
            return redirect(routes.HomeController.login());
        }
        Contato contato = Contato.find.byId(id);
        if (contato==null) {
            return notFound("Contato não encontrado.");
        }
        contato.delete();
        return redirect(routes.ContatosController.index());
    }
}