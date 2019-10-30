package com.edu.dao;

import com.edu.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_shipping
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_shipping
     *
     * @mbg.generated
     */
    int insert(Shipping record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_shipping
     *
     * @mbg.generated
     */
    Shipping selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_shipping
     *
     * @mbg.generated
     */
    List<Shipping> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_shipping
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Shipping record);
    /**
     * 通过用户ID和地址ID删除
     */
    int deleteByUserIdAndShippingId(@Param("userId")Integer userId,@Param("shippingId")Integer shippingId);
    /**
     * updateBySelectiveKey修改用户地址
     */
    int updateBySelectiveKey(Shipping shipping);
    /**
     * selectAllByUserId查询该用户的地址列表
     */
      List<Shipping> selectAllByUserId(Integer userId);


}