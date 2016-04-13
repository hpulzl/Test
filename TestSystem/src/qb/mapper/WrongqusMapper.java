package qb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qb.entity.Wrongqus;
import qb.entity.WrongqusExample;

public interface WrongqusMapper {
    int countByExample(WrongqusExample example);

    int deleteByExample(WrongqusExample example);

    int deleteByPrimaryKey(String wqid);

    int insert(Wrongqus record);

    int insertSelective(Wrongqus record);

    List<Wrongqus> selectByExample(WrongqusExample example);

    Wrongqus selectByPrimaryKey(String wqid);

    int updateByExampleSelective(@Param("record") Wrongqus record, @Param("example") WrongqusExample example);

    int updateByExample(@Param("record") Wrongqus record, @Param("example") WrongqusExample example);

    int updateByPrimaryKeySelective(Wrongqus record);

    int updateByPrimaryKey(Wrongqus record);
}