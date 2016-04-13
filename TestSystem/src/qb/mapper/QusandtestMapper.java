package qb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qb.entity.Qusandtest;
import qb.entity.QusandtestExample;

public interface QusandtestMapper {
    int countByExample(QusandtestExample example);

    int deleteByExample(QusandtestExample example);

    int deleteByPrimaryKey(String qtid);

    int insert(Qusandtest record);

    int insertSelective(Qusandtest record);

    List<Qusandtest> selectByExample(QusandtestExample example);

    Qusandtest selectByPrimaryKey(String qtid);

    int updateByExampleSelective(@Param("record") Qusandtest record, @Param("example") QusandtestExample example);

    int updateByExample(@Param("record") Qusandtest record, @Param("example") QusandtestExample example);

    int updateByPrimaryKeySelective(Qusandtest record);

    int updateByPrimaryKey(Qusandtest record);
    List<String> selectByTestid(String testid);
}