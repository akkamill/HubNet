curl -X POST \
http://localhost:7070/api/users/create \
-H 'Content-Type: multipart/form-data' \
-F 'name=John' \
-F 'lastName=Doe' \
-F 'emailAddress=john@example.com' \
-F 'profilePhoto=@C:\Users\ASUS\Desktop\Edited'
