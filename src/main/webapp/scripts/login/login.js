/**
 * 登录模块
 */
var params = {};

$(function(){
	params.dataDiv = $("#dataDiv");
	params.getDataBtn = $("#getData");
	params.getDataBtn.click(queryData);
});

var queryData = function() {
	$.ajax({
		url : "/Maven_Demo2/data/getData",
		type : "post",
		dataType : "json",
		success : function(data) {
			params.dataDiv.text(data);
		}
	});
}