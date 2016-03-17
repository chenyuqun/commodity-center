/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceService.java  <br/>
 * Package Name:com.zizaike.commodity.service  <br/>
 * Date:2016年3月14日下午4:37:01  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/

package com.zizaike.commodity.service;

import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;

/**
 * ClassName:RoomPriceService <br/>
 * Function: 房价. <br/>
 * Date: 2016年3月14日 下午4:37:01 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface RoomPriceService {
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
    /**
     * update:更新房价.<br/>
     * 
     * @author lin
     * @param roomPrice
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    void update(RoomPrice roomPrice) throws ZZKServiceException;
    /**
     *
     * add:转移所有当天的. <br/>
     *
     * @author alex
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    void priceHistoryTransfer() throws ZZKServiceException;
}
