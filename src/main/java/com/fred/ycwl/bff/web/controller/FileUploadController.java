package com.fred.ycwl.bff.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fred.ycwl.bff.web.client.FileUploadClient;
import com.fred.ycwl.bff.web.controller.response.FileUploadView;
import com.fred.ycwl.common.web.Response;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/5/6 14:07
 */
@RestController
@RequestMapping("/file/upload")
public class FileUploadController {

    @Autowired
    private FileUploadClient fileUploadClient;

    @PostMapping
    public Response<FileUploadView> upload(@RequestParam("image") MultipartFile file) {

        Response<Map<String, Object>> response = fileUploadClient.upload(file);
        FileUploadView view = new FileUploadView();
        view.setPath(response.getData().get("fileName").toString());
        return Response.getSuccess(view);
    }
}
