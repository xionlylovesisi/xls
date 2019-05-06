package com.xlm.stream.data;

/**
 * @author xls
 * @date 2019-04-18
 * @description 用户信息
 */
public class UserSessionInfo {
    private Integer observerId;
    private String name;
    private String employeeNo;

    public UserSessionInfo() {
    }

    public Integer getObserverId() {
        return this.observerId;
    }

    public void setObserverId(Integer observerId) {
        this.observerId = observerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNo() {
        return this.employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String toString() {
        return "UserSessionInfo [ObserverId=" + this.observerId + ",name=" + this.name + ",name=" + this.name + ",employeeNo=" + this.employeeNo + "]";
    }
}