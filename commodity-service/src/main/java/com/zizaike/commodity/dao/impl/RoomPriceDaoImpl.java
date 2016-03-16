/**  
 * Project Name:commodity-service  <br/>
 * File Name:RoomPriceDaoImpl.java  <br/>
 * Package Name:com.zizaike.commodity.dao.impl  <br/>
 * Date:2016年3月14日下午4:31:00  <br/>
 * Copyright (c) 2016, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.zizaike.commodity.dao.impl;  

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
    private static final String RoomPriceLog= "com.zizaike.commodity.dao.RoomPriceLogMapper.";
  
    @Override
    public void add(RoomPrice roomPrice) throws ZZKServiceException {
        this.getSqlSession().insert(NAMESPACE+"insertSelective", roomPrice);   
        

    }
    /**  
     * TODO 更新房价表.  
     * @see com.zizaike.commodity.dao.RoomPriceDao#update(com.zizaike.entity.commodity.RoomPrice)  
     */
    @Override
    public void update(RoomPrice roomPrice) throws ZZKServiceException {
          //更新房价表
          this.getSqlSession().update(NAMESPACE+"updateByPrimaryKeySelective",roomPrice);
        //添加到历史价格日志中
         this.getSqlSession().insert(RoomPriceLog+"insertSelective",roomPrice);
    }

}
  
