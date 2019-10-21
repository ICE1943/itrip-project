package com.itrip.dao.mapper.itripUserLinkUser;
import com.itrip.beans.pojo.ItripUserLinkUser;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripUserLinkUserMapper {

	public ItripUserLinkUser getItripUserLinkUserById(@Param(value = "id") Long id)throws Exception;

	public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripUserLinkUserCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

	public Integer updateItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

	public Integer deleteItripUserLinkUserById(@Param(value = "id") Long id)throws Exception;

	List <Integer> validationOrderStatus(@Param(value = "id")Integer id)throws Exception;

}
