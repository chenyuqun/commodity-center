/**
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceServiceImpl.java  <br/>
 * Package Name:com.zizaike.commodity.service.impl  <br/>
 * Date:2016年3月14日下午4:37:58  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.service.impl;

import com.zizaike.commodity.dao.RoomPriceDao;
import com.zizaike.commodity.dao.RoomPriceHistoryDao;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.Active;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.is.commodity.RoomPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    private RoomPriceHistoryDao roomPriceHistoryDao;
    @Override
    public void updateBatch(List<RoomPrice> list) throws ZZKServiceException {
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
        roomPriceDao.updateBatch(list);
    }


    @Override
    public void priceHistoryTransfer() throws ZZKServiceException {
        //t_room_price中的当天数据
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        List<RoomPrice> list=roomPriceDao.getTransferData(df.format(new Date()));
        System.out.println("测试数据是"+list);
        System.out.println("开始插入历史表"+list);
        roomPriceHistoryDao.transferBatch(list);
        System.out.println("删除原表数据"+list);
        roomPriceDao.deleteTransferData(df.format(new Date()));
    }

}
