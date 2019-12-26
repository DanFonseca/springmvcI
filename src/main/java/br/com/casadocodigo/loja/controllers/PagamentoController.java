package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("/pagamnto")
public class PagamentoController {
    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar (RedirectAttributes attributes){
        return () ->{

            String uri = "http://book-payment.herokuapp.com/payment";
            try{
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinhoCompras.getTotal()), String.class);
                System.out.println(response);
                attributes.addFlashAttribute("sucesso", response);
                return new ModelAndView("redirect:/produtos/");
            }catch (HttpClientErrorException e ){
                e.printStackTrace();
                attributes.addFlashAttribute("falha", "Ocorreu uma falha no pagamnento");
                return new ModelAndView("redirect:/produtos/");
            }

        };

    }
}
