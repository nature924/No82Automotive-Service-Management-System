package com.dao;

import com.entity.QichepeijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QichepeijianVO;
import com.entity.view.QichepeijianView;


/**
 * 汽车配件
 * 
 * @author 
 * @email 
 * @date 2023-03-16 09:54:59
 */
public interface QichepeijianDao extends BaseMapper<QichepeijianEntity> {
	
	List<QichepeijianVO> selectListVO(@Param("ew") Wrapper<QichepeijianEntity> wrapper);
	
	QichepeijianVO selectVO(@Param("ew") Wrapper<QichepeijianEntity> wrapper);
	
	List<QichepeijianView> selectListView(@Param("ew") Wrapper<QichepeijianEntity> wrapper);

	List<QichepeijianView> selectListView(Pagination page,@Param("ew") Wrapper<QichepeijianEntity> wrapper);
	
	QichepeijianView selectView(@Param("ew") Wrapper<QichepeijianEntity> wrapper);
	

}
