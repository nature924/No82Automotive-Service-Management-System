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


import com.dao.GangweixinxiDao;
import com.entity.GangweixinxiEntity;
import com.service.GangweixinxiService;
import com.entity.vo.GangweixinxiVO;
import com.entity.view.GangweixinxiView;

@Service("gangweixinxiService")
public class GangweixinxiServiceImpl extends ServiceImpl<GangweixinxiDao, GangweixinxiEntity> implements GangweixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweixinxiEntity> page = this.selectPage(
                new Query<GangweixinxiEntity>(params).getPage(),
                new EntityWrapper<GangweixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweixinxiEntity> wrapper) {
		  Page<GangweixinxiView> page =new Query<GangweixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweixinxiVO> selectListVO(Wrapper<GangweixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweixinxiVO selectVO(Wrapper<GangweixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweixinxiView> selectListView(Wrapper<GangweixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweixinxiView selectView(Wrapper<GangweixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
