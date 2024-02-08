package com.saas.titan.modules.resource.dto;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/8
 */
@Data
public class CaseContentInfoDto {

    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 内容
     */
    private String content;

}
