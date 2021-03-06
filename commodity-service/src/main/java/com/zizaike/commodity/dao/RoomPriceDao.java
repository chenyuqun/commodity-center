/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceDao.java  <br/>
 * Package Name:com.zizaike.commodity.dao  <br/>
 * Date:2016年3月14日下午4:27:06  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/

package com.zizaike.commodity.dao;

import java.util.Date;
import java.util.List;

import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.springext.database.Master;
import com.zizaike.core.framework.springext.database.Slave;
import com.zizaike.entity.commodity.RoomPrice;

/**
 * ClassName:RoomPriceDao <br/>
 * Function: 房价. <br/>
 * Date: 2016年3月14日 下午4:27:06 <br/>
 *
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoomPriceDao {
    /**
     * 
     * updateBatch:批量更新. <br/>
     *
     * @author snow.zhang
     * @param roomPrice
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    @Master
    void insertOrUpdate(List<RoomPrice> roomPrice) throws ZZKServiceException;
    /**
     * getTransferData:获取要更新的数据. <br/>
     *
     * @author alex
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    @Master
    List<RoomPrice> getTransferData(String date) throws ZZKServiceException;

    /**
     * delete
     *
     * @author alex
     * @param date
     * @throws ZZKServiceException
     */
    @Master
    void deleteTransferData(String date) throws ZZKServiceException;
    /**
     * 
     * queryByRoomTypeAndDate:查询房型. <br/>  
     *  
     * @author snow.zhang  
     * @param roomTypeId
     * @param start
     * @param end
     * @return
     * @throws ZZKServiceException  
     * @since JDK 1.7
     */
    @Slave
    List<RoomPrice> queryByRoomTypeAndDate(Integer userId,Integer roomTypeId,String start,String end) throws ZZKServiceException;

}