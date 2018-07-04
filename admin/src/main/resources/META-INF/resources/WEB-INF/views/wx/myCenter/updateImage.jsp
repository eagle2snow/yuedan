<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"  
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">  
    <head>  
        <title>Hello World!</title>  
        <script type="text/javascript" src="/springboot/js/jquery.1.7.2.min.js"></script>  
        <script type="text/javascript" src="/springboot/js/jquery-form.js"></script>  
    </head>  
    <body>  
        <table>  
        <tr>  
        <td  id="imgDiv">  
            <img id="imgid" th:src="@{/default.jpg}" style="width:137px; height:127px"/>  
        </td>  
        </tr>  
        </table>  
        <form id="upload" enctype="multipart/form-data" method="post"><p style='color:red;text-align:left;'>  
            注：<br/>1.照片的像素为160*180px。<br/>2.照片格式为BMP/JPG/JPEG。<br/>3.建议照片大小不超过40k。</p>  
            <input type="file" name="file" id="uploadimage"/><br/>  
            <input type="button" value="上传" id="btn" style="width:137px; height:27px"/>  
        </form>  
        <script type="text/javascript">  
        
        $(document).ready(function() {  
        
        	$("#btn").click(function () {  
            	if(confirm("确认上传？")){  
               		 var imagePath = $("#uploadimage").val();    
                if (imagePath == "") {    
                    alert("please upload image file",2);  
                    return false;    
                }    
                var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);    
                if (strExtension!='jpg') {   
                    if (strExtension!='bmp') {   
                        if (strExtension!='png') {   
                            alert("please upload file that is a image",2);    
                            return false;   
                        }  
                    }  
                }  
                $("#upload").ajaxSubmit({    
                    type : 'POST',    
                    url : 'uploadImage',    
                    success : function(result) {    
                        if(result.status=='0'){  
                            $("#imgDiv").empty();  
                            $("#imgDiv").html('<img src="'+result.data+'" style="width:137px;height:127px;"/>');  
                            $("#imgDiv").show();  
                            $("#uploadimage").val("");  
                        }else{  
                            alert(result.msg+":"+result.data);  
                        }  
                    },    
                    error : function() {    
                        alert("上传失败，请检查网络后重试,上传文件太大");    
                    }    
                });  
            }  
        })  
    });   
    </script>  
    </body>  
</html> 