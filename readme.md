### Clone repo
### Build project with gradle
### In terminal "docker compose up"

## For postgres database go to 

http://localhost:5050/browser/

host name: postgres

username: postgres

password: test

## Trying out endpoint in postman can be used with this curl:
form-data key = file

curl -X POST \
http://localhost:8080/upload \
-H 'cache-control: no-cache' \
-H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
-H 'postman-token: 57e70353-8032-6ff9-fff1-e111dacdb3fa' \
-F file=@exampleDataS2



### This version of gradle was used because other versions couldn't start project.
./gradlew wrapper --gradle-version=7.5-20220712235452+0000