package com.entity.vo;

import com.entity.QianzaikehuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 潜在客户
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public class QianzaikehuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 客户姓名
	 */
	
	private String kehuxingming;
		
	/**
	 * 客户电话
	 */
	
	private String kehudianhua;
		
	/**
	 * 客户年龄
	 */
	
	private Integer kehunianling;
		
	/**
	 * 意向车型
	 */
	
	private String yixiangchexing;
		
	/**
	 * 购车预算
	 */
	
	private String goucheyusuan;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 部门名称
	 */
	
	private String bumenmingcheng;
				
	
	/**
	 * 设置：客户姓名
	 */
	 
	public void setKehuxingming(String kehuxingming) {
		this.kehuxingming = kehuxingming;
	}
	
	/**
	 * 获取：客户姓名
	 */
	public String getKehuxingming() {
		return kehuxingming;
	}
				
	
	/**
	 * 设置：客户电话
	 */
	 
	public void setKehudianhua(String kehudianhua) {
		this.kehudianhua = kehudianhua;
	}
	
	/**
	 * 获取：客户电话
	 */
	public String getKehudianhua() {
		return kehudianhua;
	}
				
	
	/**
	 * 设置：客户年龄
	 */
	 
	public void setKehunianling(Integer kehunianling) {
		this.kehunianling = kehunianling;
	}
	
	/**
	 * 获取：客户年龄
	 */
	public Integer getKehunianling() {
		return kehunianling;
	}
				
	
	/**
	 * 设置：意向车型
	 */
	 
	public void setYixiangchexing(String yixiangchexing) {
		this.yixiangchexing = yixiangchexing;
	}
	
	/**
	 * 获取：意向车型
	 */
	public String getYixiangchexing() {
		return yixiangchexing;
	}
				
	
	/**
	 * 设置：购车预算
	 */
	 
	public void setGoucheyusuan(String goucheyusuan) {
		this.goucheyusuan = goucheyusuan;
	}
	
	/**
	 * 获取：购车预算
	 */
	public String getGoucheyusuan() {
		return goucheyusuan;
	}
				
	
	/**
	 * 设置：员工工号
	 */
	 
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：部门名称
	 */
	 
	public void setBumenmingcheng(String bumenmingcheng) {
		this.bumenmingcheng = bumenmingcheng;
	}
	
	/**
	 * 获取：部门名称
	 */
	public String getBumenmingcheng() {
		return bumenmingcheng;
	}
			
}
