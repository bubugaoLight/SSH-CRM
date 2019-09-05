package cn.itcast.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{

	private UserDao ud;

	@Override
	public void saveUser(User u) {
		// TODO 自动生成的方法存根
		  User exitU = ud.getByUserCode(u.getUser_code());
		  if (exitU!=null) {
			throw new RuntimeException("User 已存在");
		}
		  ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
	public User login(User u){
		 User user= ud.getByUserCode(u.getUser_code());
		 if (user==null) {
			throw new RuntimeException("密码错误");
		}
		// ud.getById(u.getUser_id());
		return user;
	}





}
