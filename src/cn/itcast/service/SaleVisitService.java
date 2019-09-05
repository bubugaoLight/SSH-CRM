package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.SaleVisit;
import cn.itcast.utils.pageBean;

public interface SaleVisitService {
	
	void save(SaleVisit sVisit);

	pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);



}
