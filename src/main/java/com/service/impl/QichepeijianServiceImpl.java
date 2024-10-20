package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QichepeijianDao;
import com.entity.QichepeijianEntity;
import com.service.QichepeijianService;
import com.entity.vo.QichepeijianVO;
import com.entity.view.QichepeijianView;

@Service("qichepeijianService")
public class QichepeijianServiceImpl extends ServiceImpl<QichepeijianDao, QichepeijianEntity> implements QichepeijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QichepeijianEntity> page = this.selectPage(
                new Query<QichepeijianEntity>(params).getPage(),
                new EntityWrapper<QichepeijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QichepeijianEntity> wrapper) {
		  Page<QichepeijianView> page =new Query<QichepeijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QichepeijianVO> selectListVO(Wrapper<QichepeijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QichepeijianVO selectVO(Wrapper<QichepeijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QichepeijianView> selectListView(Wrapper<QichepeijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QichepeijianView selectView(Wrapper<QichepeijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
