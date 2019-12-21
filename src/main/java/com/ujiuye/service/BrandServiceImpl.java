package com.ujiuye.service;

import com.ujiuye.dao.TbBrandMapper;
import com.ujiuye.pojo.TbBrand;
import com.ujiuye.pojo.TbBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private TbBrandMapper tbBrandMapper;


    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public List<TbBrand> findOne(long id) {
        TbBrandExample tbBrandExample = new TbBrandExample();
        tbBrandExample.createCriteria().andIdEqualTo(id);
        List<TbBrand> list = tbBrandMapper.selectByExample(tbBrandExample);
        return list;
    }
}
