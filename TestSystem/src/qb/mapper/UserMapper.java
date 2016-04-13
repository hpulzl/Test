package qb.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import qb.entity.User;
import qb.entity.UserExample;

public interface UserMapper {
	User selectById(String key);
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    int updateUser(User user);
}