package com.saas.titan.modules.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.modules.resource.dao.CaseContentDao;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.entity.CaseContentEntity;
import com.saas.titan.modules.resource.service.CaseContentService;
import com.saas.titan.modules.resource.vo.CaseContentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("caseContentService")
public class CaseContentServiceImpl extends ServiceImpl<CaseContentDao, CaseContentEntity> implements CaseContentService {

    @Autowired
    private CaseContentDao caseContentDao;

    @Override
    public List<CaseContentDto> page() {
        //构筑条件
        QueryWrapper<CaseContentEntity> query = new QueryWrapper<>();
        query.eq(TableField.CommonResource.IS_DELETED, Constant.STR_ZERO);
        return caseContentDao.getPage(query);
    }
}
