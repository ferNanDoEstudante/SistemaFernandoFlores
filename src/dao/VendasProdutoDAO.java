/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.FhfVendas;
import bean.FhfVendasproduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u06739637130
 */
public class VendasProdutoDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FhfVendasproduto.class);
        criteria.add(Restrictions.eq("fhfIdVendaproduto", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FhfVendasproduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listProduto(FhfVendas fhfVendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FhfVendasproduto.class);
        criteria.add(Restrictions.eq("fhfVendas", fhfVendas));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
}
