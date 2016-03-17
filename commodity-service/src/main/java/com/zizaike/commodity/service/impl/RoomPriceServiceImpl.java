/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceServiceImpl.java  <br/>
 * Package Name:com.zizaike.commodity.service.impl  <br/>
 * Date:2016年3月14日下午4:37:58  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.service.impl;  

import java.util.List;

import com.zizaike.is.commodity.RoomPriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.zizaike.commodity.dao.RoomPriceDao;
import com.zizaike.commodity.domain.event.RoomPriceApplicationEvent;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.Active;
import com.zizaike.entity.commodity.RoomPrice;

/**  
 * ClassName:RoomPriceServiceImpl <br/>  
 * Function: 房间价. <br/>  
 * Date:     2016年3月14日 下午4:37:58 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
@Service
public class RoomPriceServiceImpl implements RoomPriceService {
    @Autowired
    private RoomPriceDao roomPriceDao;
    @Autowired
    ApplicationContext applicationContext;
    @Override
    public void insertOrUpdate(List<RoomPrice> list) throws ZZKServiceException {
        for (RoomPrice roomPrice : list) {
            if(roomPrice==null){
                throw new IllegalParamterException("roomPrice is not null");
            }
            if(roomPrice.getRoomTypeId()==null){
                throw new IllegalParamterException("roomPrice roomTypeId is not null");
            }
            if(roomPrice.getDate()==null){
                throw new IllegalParamterException("roomPrice date is not null");
            }
            if(roomPrice.getPrice()==null){
                throw new IllegalParamterException("roomPrice price is not null");
            }
            if(roomPrice.getUserId()==null){
                throw new IllegalParamterException("roomPrice userId is not null");
            }
            if(roomPrice.getCreateUId()==null){
                throw new IllegalParamterException("roomPrice createUid is not null");
            }
            if(roomPrice.getUpdateUId()==null){
                throw new IllegalParamterException("roomPrice updateUId is not null");
            }
            roomPrice.setActive(Active.LIVELY);
        }
        roomPriceDao.insertOrUpdate(list);
        applicationContext.publishEvent(new RoomPriceApplicationEvent(list));
    }
    
}
