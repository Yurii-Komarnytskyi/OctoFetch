## Running OctoFetch with Docker

### Prerequisites
- Docker installed (see [Docker Installation](https://docs.docker.com/get-docker/)).
- A GitHub personal access token with `repo` scope (generate at [github.com/settings/tokens](https://github.com/settings/tokens)).

### Steps
1. **Clone the repository**:
   git clone https://github.com/Yurii-Komarnytskyi/OctoFetch.git
   cd OctoFetch

2. **Build the Docker image**:
    mvn clean package
    docker build -t octofetch:latest .

3. **Run the container**:
    docker run -p 8080:8080 -e GITHUB_PERSONAL-ACCESS-TOKEN=your_token_here octofetch:latest
    (For GitHub authorization use your Personal Access Token passed as an Environment Variable )

4. **Access the API**:
   http://localhost:8080/swagger-ui.html

