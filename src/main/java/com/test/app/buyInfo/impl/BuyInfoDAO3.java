package com.test.app.buyInfo.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.buyInfo.BuyInfoVO;
@Repository("buyInfoDAO")
public class BuyInfoDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void BuyInfo_insert(BuyInfoVO vo) {
		System.out.println("바이인포 로그"+vo);
		mybatis.insert("buyInfoDAO.BuyInfo_insert", vo);

	}

	public List<BuyInfoVO> BuyInfo_selectAll(BuyInfoVO vo) {

		return mybatis.selectList("buyInfoDAO.BuyInfo_selectAll", vo);

	}
	public List<BuyInfoVO> BuyInfo_selectAll_v2(BuyInfoVO vo) {
		System.out.println("ㅇ매 로그"+vo);
		return mybatis.selectList("buyInfoDAO.BuyInfo_selectAll_v2", vo);
	}



	public void BuyInfo_delete(BuyInfoVO vo) {
		mybatis.delete("buyInfoDAO.BuyInfo_delete", vo);
	}


	public List<BuyInfoVO> BuyInfo_search(BuyInfoVO vo) {
		return mybatis.selectList("buyInfoDAO.BuyInfo_search", vo);
		

	}


}
