package com.qingchi.base.model.notify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "push_message")
public class PushMessageDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer notifyId;

    private Date createTime;

    private String platform;

    //todo 要考虑长度，考虑是否为null考虑关联关系，考虑唯一
    @Column(length = 2000)
    private String content;
    @Column(length = 2000)
    private String result;

    public PushMessageDO() {
    }

    public PushMessageDO(Integer notifyId, String content, String result, String platform) {
        this.notifyId = notifyId;
        this.createTime = new Date();
        this.content = content;
        this.result = result;
        this.platform = platform;
    }
}
