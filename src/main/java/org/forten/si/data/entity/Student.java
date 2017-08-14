package org.forten.si.data.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/10.
 */
@Entity
@Table(name="si_student")
@Cacheable
@Cache(region = "entityCache",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column
    private String hometown;
    @Column
    private String nation;
    @Column(name="id_card_num")
    private String idCardNum;
    @Column
    private int status;
    @Column(name="regist_time")
    private Date registTime;

    public Student() {
        this.status = 0;
        this.registTime = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public String getNation() {
        return nation;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public int getStatus() {
        return status;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
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
