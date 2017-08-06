<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="/res/js/d3.min.js" ></script>
		<script type="text/javascript" src="/res/js/strucMap.min.js" ></script>
		<link rel="stylesheet" href="/res/css/strucMap.min.css" />
		
	</head>
	<body>
		<div id="topomap" class=""></div>
		<script type="text/javascript">
	        var options = {
	        	selector:"#topomap",
	            width: 1140,
	            height: 840,
	            lineLength:100,
//	            textColor:"#000",
//	            textFontFamily:'',
	            nodesClick: function(t) {
	            	if(t.index==0) t.fixed=1;
	            	console.log(t)
	            }
	            };
	            var nodesJson = [{"fixed":true,"id":2,"index":0,"prop":{"name":"机器学习"},"x":560,"y":480},{"id":"22","index":1,"prop":{"name":"工作平台"}},{"id":36,"index":2,"prop":{"name":"语言选择"}},{"id":37,"index":2,"prop":{"name":"学习工具"}},{"id":58,"index":2,"prop":{"name":"机器学习工具"}},{"id":59,"index":2,"prop":{"name":"机器学习框架"}},{"id":61,"index":2,"prop":{"name":"机器学习库"}},{"id":"23","index":1,"prop":{"name":"资源汇总"}},{"id":38,"index":2,"prop":{"name":"数据集"}},{"id":54,"index":2,"prop":{"name":"案例分析"}},{"id":63,"index":2,"prop":{"name":"资源汇总"}},{"id":"24","index":1,"prop":{"name":"基本概念"}},{"id":12,"index":2,"prop":{"name":"基本概念"}},{"id":"25","index":1,"prop":{"name":"学习方法"}},{"id":39,"index":2,"prop":{"name":"学习方法"}},{"id":"26","index":1,"prop":{"name":"算法实现"}},{"id":40,"index":2,"prop":{"name":"分类算法"}},{"id":41,"index":2,"prop":{"name":"回归算法"}},{"id":43,"index":2,"prop":{"name":"聚类算法"}},{"id":"27","index":1,"prop":{"name":"数据预处理"}},{"id":44,"index":2,"prop":{"name":"数据预处理"}},{"id":"28","index":1,"prop":{"name":"特征工程"}},{"id":46,"index":2,"prop":{"name":"特征选择"}},{"id":48,"index":2,"prop":{"name":"特征提取"}},{"id":"29","index":1,"prop":{"name":"问题建模"}},{"id":49,"index":2,"prop":{"name":"问题建模"}},{"id":"30","index":1,"prop":{"name":"模型选择"}},{"id":51,"index":2,"prop":{"name":"交叉验证"}},{"id":52,"index":2,"prop":{"name":"参数选择"}},{"id":"31","index":1,"prop":{"name":"模型评估"}},{"id":53,"index":2,"prop":{"name":"模型评估"}}];
	           	var linksJson = [{"source":0,"target":1,},{"source":1,"target":2,},{"source":1,"target":3,},{"source":1,"target":4,},{"source":1,"target":5,},{"source":1,"target":6,},{"source":0,"target":7,},{"source":7,"target":8,},{"source":7,"target":9,},{"source":7,"target":10,},{"source":0,"target":11,},{"source":11,"target":12,},{"source":0,"target":13,},{"source":13,"target":14,},{"source":0,"target":15,},{"source":15,"target":16,},{"source":15,"target":17,},{"source":15,"target":18,},{"source":0,"target":19,},{"source":19,"target":20,},{"source":0,"target":21,},{"source":21,"target":22,},{"source":21,"target":23,},{"source":0,"target":24,},{"source":24,"target":25,},{"source":0,"target":26,},{"source":26,"target":27,},{"source":26,"target":28,},{"source":0,"target":29,},{"source":29,"target":30,}];
	           	console.log(linksJson)
	            loadMap(options, nodesJson, linksJson);
		</script>
	</body>
</html>
