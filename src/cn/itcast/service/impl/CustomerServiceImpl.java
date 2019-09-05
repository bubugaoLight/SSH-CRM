package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.pageBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	@Override
	public pageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用DAO查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//创建pagebean对象
		pageBean pb = new pageBean(currentPage, totalCount, pageSize);
		//调用DAO查询分页数据
		List<Customer> list=cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//列表放入pagebean中
		pb.setList(list);
		return pb;
	}
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public void save(Customer customer) {
		// TODO 自动生成的方法存根
		cd.saveOrUpdate(customer);
	}

	@Override
	public void delete(Long cust_id) {
		// TODO 自动生成的方法存根
		cd.delete(cust_id);
	}
	@Override
	public void delete(Customer customer) {
		// TODO 自动生成的方法存根
		cd.delete(customer);
	}

	@Override
	public Customer getById(Long cust_id) {
		// TODO 自动生成的方法存根
		return cd.getById(cust_id);
	}



}
