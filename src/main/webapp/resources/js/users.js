$(function() {
	$("#example1").DataTable();
	$('#example2').DataTable({
		"paging" : true,
		"lengthChange" : true,
		"searching" : true,
		"ordering" : true,
		"info" : true,
		"autoWidth" : false,
		"fixedHeader" : {
			header : true,
			footer : true
		}
	});
});
