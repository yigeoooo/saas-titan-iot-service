package com.saas.titan.modules.resource.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.dto.CaseContentInfoDto;
import com.saas.titan.modules.resource.service.CaseContentService;
import com.saas.titan.modules.resource.vo.CaseContentAddVo;
import com.saas.titan.modules.resource.vo.CaseContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 案件内容表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:49
 */
@RestController
@RequestMapping("/case-content")
public class CaseContentController {

    @Autowired
    private CaseContentService caseContentService;

    /**
     * 分页条件查询
     * @return 统一返回值
     */
    @GetMapping("/page")
    public ResultInfo<List<CaseContentDto>> page() {
        return ResultInfo.build(caseContentService.page());
    }

    /**
     * 查询详情
     * @param resourceId 资源id
     * @return 统一返回值
     */
    @GetMapping("/info/{resourceId}")
    public ResultInfo<CaseContentInfoDto> geInfo(@PathVariable("resourceId") String resourceId) {
        return ResultInfo.build(caseContentService.getInfo(resourceId));
    }
}
