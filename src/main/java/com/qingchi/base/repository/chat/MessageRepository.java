package com.qingchi.base.repository.chat;

import com.qingchi.base.model.BaseModelDO;
import com.qingchi.base.model.chat.MessageDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * TODO〈一句话功能简述〉
 * TODO〈功能详细描述〉
 *
 * @author qinkaiyuan
 * @since TODO[起始版本号]
 */
public interface MessageRepository extends JpaRepository<MessageDO, Long> {
    Optional<BaseModelDO> findOneByIdAndStatus(Long id, String status);

    List<MessageDO> findTop30ByChatIdAndStatusInAndIdNotInOrderByCreateTimeDescIdDesc(Long chatId, List<String> msgStatus, List<Long> ids);

    Optional<MessageDO> findFirstOneByIdAndStatusIn(Long id, List<String> msgStatus);

    //未登陆时查询官方提供的chat列表
//    List<MessageDO> findTop30ByChatAndChatStatusAndStatusInOrderByCreateTimeDescIdDesc(ChatDO chat, String chatStatus, List<String> msgStatus);
}