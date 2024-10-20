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


import com.dao.PeijianfenleiDao;
import com.entity.PeijianfenleiEntity;
import com.service.PeijianfenleiService;
import com.entity.vo.PeijianfenleiVO;
import com.entity.view.PeijianfenleiView;

@Service("peijianfenleiService")
public class PeijianfenleiServiceImpl extends ServiceImpl<PeijianfenleiDao, PeijianfenleiEntity> implements PeijianfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijianfenleiEntity> page = this.selectPage(
                new Query<PeijianfenleiEntity>(params).getPage(),
                new EntityWrapper<PeijianfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijianfenleiEntity> wrapper) {
		  Page<PeijianfenleiView> page =new Query<PeijianfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeijianfenleiVO> selectListVO(Wrapper<PeijianfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijianfenleiVO selectVO(Wrapper<PeijianfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijianfenleiView> selectListView(Wrapper<PeijianfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijianfenleiView selectView(Wrapper<PeijianfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
