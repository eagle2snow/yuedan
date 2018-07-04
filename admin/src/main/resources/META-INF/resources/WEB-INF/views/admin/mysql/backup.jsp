<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>数据库备份 </title>

<%@ include file="/common/admin/head.jsp"%>


</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<%@ include file="/common/admin/left.jsp"%>
		<div class="content-wrapper">
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- Horizontal Form -->
					<div class="box box-info">
						<div class="box-header with-border" style="height: 800px;">
							<h3 class="box-title">数据库备份</h3>
							
							<div style="height: 200px;width: 400px;position: relative;top: 30%;left: 35%;">
								<ul style="border: 1px solid #3c8dbc;border-radius: 5px 5px 0 0;height: 200px;">
									<li style="height: 50px;background: #3c8dbc;color: #fff;text-align: center;line-height: 50px;font-size: 20px;font-weight: bold;border-radius: 5px 5px 0 0;">提示</li>
									<li>
										<a id="backup" style="display: block;width: 120px;height: 45px;float: left;background: #3c8dbc;margin-left: 50px;margin-top: 60px;border-radius: 5px;color: #fff;font-weight: bold;text-align: center;line-height: 45px;letter-spacing: 2px;border-bottom: 2px solid #ad9d9d;border-right: 2px solid #ad9d9d;cursor: pointer;">数据备份</a>
										<a id="recovery" style="display: block;width: 120px;height: 45px;float: left;background: #3c8dbc;margin-left: 50px;margin-top: 60px;border-radius: 5px;color: #fff;font-weight: bold;text-align: center;line-height: 45px;letter-spacing: 2px;border-bottom: 2px solid #ad9d9d;border-right: 2px solid #ad9d9d;cursor: pointer;">数据恢复</a>
									</li>
								</ul>
							</div>
							
						</div>
						
		</section>
		
		<div id="Popup" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display: none;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">注意</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">是否进行数据备份？
				</li>
				<li style="background: #fff;">
				<span  id="Popup_ok" style="line-height: 40px;cursor: pointer;display:block;font-size: 18px;text-align: center;float: left;width: 225px;border-right: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;" onclick="go()">确定</span>
				<span id="Popup_off" style="line-height: 40px;cursor: pointer;width: 225px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">取消</span></li>
				</ul>
				</div>
			</div>
			
			<div id="Popup1" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">注意</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">是否进行数据恢复？
				</li>
				<li style="background: #fff;">
				<span id="Popup_ok1" style="line-height: 40px;cursor: pointer;display:block;font-size: 18px;text-align: center;float: left;width: 225px;border-right: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;" onclick="go1()">确定</span>
				<span id="Popup_off1" style="line-height: 40px;cursor: pointer;width: 225px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">取消</span></li>
				</ul>
				</div>
			</div>
		<div id="Popup2" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">提示</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">您的数据已经备份成功
				</li>
				<li style="background: #fff;">
				<span id="Popup_off2" style="line-height: 40px;cursor: pointer;width: 450px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">确定</span></li>
				</ul>
				</div>
			</div>
			
				<div id="Popup3" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">提示</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">您的数据已经恢复成功
				</li>
				<li style="background: #fff;">
				<span id="Popup_off3" style="line-height: 40px;cursor: pointer;width: 450px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">确定</span></li>
				</ul>
				</div>
			</div>
		<div id="Popup4" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">提示</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">您的数据经备份失败
				</li>
				<li style="background: #fff;">
				<span id="Popup_off4" style="line-height: 40px;cursor: pointer;width: 450px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">确定</span></li>
				</ul>
				</div>
			</div>
			
				<div id="Popup5" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">提示</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">您的数据恢复失败
				</li>
				<li style="background: #fff;">
				<span id="Popup_off5" style="line-height: 40px;cursor: pointer;width: 450px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;">确定</span></li>
				</ul>
				</div>
			</div>

				<div id="Popup6" style="width: 100%;height: 100%;background: rgba(0,0,0,0.4);z-index: 99;position: fixed;top: 0;left: 0;display:none ;">
				<div style="width: 450px;height: 200px;position: fixed;top:34%;left: 42%;">
				<ul>
				<li style="background: #3c8dbc; height: 40px;text-align: center;line-height: 45px;color: #fff;font-size: 16px;border-top-left-radius:5px;border-top-right-radius:5px;font-weight: bold;">提示</li>
				<li style="height: 131px;width:450px;background: #fff;text-align: center;font-size: 20px;line-height: 131px;">数据执行中请稍等片刻
				</li>
				<li style="background: #fff;">
				<span id="Popup_off5" style="line-height: 40px;cursor: pointer;width: 450px;float: left;display:block;font-size: 18px;text-align: center;border-left: 1px solid #ccc;height: 40px;background:#3c8dbc;color: #fff;"></span></li>
				</ul>
				</div>
			</div>
		
		</div>
		<%@ include file="/common/admin/footer.jsp"%>
		<%@ include file="/common/admin/right.jsp"%>
		<%@ include file="/common/admin/my_js.jsp"%>

		<div class="control-sidebar-bg"></div>
	</div>

		<script >
			$(function() {
				$("#example1").DataTable();
				$("#key").focus();
			});
			
		laypage({
		  cont: 'page',
		  skin: 'yahei',
		  groups: 10,
		  first: '首页', 
		  last: '尾页',
		  prev: '<', //若不显示，设置false即可
		  next: '>', //若不显示，设置false即可
		  pages: ${page.countPage}, 
		  curr: function(){
		    var page = ${page.indexPage};
		    return page;
		  }(), 
		  jump: function(e, first){ //触发分页后的回调
		    if(!first){ //一定要加此判断，否则初始时会无限刷新
		    	getData(e.curr);
		    }
		  }
		});
		
		
		function getData(indexPage){
			  var k = $("#key").val();
		      location.href = '${adp}list/'+indexPage+'/${page.sizePage}.htm?k='+k;
		}
		
		
		function edit(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}update/'+id+'.htm');
		
			
		}
		function details(id){
		
				openPerRe("编辑订单表", 90,90,'${adp}details/'+id+'.htm');
		
			
		}
		
		function del(id){
			delById(id, '${adp}'); 
		}
		
		
		
		//开关回调
		/* var enableFun = function(){
		} */
		

		</script>
		
		<script type="text/javascript">
		function go(){
			document.getElementById('Popup6').style.display = '';	
			 $.getJSON("${ctx}admin/mysql/backup",
					function(date) {
			//alert(date);
						if(date == "0") {
							document.getElementById('Popup6').style.display = 'none';
							document.getElementById('Popup2').style.display = '';					
						}else{
							document.getElementById('Popup6').style.display = 'none';
							document.getElementById('Popup4').style.display = '';
						}
						
						}); 
		}
		function go1(){
			document.getElementById('Popup6').style.display = '';
			 $.getJSON("${ctx}admin/mysql/restore",
					function(date) {
			//alert(date);
						if(date == "0") {
							document.getElementById('Popup6').style.display = 'none';
							document.getElementById('Popup3').style.display = '';					
						}else{
							document.getElementById('Popup6').style.display = 'none';
							document.getElementById('Popup5').style.display = '';
						}
						
						}); 
		}

		$(document).ready(function(){
			  $("#recovery").click(function(){
			  $("#Popup1").fadeToggle(500);
			  });
			  $("#backup").click(function(){
				  $("#Popup").fadeToggle(500);
				  });
			  $("#Popup_off").click(function(){
				  $("#Popup").fadeToggle(500);
				  });
			  $("#Popup_off1").click(function(){
				  $("#Popup1").fadeToggle(500);
				  });
			  $("#Popup_ok").click(function(){
				  $("#Popup").fadeToggle(500);
				  });
			  $("#Popup_ok1").click(function(){
				  $("#Popup1").fadeToggle(500);
				  });
			  $("#Popup_off2").click(function(){
				  $("#Popup2").fadeToggle(500);
				  });
			  $("#Popup_off3").click(function(){
				  $("#Popup3").fadeToggle(500);
				  });
			  $("#Popup_off4").click(function(){
				  $("#Popup4").fadeToggle(500);
				  });
			  $("#Popup_off5").click(function(){
				  $("#Popup5").fadeToggle(500);
				  });
		});
		</script>
	</body>

</html>