# user-repository
user-repository for project Booking App

Some important commands:
Build a docker image:

docker build . -t user-service:v1

above command will create image and container.

Deploy docker image to kubernetes:

kubectl -f apply Deployment.yml

above command will create deployment and service on kubernetes

user-service is using:
booking-service: This service is responsible to actually book the appointment based on the logic. This service can access database for booking purposes. Git link is: https://github.com/pankajsoni166/booking-service.git

On the backend we are using MySql database
