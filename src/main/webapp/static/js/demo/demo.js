/**
 * 
 */
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return projectName;
}

var params = {};

var getObjectById = function() {
	params.id = 6;
	ajaxLoad();
}

var ajaxLoad = function() {
	var span = $("#showSpan");
	$.ajax({
		url : getRootPath() + "/demo/getObjectById",
		data : params,
		type : 'post',
		dataType : 'json',
		success : function(data) {
			console.debug(data);
			span.html(data);
		},
		error : function(data) {
			console.debug(data);
		}
	});
}