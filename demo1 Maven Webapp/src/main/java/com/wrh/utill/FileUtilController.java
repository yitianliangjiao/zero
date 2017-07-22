package com.wrh.utill;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

import com.wrh.model.upload;

public class FileUtilController {
private static final int BUF_SIZE = 2 * 1024;  
	 
public static Boolean FileUpload(upload model,String path,InputStream in){
	Boolean result = true;
	try {
		//分片上传
		if(model.getChunk()!=null)
		{
			int chunk =  Integer.valueOf(model.getChunk());
			int chunks = Integer.valueOf(model.getChunks());
			File targetFile = new File(path);  
			Savefile(model, in, targetFile,  chunk == 0?false:true);
		}//未分片
		else {
			FileUtils.copyInputStreamToFile(in, new File(path));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result = false;
	}
	return result;
}
public static void Savefile(upload model,InputStream input,File targetFile,Boolean append) throws IOException{
	 OutputStream out = null;  
     try {  
         if (targetFile.exists() && append) {  
             out = new BufferedOutputStream(new FileOutputStream(targetFile, true), BUF_SIZE);  
         } else {  
             out = new BufferedOutputStream(new FileOutputStream(targetFile), BUF_SIZE);  
         }  
           
         byte[] buffer = new byte[BUF_SIZE];  
         int len = 0;  
         //写入文件  
         while ((len = input.read(buffer)) > 0) {  
             out.write(buffer, 0, len);  
         }  
     } catch (IOException e) {  
         throw e;  
     } finally {  
         //关闭输入输出流  
         if (null != input) {  
             try {  
                 input.close();  
             } catch (IOException e) {  
                 e.printStackTrace();  
             }  
         }  
         if (null != out) {  
             try {  
                 out.close();  
             } catch (IOException e) {  
                 e.printStackTrace();  
             }  
         }  
     }  
}

}
