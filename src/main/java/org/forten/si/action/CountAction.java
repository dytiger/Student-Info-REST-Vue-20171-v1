package org.forten.si.action;

import org.forten.si.bo.CountBo;
import org.forten.si.data.vo.AgeCount;
import org.forten.si.data.vo.GenderCount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@RestController
public class CountAction {
    @Resource
    private CountBo bo;

    @RequestMapping(value = "/count/gender",method = RequestMethod.GET)
    public List<GenderCount> getGenderCount(){
        return bo.getGenderCount();
    }

    @RequestMapping(value = "/count/age",method = RequestMethod.GET)
    public List<AgeCount> getAgeCount(){
        return bo.getAgeCount();
    }
}
