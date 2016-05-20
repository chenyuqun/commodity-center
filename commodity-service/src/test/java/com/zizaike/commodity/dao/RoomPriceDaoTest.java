
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.zizaike.commodity.bastest.BaseTest;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;

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
public class RoomPriceDaoTest extends BaseTest {
    @Autowired
    private RoomPriceDao roomPriceDao;

    @Test(description = "insertOrUpdate")
    public void insertOrUpdate() throws ZZKServiceException {
        List<RoomPrice> list = new ArrayList<RoomPrice>();
        for (int i = 0; i < 10; i++) {
            RoomPrice roomPrice = new RoomPrice();
            roomPrice.setCreateAt(new Date());
            roomPrice.setRoomTypeId(1);
            roomPrice.setPrice(12 + i);
            roomPrice.setCreateUId(123);
            roomPrice.setUpdateAt(new Date());
            roomPrice.setUpdateUId(123);
            roomPrice.setUserId(0 + i);
            roomPrice.setDate(new Date());
            list.add(roomPrice);
        }
        long start = System.currentTimeMillis();
        System.err.println("==========");
        roomPriceDao.insertOrUpdate(list);
        System.err.println(System.currentTimeMillis() - start);

    }
    public static void main(String[] args) {
       
        Pattern idsPattern = Pattern.compile("^(19|20)\\d{2}-[0|1]\\d-[0123]\\d$");
        Matcher matcher = idsPattern.matcher("1988-12-20");
        System.err.println(matcher.matches());
    }

}
