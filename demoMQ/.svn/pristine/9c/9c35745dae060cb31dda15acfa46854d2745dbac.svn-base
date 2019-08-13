function isNull(obj){
	return obj == undefined || obj == null || $.trim(obj.toString()) == '';
}

/**
 * 判断不为空
 * @param {Object} obj
 */
function isNotNull(obj){
	return !isNull(obj);
}
$.extend({
	toStr:function(obj){
		var array = new Array();
		for(var i in obj){
			if(typeof(obj[i]) != 'function'){
				array.push(obj[i]);
			}
		}
		return array.toString();
	},
	equals:function(obj, obj1){
		if(typeof(obj)=='string'&&typeof(obj1)=='string'){
			return obj==obj1;
		}
		if($.trim($.toStr(obj)) == $.trim($.toStr(obj1))){
			return true;
		}
		return false;
	}
});