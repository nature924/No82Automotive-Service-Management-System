package com.dao;

import com.entity.QianzaikehuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QianzaikehuVO;
import com.entity.view.QianzaikehuView;


/**
 * 潜在客户
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface QianzaikehuDao extends BaseMapper<QianzaikehuEntity> {
	
	List<QianzaikehuVO> selectListVO(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
	
	QianzaikehuVO selectVO(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
	
	List<QianzaikehuView> selectListView(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);

	List<QianzaikehuView> selectListView(Pagination page,@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
	
	QianzaikehuView selectView(@Param("ew") Wrapper<QianzaikehuEntity> wrapper);
	

}
