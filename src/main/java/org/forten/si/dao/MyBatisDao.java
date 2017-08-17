package org.forten.si.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/17.
 */
@Repository
public class MyBatisDao {
    @Resource
    private SqlSessionFactory ssf;

    public SqlSession getSession(){
        return ssf.openSession();
    }

    public <T> T getMapper(Class<T> c){
        return getSession().getMapper(c);
    }
}
