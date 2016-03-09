$(document).on('click', '.btn-add', function(e) {
	e.preventDefault();
	
	var controlForm = $('.controls form:first'),
		currentEntry = $(this).parents('.entry:first'),
		newEntry = $(currentEntry.clone()).appendTo(controlForm.find('.add-group'));
	
	newEntry.find('input').val('');
	controlForm.find('.entry:not(:last) .btn-add')
		.removeClass('btn-add').addClass('btn-remove')
		.removeClass('btn-success').addClass('btn-danger')
		.html('<span class="glyphicon glyphicon-minus"></span>');
}).on('click', '.btn-remove', function(e) {
	$(this).parents('.entry:first').remove();
	
	e.preventDefault();
	return false;
});

function concatFields(multiField) {
	var newArray=[];
	
	$("input[name='"+multiField+"']").each(function() {
		newArray.push($(this).val());
	});
	
	$("#"+multiField+"-all").val(newArray.join());
}
$(function() {
	
	$(".date-picker").datepicker();
	
	$(".date-picker").on("change", function () {
		var id = $(this).attr("id");
		var val = $("label[for='" + id + "']").text();
		$("#msg").text(val + " changed");
	});
});
