package com.zizaike.commodity.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.ZZKServiceException;
import com.zizaike.is.redis.HotRecommendRedisService;

@Controller
@RequestMapping("/search/recommend")
public class HotRecommendController extends BaseAjaxController {
    @Autowired
    private HotRecommendRedisService hotRecommendRedisService;

    @RequestMapping(value = "hot", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult getHotRecommend() throws ZZKServiceException {
        ResponseResult result = new ResponseResult();
        result.setInfo(hotRecommendRedisService.qury());
        return result;
    }
}