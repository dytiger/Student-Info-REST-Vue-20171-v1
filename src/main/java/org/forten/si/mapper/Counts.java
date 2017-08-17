package org.forten.si.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.forten.si.data.vo.GenderCount;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
public interface Counts {
    @Results(value = {
            @Result(column = "g", property = "gender"),
            @Result(column = "c", property = "counts")
    })
    @Select("SELECT (case gender when 'M' then '男' when 'F' then '女' end) g, count(id) c FROM si_student GROUP BY gender ORDER BY gender DESC")
    public List<GenderCount> getGenderCount();
}
