package wx.mapper;

import wx.entity.Address;

import java.util.List;

/**
 * @author wangxun
 * @title: IUserMappper
 * @projectName mybatis-demo2020424
 * @version: 1.0.0
 * @description: TODO
 * @date 2020/4/27 11:53 上午
 */
public interface IAddressMapper {

    /**
     * 得到所有的
     * @return
     */
    List<Address> findAll();
}
