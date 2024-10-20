package com.entity.view;

import com.entity.PeijiandingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 配件订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
@TableName("peijiandingdan")
public class PeijiandingdanView  extends PeijiandingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeijiandingdanView(){
	}
 
 	public PeijiandingdanView(PeijiandingdanEntity peijiandingdanEntity){
 	try {
			BeanUtils.copyProperties(this, peijiandingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
