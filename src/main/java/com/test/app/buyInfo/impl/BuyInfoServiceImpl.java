package com.test.app.buyInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.buyInfo.BuyInfoService;
import com.test.app.buyInfo.BuyInfoVO;

@Service("BuyInfoService")
public class BuyInfoServiceImpl implements BuyInfoService{
	@Autowired
	private BuyInfoDAO3 buyInfoDao;

	@Override
	public void BuyInfo_insert(BuyInfoVO vo) {
		buyInfoDao.BuyInfo_insert(vo);
	}

	@Override
	public List<BuyInfoVO> BuyInfo_selectAll(BuyInfoVO vo) {
		return buyInfoDao.BuyInfo_selectAll(vo);
	}

	@Override
	public void BuyInfo_delete(BuyInfoVO vo) {
		buyInfoDao.BuyInfo_delete(vo);
	}

	@Override
	public List<BuyInfoVO> BuyInfo_search(BuyInfoVO vo) {
		return buyInfoDao.BuyInfo_search(vo);
	}

	@Override
	public List<BuyInfoVO> BuyInfo_selectAll_v2(BuyInfoVO vo) {
		return buyInfoDao.BuyInfo_selectAll_v2(vo);
	}

}
