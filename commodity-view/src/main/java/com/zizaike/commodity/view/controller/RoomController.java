package com.zizaike.commodity.view.controller;

import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.entity.base.ChannelType;
import com.zizaike.entity.solr.SearchType;
import com.zizaike.entity.solr.SearchWordsVo;
import com.zizaike.is.solr.RoomSolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project Name: code <br/>
 * Function:RoomController. <br/>
 * date: 2016/5/12 10:38 <br/>
 *
 * @author alex
 * @since JDK 1.7
 */
@Controller
@RequestMapping("/search/room")
public class RoomController extends BaseAjaxController {
    @Autowired
    private RoomSolrService roomSolrService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getSearchResult(@RequestParam(value = "keyWords",required = false) String keyWords , @RequestParam(value = "destId",required = false) String destId, @RequestParam(value = "searchid",required = false) String searchid, @RequestParam(value = "checkInDate",required = false) String checkInDate,
                                          @RequestParam(value = "checkOutDate", required = false) String checkOutDate, @RequestParam(value = "searchType",required = false) SearchType searchType, @RequestParam(value = "page",required = false) String page, @RequestParam(value = "price",required = false) String price, @RequestParam(value = "service",required = false) String service,
                                          @RequestParam(value = "roomModel",required = false) String roomModel, @RequestParam(value = "order",required = false) String order,@RequestParam("multilang") Integer multilang,@RequestParam("multiprice") Integer multiprice) throws ZZKServiceException, UnsupportedEncodingException {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(destId);
        if (!isNum.matches()&&destId!="") {
            throw new IllegalParamterException("destId type error");
        }
        Matcher isNum3 = pattern.matcher(page);
        if (!isNum3.matches()) {
            throw new IllegalParamterException("page type error");
        }
        Matcher isNum5 = pattern.matcher(order);
        if (!isNum5.matches()&&order!="") {
            throw new IllegalParamterException("order type error");
        }
        SearchWordsVo searchWordsVo=new SearchWordsVo();
        searchWordsVo.setCheckInDate(checkInDate);
        searchWordsVo.setCheckOutDate(checkOutDate);
        if(destId!=null&&destId!=""){
            searchWordsVo.setDestId(Integer.parseInt(destId));
        }
        if(keyWords!=null&&keyWords!=""){
            searchWordsVo.setKeyWords(keyWords);
        }
        if(page!=null||searchid!=""){
            searchWordsVo.setPage(Integer.parseInt(page));
        }else{
            searchWordsVo.setPage(1);
        }
        if(searchid!=null&&searchid!=""){
            searchWordsVo.setSearchid(Integer.parseInt(searchid));
        }
        searchWordsVo.setSearchType(searchType);
        if(roomModel!=null&&roomModel!=""){
            searchWordsVo.setRoomModel(Integer.parseInt(roomModel));
        }
        searchWordsVo.setService(service);
        searchWordsVo.setPrice(price);
        if(order!=null&&order!=""){
            searchWordsVo.setOrder(Integer.parseInt(order));
        }
        searchWordsVo.setChannel(ChannelType.WEB);
        if(multilang!=null){
            searchWordsVo.setMultilang(multilang);
        }
        if(multiprice!=null){
            searchWordsVo.setMultiprice(multiprice);
        }
        ResponseResult result = new ResponseResult();
        result.setInfo(roomSolrService.searchSolr(searchWordsVo));
        return result;
    }

    @RequestMapping(value = "/solr", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getSearchResult(@RequestParam Integer roomTypeId) throws ZZKServiceException{
        ResponseResult result = new ResponseResult();
        result.setInfo(roomSolrService.updateRoomPrice(roomTypeId));
        return result;
    }
}
