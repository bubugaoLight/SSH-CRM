//ajax加载数据字典 生成select
			//数据字典类型（dict_type_code）
			//将下拉选项 放入标签id
			//生成下拉选项 select标签name属性
			//需要回显 选中option
			function loadSelect(typecode,positionId,selectname,selectedId){
				//生成select对象
				var $select = $("<select name="+selectname+"></select>");
				//添加option name
				$select.append("$(<option value=''>--请选择--</option>");
				//AJAX 访问后台Action
				$.post("${pageContext.request.contextPath}/BaseDictAction", {dict_type_code:typecode},
						function(data){
								$.each( data, function(i, json){
									var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
									$select.append($option);
							if(json['dict_id']==selectedId){
								$option.attr("selected","selected");
							}
						});
							},"json");
				//回显positionID
				$("#"+positionId).append($select);				
				//测试
			
			}