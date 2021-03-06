package com.qingchi.base.model;


import java.util.Date;

public interface BaseModelDO {

    String getStatus();

    void setStatus(String status);

    String getDeleteReason();

    void setDeleteReason(String deleteReason);

    Integer getUserId();

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);

    String getContent();

    Date getCreateTime();

    Integer getReportNum();

    void setReportNum(Integer reportNum);

    String getViolateType();

    String getReportContentType();

    Integer getDbId();
}
