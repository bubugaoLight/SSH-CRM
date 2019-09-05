package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.SaleVisitDao;

import cn.itcast.domain.SaleVisit;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.pageBean;

public class SaleVisitServiceImpl implements SaleVisitService{
	
	private SaleVisitDao svd;
	
	@Override
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用DAO查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		//创建pagebean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<SaleVisit> list=svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//列表放入pagebean中
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(SaleVisit sVisit) {
		// TODO 自动生成的方法存根
		svd.save(sVisit);
	}

	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}
	
	

}
