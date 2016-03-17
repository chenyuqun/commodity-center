
/**  
 * Project Name:open-service  <br/>
 * File Name:Alibaba.java  <br/>
 * Package Name:com.zizaike.open.service  <br/>
 * Date:2016年1月11日下午4:51:02  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
 */

package com.zizaike.commodity.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.zizaike.commodity.bastest.BaseTest;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPriceLog;

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
public class RoomPriceLogDaoTest extends BaseTest {
    @Autowired
    private RoomPriceLogDao roomPriceLogDao;

    @Test(description = "insertBatch")
    public void insertBatch() throws ZZKServiceException {
        List<RoomPriceLog> list = new ArrayList<RoomPriceLog>();
        for (int i = 0; i < 100; i++) {
            RoomPriceLog roomPriceLog = new RoomPriceLog();
            roomPriceLog.setCreateAt(new Date());
            roomPriceLog.setRoomTypeId(1);
            roomPriceLog.setPrice(12 + i);
            roomPriceLog.setCreateUId(123);
            roomPriceLog.setUpdateAt(new Date());
            roomPriceLog.setUpdateUId(123);
            roomPriceLog.setUserId(0 + i);
            roomPriceLog.setDate(new Date());
            list.add(roomPriceLog);
        }
        long start = System.currentTimeMillis();
        System.err.println("==========");
        roomPriceLogDao.insertBatch(list);
        System.err.println(System.currentTimeMillis() - start);

    }

}
