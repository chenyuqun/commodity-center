package com.zizaike.commodity.service.impl;

import com.google.code.shardbatis.strategy.ShardStrategy;
import com.zizaike.entity.commodity.RoomPrice;

public class ShardStrategyImpl implements ShardStrategy {
    /**
     * 得到实际表名
     * 
     * @param baseTableName 逻辑表名,一般是没有前缀或者是后缀的表名
     * @param params mybatis执行某个statement时使用的参数
     * @param mapperId mybatis配置的statement id
     * @return
     */
    public String getTargetTableName(String baseTableName, Object params, String mapperId) {
        Integer k = 0;
        if (params != null) {
            if (params instanceof RoomPrice) {
                RoomPrice roomPrice = (RoomPrice) params;
                Integer temp = roomPrice.getRoomTypeId();
                k = temp % 32;
                return baseTableName + "_" + k;
            }
        }
        return baseTableName;
    }
}
