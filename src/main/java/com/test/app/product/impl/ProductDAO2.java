package com.test.app.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.product.ProductVO;
//@Repository("productDAO")
public class ProductDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String PRODUCT_INSERT="insert into product values((select nvl(max(pnum),0)+1 from product),?,?,?,?,'대여가능')";
	private final String PRODUCT_SELECTONE="select * from product where pnum=?";
	private final String PRODUCT_UPDATE_1="update product set prental='대여중' where pnum=?";
	private final String PRODUCT_UPDATE_2="update product set prental='대여가능' where pnum=?";
	private final String PRODUCT_DELETE="delete product where pnum=?";
	
	private final String PRODUCT_SELECTALL="select * from product order by pnum desc";
	private final String PRODUCT_SELECTALL_CNT="select count(*) as listcnt from product";
	private final String PRODUCT_SELECTALL_PAGE="select * from ( select rownum as rnum, A.pnum, A.pname, A.pimg, A.pprice, A.pinfo, A.prental from (select * from PRODUCT order by pnum desc) A) where rnum between ? and ?";

	private final String PRODUCT_SEARCH="select * from product where pname like '%'||?||'%' and pprice BETWEEN ? AND ? order by pnum desc"; // 이름으로 검색 and 금액으로 검색
	private final String PRODUCT_SEARCH_CNT="select count(*) as listcnt from product where pname like '%'||?||'%' and pprice BETWEEN ? AND ? order by pnum desc"; // 이름으로 검색 and 금액으로 검색 갯수
	private final String PRODUCT_SEARCHL_PAGE="select * from ( select rownum as rnum, A.pnum, A.pname, A.pimg, A.pprice, A.pinfo, A.prental from (select * from PRODUCT where pname like '%'||?||'%' and pprice BETWEEN ? AND ? order by pnum desc) A) where rnum between ? and ?"; // 검색 페이징

	
	public List<ProductVO> Product_selectAll(ProductVO vo) {
		return jdbcTemplate.query(PRODUCT_SELECTALL, new ProductRowMapper());
	}
	public int Product_selectAll_cnt(ProductVO vo) {
		return jdbcTemplate.queryForObject(PRODUCT_SELECTALL_CNT, Integer.class);
	}
	
	public List<ProductVO> Product_selectAll_page(ProductVO vo, int page) {
		Object[] args= {(page*6)-5, page*6};
		return jdbcTemplate.query(PRODUCT_SELECTALL_PAGE, args, new ProductRowMapper());
	}
	public List<ProductVO> Product_search(ProductVO vo) {
		Object[] args= {vo.getPsearch(), vo.getPprice(), vo.getPmax()};
		return jdbcTemplate.query(PRODUCT_SEARCH, args, new ProductRowMapper());
	}
	public int Product_search_cnt(ProductVO vo) {
		Object[] args= {vo.getPsearch(), vo.getPprice(), vo.getPmax()};
		return jdbcTemplate.queryForObject(PRODUCT_SEARCH_CNT, args, Integer.class);
	}

	public List<ProductVO> Product_search_page(ProductVO vo, int page) {
		Object[] args= {vo.getPsearch(), vo.getPprice(), vo.getPmax(),(page*6)-5, page*6};
		return jdbcTemplate.query(PRODUCT_SEARCHL_PAGE, args, new ProductRowMapper());
	}
	


	public void Product_insert(ProductVO vo) {

		jdbcTemplate.update(PRODUCT_INSERT, vo.getPname(), vo.getPimg(), vo.getPprice(), vo.getPinfo());

	}

	public ProductVO Product_selectOne(ProductVO vo) {

		Object[] args= {vo.getPnum()};
		return jdbcTemplate.queryForObject(PRODUCT_SELECTONE, args, new ProductRowMapper());

	}


	public void Product_update(ProductVO vo) { // 분기처리 질문?

		if(vo.getPrental().equals("대여중")) {
			jdbcTemplate.update(PRODUCT_UPDATE_2, vo.getPnum());


		}else if(vo.getPrental().equals("대여가능")) {
			jdbcTemplate.update(PRODUCT_UPDATE_1, vo.getPnum());

		}

	}

	public void Product_delete(ProductVO vo) {
		jdbcTemplate.update(PRODUCT_DELETE, vo.getPnum());

	}


}
class ProductRowMapper implements RowMapper<ProductVO>{

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductVO data=new ProductVO();

		data.setPnum(rs.getInt("pnum"));
		data.setPname(rs.getString("pname"));
		data.setPimg(rs.getString("pimg"));
		data.setPprice(rs.getInt("pprice"));
		data.setPinfo(rs.getString("pinfo"));
		data.setPrental(rs.getString("prental"));


		return data;
	}

}
