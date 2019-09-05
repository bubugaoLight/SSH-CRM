package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	
	void saveUser(User u);
	User login(User u);
}
