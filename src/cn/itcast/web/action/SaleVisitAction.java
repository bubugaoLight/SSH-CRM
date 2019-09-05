package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.LinkMan;
import cn.itcast.domain.SaleVisit;
import cn.itcast.domain.User;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.pageBean;



public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	private SaleVisit sVisit = new SaleVisit();
	private SaleVisitService svs;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String add(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		sVisit.setUser(user);
		svs.save(sVisit);
		return "add";
	}
	
	public String list(){
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
/*		if (StringUtils.isNotBlank(sVisit.getVisit_interviewee())) {
			  dc.add(Restrictions.like("visit_interviewee", "%"+sVisit.getVisit_interviewee()+"%"));
		}
    	if(sVisit.getCustomer()!=null&&sVisit.getCustomer().getCust_id()!=null) {
			dc.add(Restrictions.eq("visit_cust_id", sVisit.getCustomer().getCust_id()));
		}*/
		//调用service查询分页数据
		pageBean pb = svs.getPageBean( dc, currentPage, pageSize);
		//将pagebean 放入request域，转发到列表页面
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
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

	@Override
	public SaleVisit getModel() {
		// TODO 自动生成的方法存根
		return sVisit;
	}
	


}
