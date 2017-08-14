package org.forten.si.bo;

import org.forten.si.dao.HibernateDao;
import org.forten.si.data.qo.StudentQo;
import org.forten.si.data.ro.Message;
import org.forten.si.data.ro.RoWithPage;
import org.forten.si.data.entity.Student;
import org.forten.si.data.vo.Student4Show;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
@Service
public class StudentBo {
    @Resource
    private HibernateDao dao;

    @Transactional
    public Message doSave(Student student) {
        try {
            dao.save(student);
            return new Message("保存成功");
        }catch(Exception e){
            e.printStackTrace();
            return new Message("保存数据失败");
        }
    }

    @Transactional(readOnly = true)
    public RoWithPage<Student4Show> query(StudentQo qo) {
        Map<String, Object> params = new HashMap<>(1);
        String hql = "SELECT new org.forten.si.data.vo.Student4Show(id,name,gender,birthday,hometown,nation,idCardNum,status,registTime) FROM Student WHERE 1=1 ";
        String countHql = "SELECT count(id) FROM Student WHERE 1=1 ";
        String name = qo.getName();
        if (StringUtil.hasText(name)) {
            hql = hql + "AND name LIKE :name ";
            countHql = countHql + "AND name LIKE :name ";
            params.put("name", "%" + name + "%");
        }

        long count = dao.findOneBy(countHql, params);
        if (count == 0) {
            return new RoWithPage<Student4Show>("无符合条件的数据");
        }

        hql = hql + "ORDER BY registTime DESC";

        PageInfo page = PageInfo.getInstance(qo.getPageNo(), qo.getPageSize(), (int)count);

        List<Student4Show> dataList = dao.findBy(hql, params, (int) page.getFirstResultNum(), page.getPageSize());

        return new RoWithPage<Student4Show>(dataList, page);
    }

    @Transactional(readOnly = true)
    public Student4Show queryById(int id) {
        Map<String, Object> params = new HashMap<>(1);
        String hql = "SELECT new org.forten.si.data.vo.Student4Show(id,name,gender,birthday,hometown,nation,idCardNum,status,registTime) FROM Student WHERE id=:id";
        params.put("id",id);
        return dao.findOneBy(hql,params);
    }

    @Transactional
    public Message doUpdate(Student4Show dto){
        String hql = "UPDATE Student SET name=:name,gender=:gender,birthday=:birthday,hometown=:hometown,idCardNum=:idCardNum,nation=:nation,status=:status WHERE id=:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", dto.getId());
        params.put("name", dto.getName());
        params.put("gender", dto.getGender());
        params.put("birthday", dto.getBirthday());
        params.put("hometown", dto.getHometown());
        params.put("idCardNum", dto.getIdCardNum());
        params.put("nation", dto.getNation());
        params.put("status", dto.getStatus());
        try {
            dao.execute(hql, params);
            return new Message("数据更新成功");
        }catch(Exception e){
            e.printStackTrace();
            return new Message("数据更新失败");
        }
    }

    @Transactional
    public Message doDelete(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            int i = dao.execute("DELETE FROM Student WHERE id=:id", params);
            return new Message("成功删除了" + i + "条数据");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("删除数据失败");
        }

    }
}
