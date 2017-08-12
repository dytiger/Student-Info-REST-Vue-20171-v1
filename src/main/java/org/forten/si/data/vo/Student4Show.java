package org.forten.si.data.vo;

import org.forten.utils.common.DateUtil;
import org.forten.utils.common.StringUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/11.
 */
public class Student4Show {
    private int id;
    private String name;
    private String gender;
    private Date birthday;
    private String hometown;
    private String nation;
    private String idCardNum;
    private int status;
    private Date registTime;

    public Student4Show() {
    }

    public Student4Show(int id, String name, String gender, Date birthday, String hometown, String nation, String idCardNum, int status, Date registTime) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.hometown = hometown;
        this.nation = nation;
        this.idCardNum = idCardNum;
        this.status = status;
        this.registTime = registTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getBirthdayStr() {
        if (birthday == null) {
            return "";
        } else {
            return DateUtil.convertDateToString(birthday, DateUtil.DATE_PATTERN);
        }
    }

    public void setBirthdayStr(String birthdayStr){
        if(StringUtil.hasText(birthdayStr)){
            this.birthday = DateUtil.convertStringToDate(birthdayStr,DateUtil.DATE_PATTERN);
        }
    }

    public String getRegistTimeStr() {
        if (registTime == null) {
            return "";
        } else {
            return DateUtil.convertDateToString(registTime, DateUtil.DATETIME_PATTERN);
        }
    }

    public String getStatusStr() {
        switch (status) {
            case 0:
                return "上课";
            case 1:
                return "毕业";
            case 2:
                return "休学";
            case 3:
                return "退学";
            default:
                return "未知";
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student4Show{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", hometown='").append(hometown).append('\'');
        sb.append(", nation='").append(nation).append('\'');
        sb.append(", idCardNum='").append(idCardNum).append('\'');
        sb.append(", status=").append(status);
        sb.append(", registTime=").append(registTime);
        sb.append('}');
        return sb.toString();
    }
}
