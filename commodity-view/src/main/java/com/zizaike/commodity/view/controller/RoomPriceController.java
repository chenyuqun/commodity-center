package com.zizaike.commodity.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.commodity.RoomPrice;
import com.zizaike.is.commodity.RoomPriceService;
/**
 * 
 * ClassName: RoomPriceController <br/>  
 * Function: 房价相关. <br/>  
 * date: 2016年3月18日 上午11:02:51 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/commodity/roomPrice")
public class RoomPriceController extends BaseAjaxController {
    @Autowired
    private RoomPriceService roomPriceService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult add(@RequestBody ArrayList<JSONObject> roomPriceList) throws ZZKServiceException {
        List<RoomPrice> list = JSON.parseObject(JSON.toJSONString(roomPriceList), new TypeReference<ArrayList<RoomPrice>>(){});
        roomPriceService.insertOrUpdate(list);
        ResponseResult result = new ResponseResult();
        return result;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult get(@RequestParam("userId") Integer userId,@RequestParam("roomTypeId") Integer roomTypeId,@RequestParam("start") String start,@RequestParam("end") String end) throws ZZKServiceException {
        ResponseResult result = new ResponseResult();
        result.setInfo(roomPriceService.queryByRoomTypeAndDate(userId, roomTypeId, start, end));
        return result;
    }
}