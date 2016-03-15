/**  
 * Project Name:open-service  <br/>
 * File Name:Alibaba.java  <br/>
 * Package Name:com.zizaike.open.service  <br/>
 * Date:2016年1月11日下午4:51:02  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.service;  

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.zizaike.commodity.bastest.BaseTest;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;

/**  
 * ClassName:UserServiceTest <br/>  
 * Function: 房价服务. <br/>  
 * Date:     2016年1月11日 下午4:51:02 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public class RoomPriceTest extends BaseTest{
    @Autowired
    private RoomPriceService roomPriceService; 
    @Test(description = "add")
    public void add() throws ZZKServiceException {
        for (int i = 0; i < 10; i++) {
            RoomPrice roomPrice = new RoomPrice();
            roomPrice.setCreateAt(new Date());
            roomPrice.setRoomTypeId(i);
            roomPrice.setPrice(123);
            roomPrice.setCreateUId(123);
            roomPrice.setUpdateAt(new Date());
            roomPrice.setUpdateUId(123);
            roomPrice.setUserId(123);
            roomPrice.setDate(new Date(1232131223+i));
            roomPriceService.add(roomPrice);
        }
     
    }
    
   
    

}
  
