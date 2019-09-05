package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;
import cn.itcast.utils.pageBean;

public interface LinkManService {

	void save(LinkMan lm);
	
	  pageBean getPageBean( DetachedCriteria dc,Integer currentPage,Integer pageSize);

	LinkMan getById(Long lkm_id);
}
