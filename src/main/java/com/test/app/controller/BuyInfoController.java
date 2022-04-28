package com.test.app.controller;

import org.springframework.web.servlet.ModelAndView;

import com.test.app.buyInfo.BuyInfoVO;
import com.test.app.buyInfo.impl.BuyInfoDAO;

public class BuyInfoController {
	
	
	
	public String BuyInfo_insert(BuyInfoVO vo, BuyInfoDAO buyInfoDao) {
		buyInfoDao.BuyInfo_insert(vo);
		return "";
	}

	
	public ModelAndView BuyInfo_selectAll(BuyInfoVO vo, BuyInfoDAO buyInfoDao, ModelAndView mav) {
		buyInfoDao.BuyInfo_selectAll(vo);
		return mav;
	}

	
	public String BuyInfo_delete(BuyInfoVO vo, BuyInfoDAO buyInfoDao) {
		buyInfoDao.BuyInfo_delete(vo);
		return "";
	}

	
	public ModelAndView BuyInfo_search(BuyInfoVO vo, BuyInfoDAO buyInfoDao, ModelAndView mav) {
		buyInfoDao.BuyInfo_search(vo);
		return mav;
	}

}
