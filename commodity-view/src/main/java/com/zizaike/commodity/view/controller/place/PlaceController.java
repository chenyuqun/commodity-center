/**  
 * Project Name:commodity-view  <br/>
 * File Name:PlaceController.java  <br/>
 * Package Name:com.zizaike.commodity.view.controller.place  <br/>
 * Date:2015年11月5日下午4:35:49  <br/>
 * Copyright (c) 2015, zizaike.com All Rights Reserved.  
 *  
*/  

  
package com.zizaike.commodity.view.controller.place;  

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zizaike.commodity.view.controller.BaseAjaxController;
import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ServiceException;
import com.zizaike.is.solr.PlaceSolrService;

/**  
 * ClassName:PlaceController <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2015年11月5日 下午4:35:49 <br/>  
 * @author   alex  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */

@Controller
@RequestMapping("/search/place")
public class PlaceController extends BaseAjaxController {
    @Autowired
    private PlaceSolrService placeSolrService;
    @RequestMapping(value = "/{words}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getAllAddress(HttpServletRequest request,@PathVariable String words) throws ServiceException{
        ResponseResult result = new ResponseResult();
//         Pattern pattern = Pattern.compile("[0-9]*");
//         Matcher isNum = pattern.matcher(words);
//         if( !isNum.matches() )
//         {
//               throw new IllegalParamterException("id type error");
//         }
        result.setInfo(placeSolrService.queryPlaceByWords(words));
        return result;
    }
    
    @RequestMapping(value = "/{words}/{locid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getAllAddress(HttpServletRequest request,@PathVariable String words,@PathVariable String locid) throws ServiceException{
        ResponseResult result = new ResponseResult();
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(locid);
        if( !isNum.matches() )
        {
              throw new IllegalParamterException("locid type error");
        }
        result.setInfo(placeSolrService.queryPlaceByWordsAndLoc(words,Integer.parseInt(locid)));
        return result;
    }
}
  
