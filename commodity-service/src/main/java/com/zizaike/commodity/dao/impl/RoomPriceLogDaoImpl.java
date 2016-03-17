package com.zizaike.commodity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zizaike.commodity.dao.RoomPriceLogDao;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.impl.GenericMyIbatisDao;
import com.zizaike.entity.commodity.RoomPriceLog;

/**
 * 
 * ClassName: RoomPriceLogDaoImpl <br/>  
 * Function: 房价日志. <br/>  
 * date: 2016年3月17日 上午11:11:48 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
@Repository
public class RoomPriceLogDaoImpl  extends GenericMyIbatisDao<RoomPriceLog, Integer> implements RoomPriceLogDao{
    private static final String NAMESPACE = "com.zizaike.commodity.dao.RoomPriceLogMapper." ;
    @Override
    public void insertBatch(List<RoomPriceLog> list) throws ZZKServiceException {
       for (RoomPriceLog roomPriceLog : list) {
           add(roomPriceLog);
       }
    }
    @Override
    public void add(RoomPriceLog roomPriceLog) throws ZZKServiceException {
        this.getSqlSession().insert(NAMESPACE+"insertSelective", roomPriceLog);
    }
    
}
