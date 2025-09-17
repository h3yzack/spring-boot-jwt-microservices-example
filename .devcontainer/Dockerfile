# Base devcontainer image
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Install OpenJDK 21
RUN apt-get update && apt-get install -y openjdk-21-jdk \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/archives/*

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/lib/jvm/java-21-openjdk-arm64
ENV PATH $JAVA_HOME/bin:$PATH

# Set default shell
SHELL ["/bin/bash", "-c"]


