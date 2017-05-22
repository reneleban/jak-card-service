build:
	./gradlew clean build;

clean:
	rm -rf build;
	sudo docker stop cards;
	sudo docker rm cards;
	sudo docker rmi codecamps/jak-cards;

install:
	sudo docker build -t codecamps/jak-cards .;

run:
	sudo docker run -d -p 8282:8080 -p 8000:8000 --name cards codecamps/jak-cards:latest;

