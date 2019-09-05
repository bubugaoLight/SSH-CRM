package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.pageBean;

public class LinkManServiceImpl implements LinkManService{

	private LinkManDao lmd;
	

	@Override
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用DAO查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		//创建pagebean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<LinkMan> list=lmd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//列表放入pagebean中
		pb.setList(list);
		return pb;
	}

	@Override
	public void save(LinkMan lm) {
		// TODO 自动生成的方法存根
		lmd.saveOrUpdate(lm);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public LinkMan getById(Long lkm_id) {
		return lmd.getById(lkm_id);
		
	}
	


}
