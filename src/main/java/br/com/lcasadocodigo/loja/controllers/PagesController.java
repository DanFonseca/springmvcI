package br.com.lcasadocodigo.loja.controllers;

import br.com.lcasadocodigo.loja.models.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Configurando a classe de controller
@Controller
public class PagesController {
@RequestMapping("/")
    public String index(){
        System.out.println("Entrando na Home da CDC");
        return "home";
    }

}
