package com.fred.ycwl.bff.web.controller.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/30 15:25
 */
@Data
public class PetCategoryListRequest implements Serializable {

    private static final long serialVersionUID = 3496156766459640874L;
    @NotBlank(message = "类型不能为空")
    private String type;

}
