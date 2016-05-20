package com.zizaike.commodity.dao;

import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.core.framework.springext.database.Master;
import com.zizaike.entity.commodity.RoomPrice;

import java.util.List;

/**
 * Project Name: code <br/>
 * Function:RoomPriceHistory. <br/>
 * date: 2016/3/1714:44 <br/>
 *
 * @author alex
 * @since JDK 1.7
 */
public interface RoomPriceHistoryDao {
    /**
     * tansfer. <br/>
     *
     * @author alex
     * @throws ZZKServiceException
     * @since JDK 1.7
     */
    @Master
    void transferBatch(List<RoomPrice> roomPrice) throws ZZKServiceException;
}
