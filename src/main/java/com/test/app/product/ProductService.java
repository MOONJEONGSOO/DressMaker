package com.test.app.product;

import java.util.List;

public interface ProductService {



	public void Product_insert(ProductVO vo);

	public ProductVO Product_selectOne(ProductVO vo);

	public void Product_update(ProductVO vo);

	public void Product_delete(ProductVO vo);
	
	
	public List<ProductVO> Product_selectAll(ProductVO vo);
	public int Product_selectAll_cnt(ProductVO vo);
	public List<ProductVO> Product_selectAll_page(ProductVO vo, int page);
	
	
	
	public List<ProductVO> Product_search(ProductVO vo);
	public int Product_search_cnt(ProductVO vo);
	public List<ProductVO> Product_search_page(ProductVO vo, int page);



}
