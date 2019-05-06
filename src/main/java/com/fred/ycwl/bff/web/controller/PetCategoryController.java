package com.fred.ycwl.bff.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fred.ycwl.bff.web.client.pet.PetCategoryClient;
import com.fred.ycwl.bff.web.controller.request.PetCategoryListRequest;
import com.fred.ycwl.bff.web.controller.response.PetCategoryListView;
import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.common.web.Response;
import com.fred.ycwl.common.web.ResponseCode;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/30 15:12
 */
@RestController
@RequestMapping("/pet/category")
public class PetCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetCategoryController.class);

    @Autowired
    private PetCategoryClient petCategoryClient;

    @GetMapping("/list")
    public Response<List<PetCategoryListView>> list(
            @Validated PetCategoryListRequest request, BindingResult result)
            throws InvocationTargetException, IllegalAccessException {

        if (result.hasErrors()) {
            LOGGER.warn(result.getAllErrors().get(0).getDefaultMessage());
            throw new BusinessException(ResponseCode.ERROR_400);
        }
        Response<List<Map<String, Object>>> response = petCategoryClient.list(request.getType());
        List<PetCategoryListView> views = new ArrayList<>();
        if (response.isSuccess()) {
            List<Map<String, Object>> petCategories = response.getData();
            for (Map<String, Object> petCategory : petCategories) {
                PetCategoryListView view = new PetCategoryListView();
                BeanUtils.copyProperties(view, petCategory);
                views.add(view);
            }
        } else {
            throw new BusinessException(new ResponseCode(response.getCode(), response.getMessage()));
        }
        return Response.getSuccess(views);
    }
}
