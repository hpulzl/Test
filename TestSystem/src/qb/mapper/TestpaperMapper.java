package qb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qb.entity.Testpaper;
import qb.entity.TestpaperExample;

public interface TestpaperMapper {
    int countByExample(TestpaperExample example);

    int deleteByExample(TestpaperExample example);

    int deleteByPrimaryKey(String testid);

    int insert(Testpaper record);

    int insertSelective(Testpaper record);

    List<Testpaper> selectByExample(TestpaperExample example);

    Testpaper selectByPrimaryKey(String testid);

    int updateByExampleSelective(@Param("record") Testpaper record, @Param("example") TestpaperExample example);

    int updateByExample(@Param("record") Testpaper record, @Param("example") TestpaperExample example);

    int updateByPrimaryKeySelective(Testpaper record);

    int updateByPrimaryKey(Testpaper record);
}