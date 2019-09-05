package cn.itcast.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{

	private String dict_type_code; 
	private BaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		//获取数据字典typecode list对象
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//转换为json
		String json = JSONArray.fromObject(list).toString();
		//json发给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	

}
