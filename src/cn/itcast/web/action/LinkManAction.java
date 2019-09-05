package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import antlr.collections.List;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.pageBean;
import freemarker.template.utility.StringUtil;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();
	
	private Integer currentPage;
	private Integer pageSize;
	
	private LinkManService lms;
	
	public String list(){
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			  dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
    	if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null) {
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		//调用service查询分页数据
		pageBean pb = lms.getPageBean( dc, currentPage, pageSize);
		//将pagebean 放入request域，转发到列表页面
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add(){
		lms.save(linkMan);
		
		return "tolist";
	}
	
	public String toEdit(){
		LinkMan lm =lms.getById(linkMan.getLkm_id());
		
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}
	
	@Override
	public LinkMan getModel() {
		// TODO 自动生成的方法存根
		return linkMan;
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
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
	

}
