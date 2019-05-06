package com.fred.ycwl.bff.web.controller.response;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/6 14:08
 */
@Data
public class FileUploadView implements Serializable {
    private static final long serialVersionUID = 6120070093965936388L;

    private String path;
}
