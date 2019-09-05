package cn.itcast.web.action;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;

import cn.itcast.utils.pageBean;


public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	private CustomerService cs;

	private File photo;
	
	private Integer currentPage;
	private Integer pageSize;

	public String list(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNoneBlank(customer.getCust_name())) {
			  dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		//调用service查询分页数据
		pageBean pb = cs.getPageBean( dc, currentPage, pageSize);
		//将pagebean 放入request域，转发到列表页面
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	public String add( ) throws Exception{
		
		if (photo!=null) {
			photo.renameTo(new File("E:/upload/2.jpg"));
		}
		//-----------------
		cs.save(customer);
		return "tolist";
	}
	
	public String delete(){
		cs.delete(customer.getCust_id());
		return "tolist";
	}
	public String toEdit(){
		Customer c=cs.getById(customer.getCust_id());
		
		ActionContext.getContext().put("customer", c);
		
		return "edit";
	}


	@Override
	public Customer getModel() {
		// TODO 自动生成的方法存根
		return customer;
	}
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	

	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	
}
