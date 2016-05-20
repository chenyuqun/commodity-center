/**  
 * Project Name:redis-service  <br/>
 * File Name:SearchApplicationEvent.java  <br/>
 * Package Name:com.zizaike.redis.domain.event  <br/>
 * Date:2015年12月8日下午7:58:16  <br/>
 * Copyright (c) 2015, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.domain.event;  

import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.zizaike.entity.commodity.RoomPrice;

/**
 * 
 * ClassName: HotSearchApplicationEvent <br/>  
 * Function: 房价事件 <br/>  
 * date: 2016年3月17日 上午11:42:15 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
public class RoomPriceApplicationEvent extends ApplicationEvent {
    private static final long serialVersionUID = -6594827157066946884L;

    public RoomPriceApplicationEvent(List<RoomPrice> list) {
        super(list);  
    }


}
  
