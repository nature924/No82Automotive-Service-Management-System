package com.entity.view;

import com.entity.DiscussqichepeijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 汽车配件评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-16 09:55:00
 */
@TableName("discussqichepeijian")
public class DiscussqichepeijianView  extends DiscussqichepeijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqichepeijianView(){
	}
 
 	public DiscussqichepeijianView(DiscussqichepeijianEntity discussqichepeijianEntity){
 	try {
			BeanUtils.copyProperties(this, discussqichepeijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
