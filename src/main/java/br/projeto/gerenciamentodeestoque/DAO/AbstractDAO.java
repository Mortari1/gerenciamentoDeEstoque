/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.projeto.gerenciamentodeestoque.DAO;

import br.projeto.gerenciamentodeestoque.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Henrique
 */
public abstract class AbstractDAO extends HibernateUtil {
    
    public void salvarOuAtualizar(Object obj){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(obj);
            session.flush();
            transaction.commit();
            session.close();
            
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }
    
    public void excluir(Object obj){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(obj);
            session.flush();
            transaction.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
    }
}
