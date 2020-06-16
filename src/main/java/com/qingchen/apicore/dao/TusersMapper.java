package com.qingchen.apicore.dao;

import com.qingchen.apicore.model.Tusers;
import com.qingchen.apicore.model.TusersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TusersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    long countByExample(TusersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int deleteByExample(TusersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int insert(Tusers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int insertSelective(Tusers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    List<Tusers> selectByExample(TusersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    Tusers selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Tusers record, @Param("example") TusersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Tusers record, @Param("example") TusersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Tusers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Tusers record);

    List<Tusers> selectAll();
}