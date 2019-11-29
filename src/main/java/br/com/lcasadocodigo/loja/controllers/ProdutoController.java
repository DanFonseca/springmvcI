package br.com.lcasadocodigo.loja.controllers;
import br.com.lcasadocodigo.loja.DAO.ProdutoDAO;
import br.com.lcasadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/form")
    public String form (){
        return "produtos/form";
    }

    @RequestMapping("/cadastrarProduto")
    public String cadastrarProduto (Produto produto){
        System.out.println(produto);
        produtoDAO.gravar(produto);
        return "produtos/cadastradoComSucesso";
    }
}
