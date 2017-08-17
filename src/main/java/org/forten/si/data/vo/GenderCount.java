package org.forten.si.data.vo;

/**
 * Created by Administrator on 2017/8/17.
 */
public class GenderCount {
    private String gender;
    private int counts;

    public GenderCount() {
    }

    public GenderCount(String gender, int counts) {
        this.gender = gender;
        this.counts = counts;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GenderCount{");
        sb.append("gender='").append(gender).append('\'');
        sb.append(", counts=").append(counts);
        sb.append('}');
        return sb.toString();
    }
}
