
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

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.zizaike.commodity.bastest.BaseTest;
import com.zizaike.commodity.dao.RoomPriceDao;
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
public class RoomPriceTest extends BaseTest {
    @Autowired
    private RoomPriceService roomPriceService;
    @Autowired
    private RoomPriceDao roomPriceDao;

    @Test(description = "addOrUpdate")
    public void addOrUpdate() throws ZZKServiceException {
        List<RoomPrice> list = new ArrayList<RoomPrice>();
        for (int i = 0; i < 10; i++) {
            RoomPrice roomPrice = new RoomPrice();
            roomPrice.setCreateAt(new Date());
            roomPrice.setRoomTypeId(1);
            roomPrice.setPrice(12+i);
            roomPrice.setCreateUId(123);
            roomPrice.setUpdateAt(new Date());
            roomPrice.setUpdateUId(123);
            roomPrice.setUserId(0);
            roomPrice.setDate(new Date());
            //roomPriceService.addOrUpdate(roomPrice);
            //roomPriceDao.add(roomPrice);
            list.add(roomPrice);
        }
        long start = System.currentTimeMillis();
        System.err.println("==========");
        roomPriceService.updateBatch(list);
        System.err.println(System.currentTimeMillis() - start);
        

    }
    @Test(description = "updateBatch")
    public void updateBatch() throws ZZKServiceException {
        List<RoomPrice> list = new ArrayList<RoomPrice>();
        for (int i = 0; i < 10; i++) {
            RoomPrice roomPrice = new RoomPrice();
            roomPrice.setCreateAt(new Date());
            roomPrice.setRoomTypeId(1);
            roomPrice.setPrice(12+i);
            roomPrice.setCreateUId(123);
            roomPrice.setUpdateAt(new Date());
            roomPrice.setUpdateUId(123);
            roomPrice.setUserId(0);
            roomPrice.setDate(new Date());
            //roomPriceService.addOrUpdate(roomPrice);
            //roomPriceDao.add(roomPrice);
            list.add(roomPrice);
        }
        long start = System.currentTimeMillis();
        System.err.println("==========");
        roomPriceDao.updateBatch(list);
        System.err.println(System.currentTimeMillis() - start);
        
        
    }

}
