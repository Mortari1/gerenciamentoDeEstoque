/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.gerenciamentodeestoque.DAO;

import br.projeto.gerenciamentodeestoque.model.Produto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Henrique
 */
public class ProdutoDAO extends AbstractDAO {
    public List<Produto> buscarTodos() throws Exception{
        Criteria criteria = getSession().createCriteria(Produto.class);
        criteria.addOrder(Order.asc("item"));
        return criteria.list();
    }
    
    public List<Produto> buscarPorItem(String item) throws Exception{
        Criteria criteria = getSession().createCriteria(Produto.class);
        criteria.add(Restrictions.ilike("item", "%"+ item +"%"));
        criteria.addOrder(Order.asc("item"));
        return criteria.list();
    }
}
