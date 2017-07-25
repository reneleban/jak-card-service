build:
	./gradlew clean build;

clean:
	rm -rf build;
	docker stop cards;
	docker rm cards;
	docker rmi codecamps/jak-cards;

volume:
	docker volume create jak-card-volume;

install:
	docker build -t codecamps/jak-cards .;

run:
	docker run -d -v jak-card-volume:/sqlite-db -p 8282:8080 -p 8000:8000 --name cards codecamps/jak-cards:latest;

all: build install run

