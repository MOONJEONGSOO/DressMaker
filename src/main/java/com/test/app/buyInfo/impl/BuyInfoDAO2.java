package com.test.app.buyInfo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.buyInfo.BuyInfoVO;
//@Repository("buyInfoDAO")
public class BuyInfoDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String BUYINFO_INSERT="insert into buyInfo values((select nvl(max(inum),0)+1 from buyInfo),?,?)";
	private final String BUYINFO_SELECTALL="select * from buyInfo order by inum desc";
	private final String BUYINFO_SELECTALL_v2="select pname,BuyInfo.pnum from product, BuyInfo where BuyInfo.pnum=product.pnum and BuyInfo.mid=?";

	private final String BUYINFO_SEARCH="select * from buyInfo where mid=? order by inum desc"; // 아이디로 구매목록 검색

	private final String BUYINFO_DELETE="delete buyInfo where pnum=? and mid=?";



	public void BuyInfo_insert(BuyInfoVO vo) {
		jdbcTemplate.update(BUYINFO_INSERT, vo.getMid(), vo.getPnum());

	}



	public List<BuyInfoVO> BuyInfo_selectAll(BuyInfoVO vo) {

		return jdbcTemplate.query(BUYINFO_SELECTALL, new BuyInfoRowMapper());

	}
	public List<BuyInfoVO> BuyInfo_selectAll_v2(BuyInfoVO vo) {
		Object[] args= {vo.getMid()};
		return jdbcTemplate.query(BUYINFO_SELECTALL_v2, args, new BuyInfoRowMapper());

	}



	public void BuyInfo_delete(BuyInfoVO vo) {
		jdbcTemplate.update(BUYINFO_DELETE, vo.getPnum(), vo.getMid());

	}


	public List<BuyInfoVO> BuyInfo_search(BuyInfoVO vo) {
		Object[] args= {vo.getMid()};
		return jdbcTemplate.query(BUYINFO_SEARCH, args, new BuyInfoRowMapper());


	}


}

class BuyInfoRowMapper implements RowMapper<BuyInfoVO> {

	@Override
	public BuyInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BuyInfoVO data=new BuyInfoVO();

//		data.setInum(rs.getInt("inum"));
//		data.setMid(rs.getString("mid"));
		data.setPname(rs.getString("pname"));
		data.setPnum(rs.getInt("pnum"));


		return data;
	}

}
