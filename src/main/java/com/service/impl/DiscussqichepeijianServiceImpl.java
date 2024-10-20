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


import com.dao.DiscussqichepeijianDao;
import com.entity.DiscussqichepeijianEntity;
import com.service.DiscussqichepeijianService;
import com.entity.vo.DiscussqichepeijianVO;
import com.entity.view.DiscussqichepeijianView;

@Service("discussqichepeijianService")
public class DiscussqichepeijianServiceImpl extends ServiceImpl<DiscussqichepeijianDao, DiscussqichepeijianEntity> implements DiscussqichepeijianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqichepeijianEntity> page = this.selectPage(
                new Query<DiscussqichepeijianEntity>(params).getPage(),
                new EntityWrapper<DiscussqichepeijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqichepeijianEntity> wrapper) {
		  Page<DiscussqichepeijianView> page =new Query<DiscussqichepeijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqichepeijianVO> selectListVO(Wrapper<DiscussqichepeijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqichepeijianVO selectVO(Wrapper<DiscussqichepeijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqichepeijianView> selectListView(Wrapper<DiscussqichepeijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqichepeijianView selectView(Wrapper<DiscussqichepeijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
