package com.saas.titan.modules.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.modules.resource.dao.CommonResourceDao;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import com.saas.titan.modules.resource.service.CommonResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Slf4j
@Service("commonResourceService")
public class CommonResourceServiceImpl extends ServiceImpl<CommonResourceDao, CommonResourceEntity> implements CommonResourceService {

    @Autowired
    private CommonResourceDao commonResourceDao;

    @Override
    public void getPhoto(HttpServletResponse response, String resourceId) throws IOException {
        //查询读取文件
        QueryWrapper<CommonResourceEntity> query = new QueryWrapper<>();
        query.eq(TableField.CommonResource.IS_DELETED, Constant.STR_ZERO);
        query.eq(TableField.CommonResource.RESOURCE_ID, resourceId);
        CommonResourceEntity entity = commonResourceDao.selectOne(query);
        //拼接文件路径
        String basePath = entity.getFilePath() + resourceId + entity.getFileSuffix();
        InputStream in = getImgInputStream(basePath);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    /**
     * 获得图片流
     * @param basePath 图影地址
     * @return InputStream 输入流
     * @throws IOException io异常
     */
    private InputStream getImgInputStream(String basePath) throws IOException {
        return Files.newInputStream(new File(basePath).toPath());
    }
}
