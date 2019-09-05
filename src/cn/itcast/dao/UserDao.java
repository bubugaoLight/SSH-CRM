package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao extends BaseDao<User> {

	public User getByUserCode(final String usercode);

	public User getPassword(String pwd);

}
