package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 汽车配件
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
@TableName("qichepeijian")
public class QichepeijianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QichepeijianEntity() {
		
	}
	
	public QichepeijianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 配件编号
	 */
					
	private String peijianbianhao;
	
	/**
	 * 配件名称
	 */
					
	private String peijianmingcheng;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 配件分类
	 */
					
	private String peijianfenlei;
	
	/**
	 * 型号
	 */
					
	private String xinghao;
	
	/**
	 * 适用品牌
	 */
					
	private String shiyongpinpai;
	
	/**
	 * 适用车系
	 */
					
	private String shiyongchexi;
	
	/**
	 * 配件价格
	 */
					
	private Integer peijianjiage;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 配件说明
	 */
					
	private String peijianshuoming;
	
	/**
	 * 配件详情
	 */
					
	private String peijianxiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：配件编号
	 */
	public void setPeijianbianhao(String peijianbianhao) {
		this.peijianbianhao = peijianbianhao;
	}
	/**
	 * 获取：配件编号
	 */
	public String getPeijianbianhao() {
		return peijianbianhao;
	}
	/**
	 * 设置：配件名称
	 */
	public void setPeijianmingcheng(String peijianmingcheng) {
		this.peijianmingcheng = peijianmingcheng;
	}
	/**
	 * 获取：配件名称
	 */
	public String getPeijianmingcheng() {
		return peijianmingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：配件分类
	 */
	public void setPeijianfenlei(String peijianfenlei) {
		this.peijianfenlei = peijianfenlei;
	}
	/**
	 * 获取：配件分类
	 */
	public String getPeijianfenlei() {
		return peijianfenlei;
	}
	/**
	 * 设置：型号
	 */
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	/**
	 * 获取：型号
	 */
	public String getXinghao() {
		return xinghao;
	}
	/**
	 * 设置：适用品牌
	 */
	public void setShiyongpinpai(String shiyongpinpai) {
		this.shiyongpinpai = shiyongpinpai;
	}
	/**
	 * 获取：适用品牌
	 */
	public String getShiyongpinpai() {
		return shiyongpinpai;
	}
	/**
	 * 设置：适用车系
	 */
	public void setShiyongchexi(String shiyongchexi) {
		this.shiyongchexi = shiyongchexi;
	}
	/**
	 * 获取：适用车系
	 */
	public String getShiyongchexi() {
		return shiyongchexi;
	}
	/**
	 * 设置：配件价格
	 */
	public void setPeijianjiage(Integer peijianjiage) {
		this.peijianjiage = peijianjiage;
	}
	/**
	 * 获取：配件价格
	 */
	public Integer getPeijianjiage() {
		return peijianjiage;
	}
	/**
	 * 设置：数量
	 */
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
	/**
	 * 设置：配件说明
	 */
	public void setPeijianshuoming(String peijianshuoming) {
		this.peijianshuoming = peijianshuoming;
	}
	/**
	 * 获取：配件说明
	 */
	public String getPeijianshuoming() {
		return peijianshuoming;
	}
	/**
	 * 设置：配件详情
	 */
	public void setPeijianxiangqing(String peijianxiangqing) {
		this.peijianxiangqing = peijianxiangqing;
	}
	/**
	 * 获取：配件详情
	 */
	public String getPeijianxiangqing() {
		return peijianxiangqing;
	}

}
