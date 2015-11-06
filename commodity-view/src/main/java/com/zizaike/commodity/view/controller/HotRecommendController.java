package com.zizaike.commodity.view.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.ServiceException;
import com.zizaike.is.recommend.HotRecommendService;

@Controller
@RequestMapping("/search/recommend/hot")
public class HotRecommendController extends BaseAjaxController {
    @Autowired
    private HotRecommendService hotRecommendService;
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getHotRecommend(HttpServletRequest request) throws ServiceException{
	    ResponseResult result = new ResponseResult();
	    result.setInfo(hotRecommendService.quryHotRecommend());
		return result;
	}
}