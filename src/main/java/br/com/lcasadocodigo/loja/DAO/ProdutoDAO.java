package br.com.lcasadocodigo.loja.DAO;

import br.com.lcasadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ProdutoDAO {

    //Criando um gerenciado de entidade
    @PersistenceContext
    private EntityManager manager;

    public void gravar (Produto produto){
        manager.persist(produto);
    }


}
