function convertState(n){
	switch(n)
	{
	case 0:
		return "删除";
	case 1:
		return "在业";
	case 2:
		return "停业";
	default:
		return "未知";
	}
}

function convertSource(n){
	switch(n)
	{
	case 0:
		return "系统添加";
	case 1:
		return "站点添加";
	default:
		return "未知";
	}
}

function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
}