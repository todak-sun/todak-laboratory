docker pull mongo

docker run --name mongodb -d \
 -e MONGO_INITDB_ROOT_USERNAME=todak \
 -e MONGO_INITDB_ROOT_PASSWORD=todak \
 -e MONGO_INITDB_DATABASE=todak \
 -p 27017:27017 mongo