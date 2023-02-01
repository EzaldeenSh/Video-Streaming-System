<%@ page import="java.util.List" %>
<%@ page import="com.example.StreamService.data.Video" %>

<html>
<head>
<title>Selection</title>
</head>
<body>
<h3>Welcome User!</h3>
<%
List<Video> videos =(List<Video>) request.getAttribute("videos");
if(videos!= null){
session.setAttribute("videos", videos);
}
videos = (List<Video>) session.getAttribute("videos");

int counter = 1;
out.println("Please select a video from the list below: <br>");

for(Video v : videos){
out.println(counter + "- " + v.getName() + "<br>");
counter++;
    }


%>
    <form action="/stream" method="POST">
    <input type = "number" min = "1" max = <%=videos.size()%> name = "selection" value = "1">
    <input type = "submit">
    </form>

</body>
</html