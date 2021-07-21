package com.bootjdbc.demo.pojo;/**
 * @Auther: hyy
 * @Date:2021/7/14 - 07 - 14 11:26
 * @Description:com.aoyang.health.entity.api.hesuan
 * @Version: 1.0
 */

/**
 *@author
 *@date2021/7/14 11:26
 *
 *
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"patientNo", "patientName", "birthDay"})
public class PatientInfo {

    @XmlElement(name="patientNo")
    private String patientNo;

    @XmlElement(name="patientName")
    private String patientName;

    @XmlElement(name="birthDay")
    private String birthDay;

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "PatientInfo{" +
                "patientNo='" + patientNo + '\'' +
                ", patientName='" + patientName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
