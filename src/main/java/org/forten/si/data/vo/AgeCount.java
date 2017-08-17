package org.forten.si.data.vo;

/**
 * Created by Administrator on 2017/8/17.
 */
public class AgeCount {
    private int year;
    private int counts;

    public AgeCount(int year, int counts) {
        this.year = year;
        this.counts = counts;
    }

    public AgeCount() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getYearStr(){
        return year+"年";
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AgeCount{");
        sb.append("year=").append(year);
        sb.append(", counts=").append(counts);
        sb.append('}');
        return sb.toString();
    }
}
