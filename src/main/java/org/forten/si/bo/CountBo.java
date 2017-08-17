package org.forten.si.bo;

import org.forten.si.dao.MyBatisDao;
import org.forten.si.data.vo.AgeCount;
import org.forten.si.data.vo.GenderCount;
import org.forten.si.mapper.Counts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@Service
public class CountBo {
    @Resource
    private MyBatisDao dao;

    @Transactional(readOnly = true)
    public List<GenderCount> getGenderCount(){
        Counts mapper = dao.getMapper(Counts.class);
        return mapper.getGenderCount();
    }

    @Transactional(readOnly = true)
    public List<AgeCount> getAgeCount(){
        Counts mapper = dao.getMapper(Counts.class);
        return mapper.getAgeCount();
    }
}
