package org.forten.si.action;

import org.forten.si.bo.StudentBo;
import org.forten.si.data.qo.StudentQo;
import org.forten.si.data.ro.Message;
import org.forten.si.data.entity.Student;
import org.forten.si.data.ro.RoWithPage;
import org.forten.si.data.vo.Student4Show;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
@RestController
public class StudentAction {
    @Resource
    private StudentBo bo;

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Message save(@RequestBody Student student) {
        return bo.doSave(student);
    }

    @RequestMapping(value = "/student/query", method = RequestMethod.POST)
    public RoWithPage<Student4Show> listBy(@RequestBody StudentQo qo) {
        return bo.query(qo);
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public Message update(@RequestBody Student4Show dto) {
        return bo.doUpdate(dto);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public Message delete(@PathVariable int id) {
        return bo.doDelete(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student4Show getById(@PathVariable int id) {
        return bo.queryById(id);
    }
}
