package com.saas.titan.modules.resource.controller;


import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.resource.service.CommonResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
@Slf4j
@RestController
@RequestMapping("/common-resource")
public class CommonResourceController {

    @Autowired
    private CommonResourceService commonResourceService;

    /**
     * 获取图片流
     * @param resourceId 资源ID
     * @param response HttpServletResponse
     */
    @GetMapping("/{resourceId}")
    public void getPhoto(@PathVariable("resourceId") String resourceId, HttpServletResponse response) {
        try {
            commonResourceService.getPhoto(response, resourceId);
            log.info("成功资源ID为{}的图片流！", resourceId);
        } catch (IOException e) {
            log.error("获取图片流错误！");
        }
    }

}
