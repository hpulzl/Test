package qb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qb.entity.Qusbank;
import qb.entity.QusbankExample;

public interface QusbankMapper {
    int countByExample(QusbankExample example);

    int deleteByExample(QusbankExample example);

    int deleteByPrimaryKey(String qusid);

    int insert(Qusbank record);

    int insertSelective(Qusbank record);

    List<Qusbank> selectByExampleWithBLOBs(QusbankExample example);

    List<Qusbank> selectByExample(QusbankExample example);

    Qusbank selectByPrimaryKey(String qusid);

    int updateByExampleSelective(@Param("record") Qusbank record, @Param("example") QusbankExample example);

    int updateByExampleWithBLOBs(@Param("record") Qusbank record, @Param("example") QusbankExample example);

    int updateByExample(@Param("record") Qusbank record, @Param("example") QusbankExample example);

    int updateByPrimaryKeySelective(Qusbank record);

    int updateByPrimaryKeyWithBLOBs(Qusbank record);

    int updateByPrimaryKey(Qusbank record);
}