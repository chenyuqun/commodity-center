
/**  
 * Project Name:open-service  <br/>
 * File Name:Alibaba.java  <br/>
 * Package Name:com.zizaike.open.service  <br/>
 * Date:2016年1月11日下午4:51:02  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
 */

package com.zizaike.commodity.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.zizaike.commodity.bastest.BaseTest;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.is.commodity.RoomPriceService;

/**
 * ClassName:UserServiceTest <br/>
 * Function: 房价服务. <br/>
 * Date: 2016年1月11日 下午4:51:02 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class RoomPriceServiceTest extends BaseTest {
    @Autowired
    private RoomPriceService roomPriceService;

    @Test(description = "insertOrUpdate")
    public void insertOrUpdate() throws ZZKServiceException {
        List<RoomPrice> list = new ArrayList<RoomPrice>();
        for (int i = 0; i < 10; i++) {
            RoomPrice roomPrice = new RoomPrice();
            roomPrice.setRoomTypeId(1);
            roomPrice.setPrice(12 + i);
            roomPrice.setCreateUId(123);
            roomPrice.setUpdateUId(123);
            roomPrice.setUserId(0+i);
            roomPrice.setDate(new Date());
            list.add(roomPrice);
        }
        long start = System.currentTimeMillis();
        System.err.println("==========");
        String str = JSON.toJSONString(list);
        System.err.println(str);
        //roomPriceService.insertOrUpdate(list);
        System.err.println(System.currentTimeMillis() - start);

    }

    @Test(description = "测试转移")
    public void priceHistoryTransfer() throws  ZZKServiceException{
        roomPriceService.priceHistoryTransfer();
        System.out.println("Done");
    }
    @Test(description = "查询房价")
    public void queryByRoomTypeAndDate() throws  ZZKServiceException{
        List<RoomPrice> list= roomPriceService.queryByRoomTypeAndDate(0, 1, "", null);
        System.err.println(list);
    }
}


