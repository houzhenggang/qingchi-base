package com.qingchi.base.model.notify;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qingchi.base.constant.NotifyType;
import com.qingchi.base.model.chat.MessageReceiveDO;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "notify")
public class NotifyDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer receiveUserId;

    //加入一列作为外键
    private Long messageReceiveId;

    //加入一列作为外键
    private Integer commentId;

    //加入一列作为外键
    private Integer reportId;

    //加入一列作为外键
    private Integer reportDetailId;

    //加入一列作为外键
    private Integer talkId;

    private String type;

    private Date createTime;

    private Boolean hasRead;

    public NotifyDO() {
        this.createTime = new Date();
        this.hasRead = false;
    }

    public NotifyDO(Integer userId, Integer receiveUserId) {
        this();
        this.userId = userId;
        this.receiveUserId = receiveUserId;
    }

    public NotifyDO(Integer userId, Integer receiveUserId, String type) {
        this(userId, receiveUserId);
        this.type = type;
    }

    public NotifyDO(MessageReceiveDO msg) {
        this(msg.getUserId(), msg.getReceiveUserId(), NotifyType.message);
        this.messageReceiveId = msg.getId();
    }

    public NotifyDO(Integer userId, Integer receiveUserId, Integer commentId, Integer talkId, String type) {
        this(userId, receiveUserId, type);
        this.commentId = commentId;
// 理论上无用，都使用comment.getTalkId       this.talkId = talkId;
    }

    public NotifyDO(Integer userId, Integer receiveUserId, Integer reportId, String type) {
        this(userId, receiveUserId, type);
        this.reportId = reportId;
    }

    public NotifyDO(MessageReceiveDO msg, String notifyType) {
        this(msg);
        this.type = notifyType;
    }
}
