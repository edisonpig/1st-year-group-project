
$(document).ready(function () {
	$("#submit1").click(function () {
		
		var dataArray = $("#form1").serializeArray(),
			dataObj = {};

		$(dataArray).each(function (i, field) {
			dataObj[field.name] = field.value;
		});

		$('#form1').on('submit', function (e) {
			$.post('http://localhost:8080/GRP_PRJ/Servlet', 
				{
					date_part1: dataObj['date1'],
					date_part2: dataObj['date2'],
					date_part3: dataObj['date3']				
			},
			
			
			
			
			
			
			
			
			
			
				function (data1,status) {
				
					//This gets executed when post is successful
					//alert(data + "/" + status);
				
				//split the data1 and rename it
				var arr = new Array();
				arr = data1.split("%");
				
					$("#output1").text(arr[0]);
					$("#output2").text(arr[1]);
				}).error(function () {
					
				// This is executed when the call to post failed
			});
			//We now prevent the page from refreshing after post
			e.preventDefault();
		});
	});
});

