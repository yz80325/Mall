package com.yzh.common.to;

import lombok.Data;

/**
 * 返回Attr的接收值
 * */
@Data
public class AttrResponseVo extends AttrVo{


    private String catelogName;

    private String groupName;

    //[1.13.25]
    private Long[] catelogPath;

}
