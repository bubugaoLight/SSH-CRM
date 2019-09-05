package cn.itcast.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO 自动生成的方法存根
			//获得session
			Map<String, Object> session = ActionContext.getContext().getSession();
			//获得登录表示
			User user = (User) session.get("user");
			//判断标识
			if (user !=null) {
				return invocation.invoke();
			}else {
				return "toLogin";
			}		

	}

}
