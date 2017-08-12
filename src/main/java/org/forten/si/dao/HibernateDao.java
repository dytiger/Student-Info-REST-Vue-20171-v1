package org.forten.si.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
@Repository
public class HibernateDao {
    @Resource
    private SessionFactory sf;

    public <T> void save(T entity) {
        getSession().save(entity);
    }

    public <T> List<T> findBy(String hql, Map<String, Object> params,int first,int max) {
        Session session = getSession();
        Query query = session.createQuery(hql);
        for (Map.Entry<String,Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }
        query.setFirstResult(first);
        query.setMaxResults(max);

        return query.getResultList();
    }

    public <T> T findOneBy(String hql, Map<String, Object> params){
        Session session = getSession();
        Query query = session.createQuery(hql);
        for (Map.Entry<String,Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }
        return (T)query.getSingleResult();
    }

    public int execute(String hql, Map<String, Object> params){
        Session session = getSession();
        Query query = session.createQuery(hql);
        for (Map.Entry<String,Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }

        return query.executeUpdate();
    }

    private Session getSession() {
        return sf.getCurrentSession();
    }
}
