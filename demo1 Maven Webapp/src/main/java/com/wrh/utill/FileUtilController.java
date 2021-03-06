package com.wrh.utill;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wrh.demo.filedemo;
import com.wrh.model.upload;

public class FileUtilController {
private static final int BUF_SIZE = 2 * 1024;  
	 
public static Boolean FileUpload(upload model,HttpServletRequest request){
	Boolean result = true;
	try {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multiRequest.getFile("file");
		InputStream in = file.getInputStream();
		
		Calendar date = Calendar.getInstance();
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println(path);
		//获取文件后缀名
		String filename = model.getName();
		String[] split = filename.split("\\.");
		String extendfile  = split[split.length-1].toLowerCase();
		//分片上传
		if(model.getChunk()!=null)
		{
			path += File.separator+"upload"+File.separator+model.getGuid()+File.separator+model.getChunk()+File.separator+model.getName();
			//int chunk =  Integer.valueOf(model.getChunk());
			//File targetFile = new File(path);  
			//Savefile(model, in, targetFile,  chunk == 0?false:true);
		}//未分片
		else {
			path += File.separator+"upload"+File.separator+date.get(Calendar.YEAR)+File.separator+(date.get(Calendar.MONTH)+1);
			//设定以guid得文件名称
			String guid = model.getGuid();
			path += File.separator+guid+"."+extendfile;
		}
		FileUtils.copyInputStreamToFile(in, new File(path));
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
public static Boolean Mergefile(upload upload,HttpServletRequest request) throws IOException{
	 Boolean result = false;
	 OutputStream out = null;
	 InputStream in = null;
	 String filename = upload.getName();
		String[] split = filename.split("\\.");
		String extendfile  = split[split.length-1].toLowerCase();
	String path = request.getSession().getServletContext().getRealPath("/");
	Calendar date = Calendar.getInstance();
	String filepath = path + File.separator+"upload"+File.separator+date.get(Calendar.YEAR)+File.separator+(date.get(Calendar.MONTH)+1);
	 File file = new File(filepath);
	 if(!file.exists())
	 {
		 file.mkdirs();
	 }
	 file = new File(filepath+File.separator+upload.getGuid()+"."+extendfile);
		for(int i=0;;i++)
		{
			path = request.getSession().getServletContext().getRealPath("/")+
					File.separator+"upload"+File.separator+upload.getGuid()+File.separator+i+File.separator+upload.getName();
			try {
			File targetFile = new File (path);
			if(targetFile.exists())
			{
				in = new FileInputStream(targetFile);
				if (file.exists()) {  
					 out = new BufferedOutputStream(new FileOutputStream(file, true), BUF_SIZE);  
	            } else {  
	            	 out = new BufferedOutputStream(new FileOutputStream(file),BUF_SIZE);  
	            }  					
					byte[] buffer = new byte[BUF_SIZE];  
		            int len = 0;  
		            //写入文件  
		            while ((len = in.read(buffer)) > 0) {  
		                out.write(buffer, 0, len);  
		            }  				
			}else {
				break;
			}}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {  
		        //关闭输入输出流  
				 out.close();
				 in.close();
		    }  
		}
         FileInputStream fis = new FileInputStream(file);
         MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
         byte[] buffer = new byte[BUF_SIZE];
         int length = -1;
         while ((length = fis.read(buffer, 0, BUF_SIZE)) != -1) {
             md.update(buffer, 0, length);
         }
         BigInteger bigInt = new BigInteger(1, md.digest());
         String value = bigInt.toString(16);
         System.out.println(value);
         String md5 =upload.getMd5();
         if(md5.equals(value))
         {
        	 result = true;
         }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fis.close();
		}
		return result;
}
}
