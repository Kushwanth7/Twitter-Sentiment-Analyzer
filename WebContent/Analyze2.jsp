<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Twitter Sentiment Analyzer</title>

<style type="text/css">

body {
background-image:url(images/bg.jpg);
background-repeat:repeat;
}

input {
	padding: 5px;
	font-size: 18px;
	text-shadow: 0px 1px 0px #fff;
	outline: none;
	background: -webkit-gradient(linear, left top, left bottom, from(#bcbcbe), to(#ffffff));
	background: -moz-linear-gradient(top,  #bcbcbe,  #ffffff);
	width:900px;
	height:auto;
}


label {
  width: 150px;
  float: left;
}

.head {
background-color:#FFFFFF;
background-position:left;
}
.cloud
{
background-image:url(images/bg.png);
background-repeat:repeat-x;
height:200px;
}
#right{
background-color:#FFFFFF;
height:1000px;
width:440px;
float:right;
}
#left{
background-color:#FFFFFF;
height:1000px;
width:440px;
float:left;
}
#wrapper
{
width:956px;
margin-left:auto;
margin-right:auto;
}

h1 {
margin-left:10px;
margin-top:100px;
color:rgb(122,111,222);
}
h1 {
	font: normal 48px Georgia, "Times New Roman", Times, serif;
	text-align: left;
  color: #272D32;
}
#textpanel{
background-color:#FFFFFF;
background-position:left;
}
</style>

</head>
<body>

<div class="cloud">
<div  id="wrapper">


<div class ="head">
<img src="images/logo.png" alt="logo.png" width="414" height="90"> 
</div>
<h2><p>Number Of Tweets Retrieved is </p>
<b><%=request.getAttribute("tweet_count") %></b></h2>
<br>

<table border="1" width="900">
<tr>
<th>Positive</th>
<th>Negative</th>
<th>Neutral</th>
<th>Others</th>
</tr>
<tr>
<td><%=request.getAttribute("pos_count") %></td>
<td><%=request.getAttribute("neg_count") %></td>
<td><%=request.getAttribute("nue_count") %></td>
<td><%=request.getAttribute("other_count") %></td>
</tr>
</table>

<br>

<%
String s1 = null;
s1 = (String)request.getAttribute("one-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("one-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("one-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("one-test")%>" size="90">
<%}%>

<br>
<%
s1 = null;
s1 = (String)request.getAttribute("two-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("two-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("two-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("two-test")%>" size="90">
<%}%>
<br>
<%
s1 = null;
s1 = (String)request.getAttribute("three-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("three-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("three-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("three-test")%>" size="90">
<%}%>
<br>
<%
s1 = null;
s1 = (String)request.getAttribute("four-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("four-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("four-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("four-test")%>" size="90">
<%}%>
<br>
<%
s1 = null;
s1 = (String)request.getAttribute("five-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("five-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("five-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("five-test")%>" size="90">
<%}%>
<br>
<%
s1 = null;
s1 = (String)request.getAttribute("six-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("six-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("six-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("six-test")%>" size="90">
<%}%>

<br>
<%
s1 = null;
s1 = (String)request.getAttribute("seven-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("seven-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("seven-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("seven-test")%>" size="90">
<%}%>

<br>
<%
s1 = null;
s1 = (String)request.getAttribute("eight-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("eight-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("eight-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("eight-test")%>" size="90">
<%}%>

<br>
<%
s1 = null;
s1 = (String)request.getAttribute("nine-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("nine-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("nine-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("nine-test")%>" size="90">
<%}%>

<br>
<%
s1 = null;
s1 = (String)request.getAttribute("five-result");
%>
<%if(s1.equalsIgnoreCase("Positive")){ %>
<input type="text" style="background-color:transparent; color:green; 
text-align:center" value="<%=request.getAttribute("ten-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Negative")){%>
<input type="text" style="background-color:transparent; color:red; 
text-align:center" value="<%=request.getAttribute("ten-test")%>" size="90">
<%}else if(s1.equalsIgnoreCase("Neutral")){%>
<input type="text" style="background-color:transparent; color:grey; 
text-align:center" value="<%=request.getAttribute("ten-test")%>" size="90">
<%}%>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
    	var a = <%= request.getAttribute("pos_count")%>
    	var b = <%= request.getAttribute("neg_count")%>
    	var c = <%= request.getAttribute("nue_count")%>
    	var d = <%= request.getAttribute("other_count")%>
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Sentiment Analysis'],
          ['Positive Tweet Percentage',     a],
          ['Negative Tweet Percentage',      b],
          ['Neutral Tweet Percentage',  c],
          
        ]);

        var options = {
          title: 'Twitter Sentiment Analysis Results'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
     <div id="chart_div" style="width: 900px; height: 500px;"></div>
     <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['gauge']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
    	var a = <%= request.getAttribute("pos_count")%>
      	var b = <%= request.getAttribute("neg_count")%>
      	var c = <%= request.getAttribute("nue_count")%>
      	var d = <%=request.getAttribute("tweet_count") %>
        var data = google.visualization.arrayToDataTable([
          ['Label', 'Value'],
          ['Positive', (a/d)*100],
          ['Negative', (b/d)*100],
          ['Neutral', (c/d)*100]
        ]);
      
        // Create and draw the visualization.
        new google.visualization.Gauge(document.getElementById('visualization')).
            draw(data);
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>
    <div id="visualization" style="width: 600px; height: 300px;"></div>
</div>
</div>

</body>

</html>