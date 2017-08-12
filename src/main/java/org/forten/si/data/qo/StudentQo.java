package org.forten.si.data.qo;

/**
 * Created by Administrator on 2017/8/11.
 */
public class StudentQo {
    private String name;
    private int pageNo;
    private int pageSize;

    public StudentQo() {
        this.pageNo = 1;
        this.pageSize = 10;
    }

    public StudentQo(String name) {
        this();
        this.name = name;
    }

    public StudentQo(String name, int pageNo, int pageSize) {
        this.name = name;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StudentQo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", pageNo=").append(pageNo);
        sb.append(", pageSize=").append(pageSize);
        sb.append('}');
        return sb.toString();
    }
}
