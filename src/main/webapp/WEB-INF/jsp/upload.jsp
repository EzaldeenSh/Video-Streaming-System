<h3>Welcome User!</h3>
<h4>Upload your Video!</h4>

<form action= "/upload" method= "post" enctype="multipart/form-data">
<input type = "file" name = "video" required = "true" ><br> <br>
<input type = "text" name = "description" placeholder = "Describe your video" required = "true" accept="video/*">
<input type = "submit" value = "upload">
</form>


<p><font color="green">${successMessage}</font></p>
<p><font color="red">${errorMessage}</font></p>