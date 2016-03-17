/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceLogService.java  <br/>
 * Package Name:com.zizaike.commodity.service  <br/>
 * Date:2016年3月17日上午11:28:15  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.service;  

import java.util.List;

import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPriceLog;

/**  
 * ClassName:RoomPriceLogService <br/>  
 * Function: 价格日志. <br/>  
 * Date:     2016年3月17日 上午11:28:15 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public interface RoomPriceLogService {
    /**
     * 
     * insertBatch:(这里用一句话描述这个方法的作用). <br/>  
     *  
     * @author snow.zhang
     * @param list
     * @throws ZZKServiceException 
     * @since JDK 1.7
     */
    void insertBatch(List<RoomPriceLog> list) throws ZZKServiceException;
}
  
