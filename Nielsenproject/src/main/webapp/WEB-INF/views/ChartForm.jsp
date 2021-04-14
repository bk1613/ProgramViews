<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bar Chart of number of Views</title>
<script src="js/jquery-2.1.1.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script>
$(document).ready(function() {
	$("#submitBtn").click(function() {
		

		var homes = {
				homeview1: $("#hometown1").val(),
				homeview2: $("#hometown2").val()
				}
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:8083/showTotalviews",
			dataType: "json",		
			data: JSON.stringify(homes),	
			cache: false,
			//present the response in the html content dynamically 
			success: function(result){
					

					var chart = new CanvasJS.Chart("chartContainer", {
						theme: "light1", // "light2", "dark1", "dark2"
						animationEnabled: true, // change to true		
						title:{
							text: "Total Number of Viewers"
						},
						data: [
						{
							// Change type to "bar", "area", "spline", "pie",etc.
							type: "bar",
							dataPoints: [
							]
						}
						]
					});
					
					for(let x of result["views"]){
						
						chart.options.data[0].dataPoints.push({ label: x["genre"],  y: x["viewers"] });
						
					}
					chart.render();
					
			},
			error: function(e){
				alert("Error!");
				console.log("ERROR: ", e);
		}
		});
	});


});
</script>
</head>
<body>
<div>Enter the viewers' home town(s)</div>
home town 1<input class="form-control" type="text" id="hometown1" name="hometown1"/>
home town 2<input class="form-control" type="text" id="hometown2" name="hometown2"/>
<input class="btn-sm btn-primary sbtButton" type="button" id="submitBtn" value="submit"/>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>