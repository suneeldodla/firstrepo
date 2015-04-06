$(document).ready(function() {

	/*$(".btn.btn-primary").click(function() {
		$(".commentdiv").append('<button type="submit" id="Post another Comment">');
		});*/
	$("#button").click( function()
			{
		$("#text").prop('disabled',false);
			});
	$("#save").click( function()
			{
		$("#text").prop('disabled',true);
			});


	$("#button1").click( function()
			{
		$("#text1").prop('disabled',false);
			});
	$("#save1").click( function()
			{
		$("#text1").prop('disabled',true);
			});


	$("#button2").click( function()
			{
		$("#text2").prop('disabled',false);
			});
	$("#save2").click( function()
			{
		$("#text2").prop('disabled',true);
			});

	$("#button3").click( function()
			{
		$("#text3").prop('disabled',false);
			});
	$("#save3").click( function()
			{
		$("#text3").prop('disabled',true);
			});

	$("#button4").click( function()
			{
		$("#text4").prop('disabled',false);
			});
	$("#save4").click( function()
			{
		$("#text4").prop('disabled',true);
			});

	$("#button5").click( function()
			{
		$("#text5").prop('disabled',false);
			});
	$("#save5").click( function()
			{
		$("#text5").prop('disabled',true);
			});

	$("#button6").click( function()
			{
		$("#text6").prop('disabled',false);
			});
	$("#save6").click( function()
			{
		$("#text6").prop('disabled',true);
			});
	$("#button7").click( function()
			{
		$("#text7").prop('disabled',false);
			});
	$("#save7").click( function()
			{
		$("#text7").prop('disabled',true);
			});

	$("#button8").click( function()
			{
		$("#text8").prop('disabled',false);
			});
	$("#save8").click( function()
			{
		$("#text8").prop('disabled',true);
			});

	$("#button9").click( function()
			{
		$("#text9").prop('disabled',false);
			});
	$("#save9").click( function()
			{
		$("#text9").prop('disabled',true);
			});

	$("#button10").click( function()
			{
		$("#text10").prop('disabled',false);
			});
	$("#save10").click( function()
			{
		$("#text10").prop('disabled',true);
			});

	$(".btn.btn-danger").click(function()
			{
		alert("Do you want to Report Abuse?");
			});

	$(function(){
		$('ul.tabs li:first').addClass('active');
		$('.block article').hide();
		$('.block article:first').show();
		$('ul.tabs li').on('click',function(){
			$('ul.tabs li').removeClass('active');
			$(this).addClass('active');
			$('.block article').hide();
			var activeTab = $(this).find('a').attr('href');
			$(activeTab).show();
			return false;
		});
	});
	
	/*	$(function run() {
       document.getElementById("Ultra").value;
    });*/
	$(function() {
	$('#toggleButton').click( function() {
	  $('#commentdiv').toggle('5000');
	  $('#footer').toggle('5000', function(){
		if ($('#footer').is(':visible')) {
		 $('#toggleButton').val('comment') 
		} else {
			$('#toggleButton').val('post') 
		  }
	    });
	  });
	});
/*	$(function(){
		$('#toggleButton').click(function()
				{
				$('#commentdiv').append('<div id="commentDiv"><textarea rows="4" cols="50" id="commentTextArea">'+
						'<button id="postComment"></button></div>');
				})
	});*/
});






