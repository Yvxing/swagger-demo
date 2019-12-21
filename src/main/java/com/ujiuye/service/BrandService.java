package com.ujiuye.service;

import com.ujiuye.pojo.TbBrand;

import java.util.List;

public interface BrandService {

     List<TbBrand> findAll();


     List<TbBrand> findOne(long id);
}
