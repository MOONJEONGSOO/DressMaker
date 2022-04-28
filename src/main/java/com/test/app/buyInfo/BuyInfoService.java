package com.test.app.buyInfo;

import java.util.List;

public interface BuyInfoService {

	public void BuyInfo_insert(BuyInfoVO vo);

	public List<BuyInfoVO> BuyInfo_selectAll(BuyInfoVO vo);

	public void BuyInfo_delete(BuyInfoVO vo);

	public List<BuyInfoVO> BuyInfo_search(BuyInfoVO vo);
	
	public List<BuyInfoVO> BuyInfo_selectAll_v2(BuyInfoVO vo);




}


