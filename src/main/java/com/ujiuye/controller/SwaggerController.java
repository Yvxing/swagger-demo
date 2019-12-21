package com.ujiuye.controller;

import com.ujiuye.pojo.TbBrand;
import com.ujiuye.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value="品牌管理的controller")
public class SwaggerController {

    @Autowired
    private BrandService brandService;


    /**
     * 若method指定了访问的方式，要在网址中手动访问需要使用get
     * 不指定的话，会默认可以使用所有方式
     *
     * 查看生成的接口文档时访问这个路径   http://localhost:8081/swagger-ui.html
     *
     * 直接查看内容的返回值的时候直接访问request mapping路径  可以得到对应的值
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的品牌，用get请求",notes = "返回json格式，没有数据会返回[]")
    public List<TbBrand> getAll(){
        return brandService.findAll();
    }

    @RequestMapping("/getOne")
    @ApiOperation(value = "根据ID查询结果",notes = "例：输入  1 ")
    //下面指的是有多个参数需要的  加s说明是多个参数，单个就是不加s的,多个参数则写多个ApiImplicitParam，使用逗号分隔
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value = "品牌名称",required = true,dataType = "String")
    })
    public List<TbBrand> findOne(long id){
        return brandService.findOne(id);
    }

}
