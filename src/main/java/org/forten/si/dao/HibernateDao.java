package org.forten.si.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public <T> List<T> findBy(String hql, Map<String, Object> params, int first, int max) {
        Session session = getSession();
        TypedQuery<T> query = session.createQuery(hql);
        for (Map.Entry<String, Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setFirstResult(first);
        query.setMaxResults(max);
        // Hibernate 5.2后，我们使用的Query是javax.persistence.Query
        // 所以我们要用以下一行或第二行的方式打开缓存
        query.setHint(QueryHints.HINT_CACHEABLE, "true");
        //        query.setHint( "org.hibernate.cacheable", "true");
        // Hibernate 5.2以前使用的Query是org.hibernate.Query
        // 应该用以下方式打开缓存
        // query.setCacheable(true);
        return query.getResultList();
    }

    public <T> T findOneBy(String hql, Map<String, Object> params) {
        Session session = getSession();
        TypedQuery<T> query = session.createQuery(hql);
        for (Map.Entry<String, Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setHint("org.hibernate.cacheable", "true");
        return query.getSingleResult();
    }

    public int execute(String hql, Map<String, Object> params) {
        Session session = getSession();
        Query query = session.createQuery(hql);
        for (Map.Entry<String, Object> entry :
                params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.executeUpdate();
    }

    private Session getSession() {
        return sf.getCurrentSession();
    }
}
