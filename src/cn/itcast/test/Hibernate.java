/*package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Hibernate {

			@Resource(name="sessionFactory")
	private  SessionFactory sf;
	@Test
	public void fun1(){
			Configuration conf = new Configuration().configure();
			
			SessionFactory sf = conf.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			
			//-------------------------------------------
			User user= new User();
					user.setUser_code("lucy");
					user.setUser_name("Lucy");
					user.setUser_password("12345");
			session.save(user);
			//-------------------------------------------
			
			tx.commit();
			session.close();
			sf.close();
	}
	
	
	@Test
	public void fun2(){
	
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//-------------------------------------------
		User user= new User();
		user.setUser_code("rose");
		user.setUser_name("肉丝");
		user.setUser_password("12345");
		session.save(user);
		//-------------------------------------------
		
		tx.commit();
		session.close();
	
	}
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3(){
		
			User u = ud.getByUserCode("lucy");
			System.out.println(u);
	}
	
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun4(){
		
		User u = new User();
		u.setUser_code(" 夜机");
		u.setUser_name("ji");
		u.setUser_password("34114514");
		
		us.saveUser(u);
	}
}*/
