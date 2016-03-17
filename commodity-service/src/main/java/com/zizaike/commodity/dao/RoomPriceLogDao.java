package com.zizaike.commodity.dao;

import java.util.List;

import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPriceLog;

/**
 * 
 * ClassName: RoomPriceLogDao <br/>  
 * Function: 房间价日志. <br/>  
 * date: 2016年3月17日 上午11:10:55 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
public interface RoomPriceLogDao {
    /**
     * 
     * insertBatch:批量插入. <br/>  
     *  
     * @author snow.zhang  
     * @param list
     * @throws ZZKServiceException  
     * @since JDK 1.7
     */
       void insertBatch(List<RoomPriceLog> list) throws ZZKServiceException;
       /**
        * 
        * add:增加日志. <br/>  
        *  
        * @author snow.zhang  
        * @param roomPriceLog
        * @throws ZZKServiceException  
        * @since JDK 1.7
        */
       void add(RoomPriceLog roomPriceLog)throws ZZKServiceException;
}
