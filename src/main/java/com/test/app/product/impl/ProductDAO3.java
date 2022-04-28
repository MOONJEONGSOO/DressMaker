package com.test.app.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.product.ProductVO;
@Repository("productDAO")
public class ProductDAO3 {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public List<ProductVO> Product_selectAll(ProductVO vo) {
		return mybatis.selectList("ProductDAO.Product_selectAll", vo);
	}
	public int Product_selectAll_cnt(ProductVO vo) {
		vo = mybatis.selectOne("ProductDAO.Product_selectAll_cnt", vo);
		return vo.getListcnt();
	}
	public List<ProductVO> Product_selectAll_page(ProductVO vo, int page) {
		vo.setPage(page);
		System.out.println("page"+page);
		return mybatis.selectList("ProductDAO.Product_selectAll_page", vo);
	}
	
	
	public List<ProductVO> Product_search(ProductVO vo) {
		return mybatis.selectList("ProductDAO.Product_search", vo);
	}
	public int Product_search_cnt(ProductVO vo) {
		vo = mybatis.selectOne("ProductDAO.Product_search_cnt", vo);
		return vo.getListcnt();
	}
	public List<ProductVO> Product_search_page(ProductVO vo, int page) {
		vo.setPage(page);
		System.out.println("searchpage"+page);
		return mybatis.selectList("ProductDAO.Product_search_page", vo);
	}
	


	public void Product_insert(ProductVO vo) {

		mybatis.insert("ProductDAO.Product_insert", vo);
	}

	public ProductVO Product_selectOne(ProductVO vo) {

		
		return (ProductVO)mybatis.selectOne("ProductDAO.Product_selectOne", vo);

	}


	public void Product_update(ProductVO vo) { // 분기처리 질문?
		System.out.println("상품 로그" + vo);

		mybatis.update("ProductDAO.Product_update", vo);

	}

	public void Product_delete(ProductVO vo) {
		mybatis.delete("ProductDAO.Product_delete", vo);

	}


}
