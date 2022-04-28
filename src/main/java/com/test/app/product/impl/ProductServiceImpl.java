package com.test.app.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.product.ProductService;
import com.test.app.product.ProductVO;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO3 productdao;



	@Override
	public void Product_insert(ProductVO vo) {
		productdao.Product_insert(vo);
	}

	@Override
	public ProductVO Product_selectOne(ProductVO vo) {
		return productdao.Product_selectOne(vo);
	}

	@Override
	public void Product_update(ProductVO vo) {
		productdao.Product_update(vo);
	}

	@Override
	public void Product_delete(ProductVO vo) {
		productdao.Product_delete(vo);
	}
	
	@Override
	public List<ProductVO> Product_selectAll(ProductVO vo) {
		return productdao.Product_selectAll(vo);
	}
	@Override
	public int Product_selectAll_cnt(ProductVO vo) {
		return productdao.Product_selectAll_cnt(vo);
	}
	@Override
	public List<ProductVO> Product_selectAll_page(ProductVO vo, int page) {
		return productdao.Product_selectAll_page(vo, page);
	}

	@Override
	public List<ProductVO> Product_search(ProductVO vo) {
		return productdao.Product_search(vo);
	}
	@Override
	public int Product_search_cnt(ProductVO vo) {
		return productdao.Product_search_cnt(vo);
	}
	@Override
	public List<ProductVO> Product_search_page(ProductVO vo, int page) {
		return productdao.Product_search_page(vo, page);
	}

}
