package com.zizaike.commodity.view.controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zizaike.core.bean.ResponseResult;
import com.zizaike.core.framework.exception.IllegalParamterException;
import com.zizaike.core.framework.exception.ServiceException;
import com.zizaike.is.solr.UserSolrService;

@Controller
@RequestMapping("/search/user")
public class UserController extends BaseAjaxController {
    @Autowired
    private UserSolrService userSolrService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getAllAddress(HttpServletRequest request,@PathVariable String id) throws ServiceException{
	    ResponseResult result = new ResponseResult();
	     Pattern pattern = Pattern.compile("[0-9]*");
	     Matcher isNum = pattern.matcher(id);
         if( !isNum.matches() )
         {
               throw new IllegalParamterException("id type error");
         }
	    result.setInfo(userSolrService.queryUserById(Integer.parseInt(id)));
		return result;
	}
}