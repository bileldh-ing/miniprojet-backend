# Miniprojet Backend

## Prerequisites

Before running the Notification Microservice, you need to install the following dependencies:

### 1. **Erlang (Required for RabbitMQ)**
   - Erlang is a programming language used by RabbitMQ.
   - Download the Erlang installer for Windows: [Erlang Downloads](https://www.erlang.org/downloads)
   - Select the version `otp_win64_27.1.2.exe` (or the latest version).
   - Run the installer and follow the instructions to install Erlang on your machine.

### 2. **RabbitMQ**
   - RabbitMQ is a message broker used for communication between services.
   - Download RabbitMQ installer for Windows: [RabbitMQ Downloads](https://www.rabbitmq.com/docs/install-windows.html)
   - Choose the RabbitMQ installer `rabbitmq-server-4.0.2.exe` (or the latest version available).
   - Run the installer and follow the instructions to install RabbitMQ on your system.

### 3. **Enable RabbitMQ Management Plugin**
   - Open a command prompt and run:
     ```bash
     rabbitmq-plugins enable rabbitmq_management
     ```

### 4. **Start RabbitMQ Server**
   - Start the RabbitMQ server by running the following command in your command prompt:
     ```bash
     rabbitmq-server
     ```

   - The RabbitMQ server will start running, and you can access the RabbitMQ management interface at `http://localhost:15672` (default username: `guest`, password: `guest`).

### 5. **Maven** (if not already installed)
   - Download Maven: [Maven Downloads](https://maven.apache.org/download.cgi)
   - Follow the installation instructions for your platform.

### 6. **Java** (Required for Spring Boot)
   - Ensure you have **Java 11** or a higher version installed. You can download it from [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

## Running the Application

### 1. Clone the repository
   ```bash
   git clone https://github.com/yourusername/miniprojet-backend.git
