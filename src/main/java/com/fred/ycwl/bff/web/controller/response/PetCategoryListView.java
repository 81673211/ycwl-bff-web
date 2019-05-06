package com.fred.ycwl.bff.web.controller.response;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/30 15:35
 */
@Data
public class PetCategoryListView implements Serializable {
    private static final long serialVersionUID = -2454894422629434023L;

    private Long id;
    private String name;
    private String picUrl;
    private String descr;
    private Integer seq;
    private String type;
}
