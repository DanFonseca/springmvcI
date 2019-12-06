package br.com.casadocodigo.loja.DAO;

import br.com.casadocodigo.loja.model.Produto;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    //Criando um gerenciado de entidade
    @PersistenceContext
    private EntityManager manager;
    @Transactional
    public void gravar (Produto produto){

        manager.persist(produto);
    }

    public List<Produto> listarProdutos (){
       List<Produto> produtos =
               manager.createQuery("select p from Produto as p").getResultList();
       return produtos;
    }

}
