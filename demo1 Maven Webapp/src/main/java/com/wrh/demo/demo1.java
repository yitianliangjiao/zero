/**  
* @Title: demo1.java
* @Package com.wrh.demo
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ���ٺ�  
* @date 2017��6��29�� ����2:25:29
* @version V1.0  
*/
package com.wrh.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import com.wrh.model.*;
import com.wrh.utill.FileUtilController;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @ClassName: demo1
 * @Description: TODO(������һ�仰��������������)
 * @author ���ٺ�
 * @date 2017��6��29�� ����2:25:29
 *
 */
@Controller
public class demo1 {
@RequestMapping("/hello")
public String test() {

    return "jsps/plupload";
}
@RequestMapping("/test")
public String test1() {

    return "jsps/test";
}
@ResponseBody
@RequestMapping("/fileupload.json")
public JSONObject upload(HttpServletRequest request,upload upload) throws IOException {
	JSONObject obj = new JSONObject();
	if(FileUtilController.FileUpload(upload,request))
	{
		obj.put("0", "上传成功");
	}
	else {
		obj.put("3", "上传失败");
	}
    return obj;
}
@ResponseBody
@RequestMapping("/PostMd5.json")
public JSONObject Md5(HttpServletRequest request,upload upload) throws IOException {
	JSONObject obj = new JSONObject();
	if(FileUtilController.Mergefile(upload, request))
	{
		obj.put("result", true);
	}else {
		obj.put("result", false);
	}
	
    return obj;
}
}
