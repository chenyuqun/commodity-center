/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceDaoImpl.java  <br/>
 * Package Name:com.zizaike.commodity.dao.impl  <br/>
 * Date:2016年3月14日下午4:31:00  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.dao.impl;  

import java.util.List;

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
    public void updateBatch(List<RoomPrice> list) throws ZZKServiceException {
       this.getSqlSession().insert(NAMESPACE+"updateBatch", list);
    }

}
  
