package cn.itcast.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;



public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	private UserService userService;
	
	public String regist() throws Exception {
		//调用Service保存注册用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//重定向到登陆页面
	return "toLogin";
	}
	
	public String login(){
				
		User u =null;
			try {
				 u = userService.login(user);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				ActionContext.getContext().put("error", e.getMessage());
				return "error";
			}
			ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}
	
	@Override
	public User getModel() {
		// TODO 自动生成的方法存根
		return user ;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
