package com.qingchi.base.model.openData;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 开发者账户
 */
@Data
@Entity
@Table(name = "dev_account")
/*, uniqueConstraints = {
@UniqueConstraint(columnNames = {"contentUnionType", "developerId", "userId"})
}*/
public class DevAccountDO {
    //开发者id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //密钥
    private String secretKey;
    //手机号
    private String phoneNum;

    //类型，帐户类型，个人，企业
    private String type;

    //个人或企业名称
    private String realName;

    //个人身份证，企业税号
    private String identityNum;


    //启用，还是失效
    private String status;
    //创建时间
    private Date createTime;
    private Date updateTime;

    //内容类型，id，关联商户，关联用户id
}