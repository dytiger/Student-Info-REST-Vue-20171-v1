package org.forten.si.bo;

import org.forten.si.data.vo.GenderCount;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/app-core.xml"})
public class CountBoTest {
    @Resource
    private CountBo bo;

    @Test
    public void testGetGenderCount(){
        List<GenderCount> list = bo.getGenderCount();
        Assert.assertEquals(2,list.size());
        System.out.println(list);
    }
}
