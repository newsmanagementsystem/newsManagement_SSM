/**
 * 
 */
function check() {
	var themename = document.getElementById("themename");

	if (themename.value == "") {
		layer.msg('主题名称不能为空！', {
			time: 2000
		})
		themename.focus();
		return false;
	}
	return true;
}
