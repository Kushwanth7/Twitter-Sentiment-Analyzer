<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.sql.*,twitter4j.*,java.util.*,java.io.*,Tweetification.*"%>
<%@ page import="twitter4j.conf.ConfigurationBuilder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>First Page</title>


<style type="text/css">

body {
background-image:url(images/bg.jpg);
background-repeat:repeat;
}

input {
	padding: 5px;
	font-size: 15px;
	text-shadow: 0px 1px 0px #fff;
	outline: none;
	background: -webkit-gradient(linear, left top, left bottom, from(#bcbcbe), to(#ffffff));
	background: -moz-linear-gradient(top,  #bcbcbe,  #ffffff);
}

input[type=text], textarea {
  @include transition(all 0.30s ease-in-out);
  outline: none;
  padding: 3px 0px 3px 3px;
  margin: 5px 1px 3px 0px;
  border: 1px solid #DDDDDD;
}
 
input[type=text]:focus, textarea:focus {
  @include box-shadow(0 0 5px rgba(81, 203, 238, 1));
  padding: 3px 0px 3px 3px;
  margin: 5px 1px 3px 0px;
  border: 1px solid rgba(81, 203, 238, 1);
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
height:auto;
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
</style>
</head>
<body>


<div class="cloud">
<div  id="wrapper">


<div class ="head">
<img src="images/logo.png" alt="logo.png" width="414" height="90"> 
</div>

<h1>
<form action="StartProgram">			
			 Please enter a keyword to be analyzed<br>
			<input type="text" name="tweet" size="20px"></br>
			 Please enter the number of tweets to be retrieved(Minimum 15 will be retrieved)<br>
			<input type="text" name="TweetCount" size="10px">
			</br>
			<input type="submit" value="Start Analyzing">
</form>
			
		



</h1>



<div id="right">
<img src="images/righttext.png" alt="alt">
 <%
  	ConfigurationBuilder cb = new ConfigurationBuilder();
  	cb.setOAuthConsumerKey("JxcBneCgXbnRgBYDayqZw");
  	cb.setOAuthConsumerSecret("H7z1vYpl4Q8rC6L7iueFcZ5X2pxwlfkLzuNq37EdM");
  	cb.setOAuthAccessToken("1186416008-38JY8lSYJ7ZKkbctChcQQht1FTYZBvjFw3PUMRh");
  	cb.setOAuthAccessTokenSecret("zIdOOZS7065cU3awsjMYbtdGcylRoQvIfQiMtODzg");
      Twitter twitter = new TwitterFactory(cb.build()).getInstance();
      Trends trends = twitter.getPlaceTrends(23424848);
      int i=1;
      List<String> currentTrends = new ArrayList<String>();
      for(Trend t: trends.getTrends()){
          String name = t.getName();
          currentTrends.add(name);
         out.println(i+++"        "+" "+name+"<br>");
      }
      %>
</div>
<div id="left">
<img src="images/lefttext.png" alt="alt">
<% 
Query query = new Query(currentTrends.get(0));

QueryResult result = null;

result = twitter.search(query);

//QueryResult result = twitter.search(query);
int ii=1;
List<Status> tweets = result.getTweets();
for (Status tweet : result.getTweets()) {
out.println("<p>");
out.println("<b>("+ii+++") "+tweet.getUser().getScreenName()+"("+tweet.getCreatedAt()+")"+"</b>" + " : " + tweet.getText()+"<br/>");
out.println("</p>");
}

%>


</div>


</div>
</div>

</body>
</html>
