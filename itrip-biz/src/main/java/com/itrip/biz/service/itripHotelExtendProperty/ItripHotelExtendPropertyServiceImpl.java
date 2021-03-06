package com.itrip.biz.service.itripHotelExtendProperty;

import com.itrip.utils.common.Constants;
import com.itrip.utils.common.EmptyUtils;
import com.itrip.utils.common.Page;
import com.itrip.dao.mapper.itripHotelExtendProperty.ItripHotelExtendPropertyMapper;
import com.itrip.beans.pojo.ItripHotelExtendProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = RuntimeException.class)

public class ItripHotelExtendPropertyServiceImpl implements ItripHotelExtendPropertyService {

    @Resource
    private ItripHotelExtendPropertyMapper itripHotelExtendPropertyMapper;

    @Override

    public ItripHotelExtendProperty getItripHotelExtendPropertyById(Long id) throws Exception {
        return itripHotelExtendPropertyMapper.getItripHotelExtendPropertyById(id);
    }

    @Override

    public List<ItripHotelExtendProperty> getItripHotelExtendPropertyListByMap(Map<String, Object> param) throws Exception {
        return itripHotelExtendPropertyMapper.getItripHotelExtendPropertyListByMap(param);
    }

    @Override

    public Integer getItripHotelExtendPropertyCountByMap(Map<String, Object> param) throws Exception {
        return itripHotelExtendPropertyMapper.getItripHotelExtendPropertyCountByMap(param);
    }

    @Override

    public Integer itriptxAddItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty) throws Exception {
        itripHotelExtendProperty.setCreationDate(new Date());
        return itripHotelExtendPropertyMapper.insertItripHotelExtendProperty(itripHotelExtendProperty);
    }

    @Override

    public Integer itriptxModifyItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty) throws Exception {
        itripHotelExtendProperty.setModifyDate(new Date());
        return itripHotelExtendPropertyMapper.updateItripHotelExtendProperty(itripHotelExtendProperty);
    }

    @Override

    public Integer itriptxDeleteItripHotelExtendPropertyById(Long id) throws Exception {
        return itripHotelExtendPropertyMapper.deleteItripHotelExtendPropertyById(id);
    }

    @Override

    public Page<ItripHotelExtendProperty> queryItripHotelExtendPropertyPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) throws Exception {
        Integer total = itripHotelExtendPropertyMapper.getItripHotelExtendPropertyCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripHotelExtendProperty> itripHotelExtendPropertyList = itripHotelExtendPropertyMapper.getItripHotelExtendPropertyListByMap(param);
        page.setRows(itripHotelExtendPropertyList);
        return page;
    }

}
