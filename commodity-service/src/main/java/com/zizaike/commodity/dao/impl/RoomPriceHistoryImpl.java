package com.zizaike.commodity.dao.impl;

import com.zizaike.commodity.dao.RoomPriceHistoryDao;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.mybatis.impl.GenericMyIbatisDao;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.entity.commodity.RoomPriceHistory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project Name: code <br/>
 * Function:RoomPriceHistoryImpl. <br/>
 * date: 2016/3/1714:50 <br/>
 *
 * @author alex
 * @since JDK 1.7
 */
@Repository
public class RoomPriceHistoryImpl extends GenericMyIbatisDao<RoomPriceHistory, Integer> implements RoomPriceHistoryDao {

    private static final String NAMESPACE = "com.zizaike.commodity.dao.RoomPriceHistoryMapper." ;

    @Override
    public void transferBatch(List<RoomPrice> list) throws ZZKServiceException {

        for(RoomPrice roomPrice:list){
            RoomPriceHistory roomPriceHistory=new RoomPriceHistory();
            BeanUtils.copyProperties(roomPrice,roomPriceHistory);
            this.getSqlSession().insert(NAMESPACE+"inserintohistory",roomPriceHistory);
        }
    }
}
