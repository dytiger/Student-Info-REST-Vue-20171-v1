package org.forten.si.data.ro;

import org.forten.utils.collection.CollectionUtil;
import org.forten.utils.system.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11.
 */
public class RoWithPage<T> {
    private String message;
    private List<T> dataList;
    private PageInfo page;

    public RoWithPage(String message) {
        this(message,new ArrayList<>(0),PageInfo.EMPTY_PAGE);
    }

    public RoWithPage(List<T> dataList, PageInfo page) {
        this("",dataList,page);
    }

    public RoWithPage(String message, List<T> dataList, PageInfo page) {
        this.message = message;
        this.dataList = dataList;
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public PageInfo getPage() {
        return page;
    }

    public boolean isEmptyResult(){
        return CollectionUtil.isEmpty(dataList);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RoWithPage{");
        sb.append("message='").append(message).append('\'');
        sb.append(", dataList=").append(dataList);
        sb.append(", page=").append(page);
        sb.append('}');
        return sb.toString();
    }
}
