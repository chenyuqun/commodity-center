/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceDaoImpl.java  <br/>
 * Package Name:com.zizaike.commodity.dao.impl  <br/>
 * Date:2016年3月14日下午4:31:00  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.dao.impl;  

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zizaike.commodity.dao.RoomPriceDao;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.impl.GenericMyIbatisDao;
import com.zizaike.entity.commodity.RoomPrice;

/**  
 * ClassName:RoomPriceDaoImpl <br/>  
 * Function: 房价. <br/>  
 * Date:     2016年3月14日 下午4:31:00 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
@Repository
public class RoomPriceDaoImpl extends GenericMyIbatisDao<RoomPrice, Integer> implements RoomPriceDao {
    private static final String NAMESPACE = "com.zizaike.commodity.dao.RoomPriceMapper." ;
    @Override
    public void insertOrUpdate(List<RoomPrice> list) throws ZZKServiceException {
       this.getSqlSession().insert(NAMESPACE+"insertOrUpdate", list);
    }

    @Override
    public List<RoomPrice> getTransferData(String date) throws ZZKServiceException {
        return this.getSqlSession().selectList(NAMESPACE+"getTransferData", date);
    }

    @Override
    public void deleteTransferData(String date) throws ZZKServiceException {
        this.getSqlSession().delete(NAMESPACE+"deleteTransferData",date);
    }

    @Override
    public List<RoomPrice> queryByRoomTypeAndDate(Integer userId,Integer roomTypeId, String start, String end) throws ZZKServiceException {
       Map map = new HashMap<>();
       map.put("userId", userId);
       map.put("roomTypeId", roomTypeId);
       map.put("start", start);
       map.put("end", end);
        return this.getSqlSession().selectList(NAMESPACE+"queryByRoomTypeAndDate", map);
    }
}
  
  
