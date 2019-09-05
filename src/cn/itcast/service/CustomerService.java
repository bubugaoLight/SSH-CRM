package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.utils.pageBean;

public interface CustomerService {
	
  pageBean getPageBean( DetachedCriteria dc,Integer currentPage,Integer pageSize);

   void save(Customer customer);

   void delete(Customer customer);

   Customer getById(Long cust_id);

   void delete(Long cust_id);


}
