package com.zizaike.commodity.service.impl;

import com.google.code.shardbatis.strategy.ShardStrategy;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.entity.commodity.RoomPriceHistory;
import com.zizaike.entity.commodity.RoomPriceLog;

public class ShardStrategyImpl implements ShardStrategy {
    /**
     * 分表
     */
    private final static Integer TABLE_LEN = 32; 
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
            if (params instanceof RoomPriceLog) {
                RoomPriceLog roomPriceLog = (RoomPriceLog) params;
                Integer temp = roomPriceLog.getUserId();
                k = temp % TABLE_LEN;
                return baseTableName + "_" + k;
            }
        }
        if (params != null) {
            if (params instanceof RoomPriceHistory) {
                RoomPriceHistory roomPriceHistory = (RoomPriceHistory) params;
                Integer temp = roomPriceHistory.getUserId();
                k = temp % TABLE_LEN;
                return baseTableName + "_" + k;
            }
        }
        return baseTableName;
    }
}
