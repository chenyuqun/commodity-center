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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zizaike.commodity.dao.RoomPriceLogDao;
import com.zizaike.commodity.service.RoomPriceLogService;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.Active;
import com.zizaike.entity.commodity.RoomPriceLog;

/**  
 * ClassName:RoomPriceServiceImpl <br/>  
 * Function: 房间价日志. <br/>  
 * Date:     2016年3月14日 下午4:37:58 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
@Service
public class RoomPriceLogServiceImpl implements RoomPriceLogService {
    @Autowired
    private RoomPriceLogDao roomPriceLogDao;
    @Override
    public void insertBatch(List<RoomPriceLog> list) throws ZZKServiceException {
        for (RoomPriceLog roomPriceLog : list) {
            if(roomPriceLog==null){
                throw new IllegalParamterException("roomPriceLog is not null");
            }
            if(roomPriceLog.getRoomTypeId()==null){
                throw new IllegalParamterException("roomPriceLog roomTypeId is not null");
            }
            if(roomPriceLog.getDate()==null){
                throw new IllegalParamterException("roomPriceLog date is not null");
            }
            if(roomPriceLog.getPrice()==null){
                throw new IllegalParamterException("roomPriceLog price is not null");
            }
            if(roomPriceLog.getUserId()==null){
                throw new IllegalParamterException("roomPriceLog userId is not null");
            }
            if(roomPriceLog.getCreateUId()==null){
                throw new IllegalParamterException("roomPriceLog createUid is not null");
            }
            if(roomPriceLog.getUpdateUId()==null){
                throw new IllegalParamterException("roomPriceLog updateUId is not null");
            }
            roomPriceLog.setActive(Active.LIVELY);
        }
        roomPriceLogDao.insertBatch(list);
    }
    
}
