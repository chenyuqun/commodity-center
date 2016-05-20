package com.zizaike.commodity.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zizaike.commodity.domain.event.RoomPriceApplicationEvent;
import com.zizaike.commodity.service.RoomPriceLogService;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.entity.commodity.RoomPriceLog;

@Component
public class RoomPriceLogListener implements ApplicationListener<RoomPriceApplicationEvent> {
    protected final Logger LOG = LoggerFactory.getLogger(RoomPriceLogListener.class);
    @Autowired
    private RoomPriceLogService roomPriceLogService;

    @Async
    @Override
    public void onApplicationEvent(RoomPriceApplicationEvent event) {

        @SuppressWarnings("unchecked")
        List<RoomPrice> list = (List<RoomPrice>) event.getSource();
        String str = JSON.toJSONString(list);
        List<RoomPriceLog> logList = JSON.parseObject(str, new TypeReference<List<RoomPriceLog>>() {
        });
        try {
            roomPriceLogService.insertBatch(logList);
        } catch (ZZKServiceException e) {
            LOG.error("RoomPriceLogListener roomPriceLogService.insertBatch error{}", e);
            e.printStackTrace();
        }
    }

}