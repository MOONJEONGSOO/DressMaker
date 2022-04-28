package com.test.app.product.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.app.common.JDBCUtil;
import com.test.app.product.ProductVO;

public class ProductDAO {

	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private final String PRODUCT_INSERT="insert into product values((select nvl(max(pnum),0)+1 from product),?,?,?,?,'대여가능')";
	private final String PRODUCT_SELECTALL="select * from product order by pnum desc";
	private final String PRODUCT_SELECTONE="select * from product where pnum=?";
	private final String PRODUCT_UPDATE_1="update product set prental='대여중' where pnum=?";
	private final String PRODUCT_UPDATE_2="update product set prental='대여가능' where pnum=?";
	private final String PRODUCT_DELETE="delete product where pnum=?";


	private final String PRODUCT_SELECTALL_CNT="select count(*) as listcnt from product";
	private final String PRODUCT_SELECTALL_PAGE="select * from ( select rownum as rnum, A.pnum, A.pname, A.pimg, A.pprice, A.pinfo, A.prental from (select * from PRODUCT order by pnum desc) A) where rnum between ? and ?";
//	sql문 추가하고 인자에 페이지 int를 넣어놓음
	
//	cnt * 6 - 5
//	cnt * 6

	private final String PRODUCT_SEARCH="select * from product where pname like '%'||?||'%' and pprice BETWEEN ? AND ? order by pnum desc"; // 이름으로 검색 and 금액으로 검색
	
	
	public List<ProductVO> Product_selectAll_page(ProductVO vo, int page) {
		List<ProductVO> datas=new ArrayList<ProductVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_SELECTALL_PAGE);
			pstmt.setInt(1, (page*6)-5);
			pstmt.setInt(2, page*6);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data=new ProductVO();
				
				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPimg(rs.getString("pimg"));
				data.setPprice(rs.getInt("pprice"));
				data.setPinfo(rs.getString("pinfo"));
				data.setPrental(rs.getString("prental"));
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
	public int Product_selectAll_cnt(ProductVO vo) {
		int cnt=0;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_SELECTALL_CNT);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return cnt;
	}
	public List<ProductVO> Product_search(ProductVO vo, int max) {
		List<ProductVO> datas=new ArrayList<ProductVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_SEARCH);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getPprice());
			pstmt.setInt(3, max);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data=new ProductVO();

				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPimg(rs.getString("pimg"));
				data.setPprice(rs.getInt("pprice"));
				data.setPinfo(rs.getString("pinfo"));
				data.setPrental(rs.getString("prental"));
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
	
	
	
	public List<ProductVO> Product_selectAll(ProductVO vo) {
		List<ProductVO> datas=new ArrayList<ProductVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_SELECTALL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data=new ProductVO();
				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPimg(rs.getString("pimg"));
				data.setPprice(rs.getInt("pprice"));
				data.setPinfo(rs.getString("pinfo"));
				data.setPrental(rs.getString("prental"));
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
	
	public void Product_insert(ProductVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_INSERT);
			pstmt.setString(1, vo.getPname());
			pstmt.setString(2, vo.getPimg());
			pstmt.setInt(3, vo.getPprice());
			pstmt.setString(4, vo.getPinfo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public ProductVO Product_selectOne(ProductVO vo) {
		ProductVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_SELECTONE);
			pstmt.setInt(1, vo.getPnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new ProductVO();

				data.setPnum(rs.getInt("pnum"));
				data.setPname(rs.getString("pname"));
				data.setPimg(rs.getString("pimg"));
				data.setPprice(rs.getInt("pprice"));
				data.setPinfo(rs.getString("pinfo"));
				data.setPrental(rs.getString("prental"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}


	public void Product_update(ProductVO vo) { // 분기처리 질문?
		conn=JDBCUtil.connect();
		try {
			if(vo.getPrental().equals("대여중")) {
				pstmt=conn.prepareStatement(PRODUCT_UPDATE_2);

			}else if(vo.getPrental().equals("대여가능")) {
				pstmt=conn.prepareStatement(PRODUCT_UPDATE_1);

			}
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public void Product_delete(ProductVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(PRODUCT_DELETE);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}



}
