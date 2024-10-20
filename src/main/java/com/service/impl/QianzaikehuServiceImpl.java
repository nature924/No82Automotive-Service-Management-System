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


import com.dao.QianzaikehuDao;
import com.entity.QianzaikehuEntity;
import com.service.QianzaikehuService;
import com.entity.vo.QianzaikehuVO;
import com.entity.view.QianzaikehuView;

@Service("qianzaikehuService")
public class QianzaikehuServiceImpl extends ServiceImpl<QianzaikehuDao, QianzaikehuEntity> implements QianzaikehuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QianzaikehuEntity> page = this.selectPage(
                new Query<QianzaikehuEntity>(params).getPage(),
                new EntityWrapper<QianzaikehuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QianzaikehuEntity> wrapper) {
		  Page<QianzaikehuView> page =new Query<QianzaikehuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QianzaikehuVO> selectListVO(Wrapper<QianzaikehuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QianzaikehuVO selectVO(Wrapper<QianzaikehuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QianzaikehuView> selectListView(Wrapper<QianzaikehuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QianzaikehuView selectView(Wrapper<QianzaikehuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
