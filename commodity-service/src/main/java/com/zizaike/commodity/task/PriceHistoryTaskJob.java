package com.zizaike.commodity.task;

import com.zizaike.is.commodity.RoomPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Project Name: code <br/>
 * Function:PriceHistoryTaskJob. <br/>
 * date: 2016/3/1620:24 <br/>
 *
 * @author alex
 * @since JDK 1.7
 */
@Component
public class PriceHistoryTaskJob {
    protected final Logger LOG = LoggerFactory.getLogger(PriceHistoryTaskJob.class);

    @Autowired
    private RoomPriceService roomPriceService;

    private static final String TIME = "0 30 0 * * ?";
    /**
     *
     * priceHistoryTransfer:数据迁移. <br/>
     *
     * @author alex
     * @since JDK 1.7
     */
    @Scheduled(cron = TIME)
    public void priceHistoryTransfer() {
        long start = System.currentTimeMillis();
        try {
            roomPriceService.priceHistoryTransfer();
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("when call priceHistoryTransfer, error{}",e.toString());
        }finally{
            LOG.info("when call priceHistoryTransfer, use: {}ms", System.currentTimeMillis() - start);
        }
    }
}
