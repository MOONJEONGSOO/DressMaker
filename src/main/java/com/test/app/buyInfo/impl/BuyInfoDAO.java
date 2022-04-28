package com.test.app.buyInfo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.buyInfo.BuyInfoVO;
import com.test.app.common.JDBCUtil;

public class BuyInfoDAO {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String BUYINFO_INSERT="insert into buyInfo values((select nvl(max(inum),0)+1 from buyInfo),?,?)";
	private final String BUYINFO_SELECTALL="select * from buyInfo order by inum desc";
	private final String BUYINFO_SELECTALL_v2="select pname,BuyInfo.pnum from product, BuyInfo where BuyInfo.pnum=product.pnum and BuyInfo.mid=?";
	
	private final String BUYINFO__SEARCH="select * from buyInfo where mid=? order by inum desc"; // 상품번호로 후기 검색
	
	private final String BUYINFO_DELETE="delete buyInfo where pnum=? and mid=?";
	
	
	
	public void BuyInfo_insert(BuyInfoVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BUYINFO_INSERT);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	

	public List<BuyInfoVO> BuyInfo_selectAll(BuyInfoVO vo) {
		List<BuyInfoVO> datas=new ArrayList<BuyInfoVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BUYINFO_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyInfoVO data=new BuyInfoVO();
				data.setMid(rs.getString("mid"));
				data.setPnum(rs.getInt("pnum"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public List<BuyInfoVO> BuyInfo_selectAll_v2(BuyInfoVO vo) {
		List<BuyInfoVO> datas=new ArrayList<BuyInfoVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BUYINFO_SELECTALL_v2);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyInfoVO data=new BuyInfoVO();
//				data.setMid(rs.getString("mid"));
				data.setPname(rs.getString("pname"));
				data.setPnum(rs.getInt("pnum"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	

	
	public void BuyInfo_delete(BuyInfoVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BUYINFO_DELETE);
			pstmt.setInt(1, vo.getPnum());
			pstmt.setString(2, vo.getMid());
			System.out.println("dao 로그  " +vo.getPnum() +""+vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	
	public List<BuyInfoVO> BuyInfo_search(BuyInfoVO vo) {
		List<BuyInfoVO> datas=new ArrayList<BuyInfoVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(BUYINFO__SEARCH);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyInfoVO data=new BuyInfoVO();
				data.setMid(rs.getString("mid"));
				data.setPnum(rs.getInt("pnum"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}

}
