package com.qingchi.base.repository.user;

import com.qingchi.base.config.redis.RedisKeysConst;
import com.qingchi.base.model.user.LoveValueOrderDO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface LoveValueOrderRepository extends JpaRepository<LoveValueOrderDO, Long> {
    @CacheEvict(cacheNames = RedisKeysConst.userById, key = "#loveValue.userId")
    LoveValueOrderDO save(LoveValueOrderDO loveValue);

    Integer countByUserIdAndStatusAndEnableAndAwardAndCreateTimeBetween(Integer userId, String status, Boolean enable, Boolean award, Date startDate, Date endDate);
}

