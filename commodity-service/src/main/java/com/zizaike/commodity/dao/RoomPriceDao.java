/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceDao.java  <br/>
 * Package Name:com.zizaike.commodity.dao  <br/>
 * Date:2016年3月14日下午4:27:06  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/

package com.zizaike.commodity.dao;

import com.zizaike.core.framework.exception.ZZKServiceException;
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
     * add:增加房价. <br/>
     * 
     * @author snow.zhang
     * @param roomPrice
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    void add(RoomPrice roomPrice) throws ZZKServiceException;
}
