# 📚 Literalura

Literalura es un proyecto para buscar libros utilizando la API de Gutendex y mostrar información relevante sobre los libros y sus autores.

## 🛠 Requisitos

- Java 8 (o JDK 8)
- Maven
- IntelliJ IDEA u otro IDE

## 💻 Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu-usuario/literalura.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd literalura
    ```

3. Compila el proyecto usando Maven:

    ```bash
    mvn clean install
    ```

## 🔧 Configuración en IntelliJ IDEA

Asegúrate de que IntelliJ IDEA esté configurado para usar Java 8 (o JDK 8) como versión de compilación:

1. Ve a `File` -> `Project Structure` -> `Project SDK`.
2. Selecciona `Java 8 (o JDK 8)`.

## 🚀 Uso

Ejecuta el proyecto desde tu IDE. El servicio `GutendexServiceImpl` permite buscar libros mediante el método `searchBooks(String title)`.

## 🗂 Clases Principales

### Author

La clase `Author` representa un autor con su nombre, año de nacimiento y año de fallecimiento.

### Book

La clase `Book` representa un libro con su título, idioma, número de descargas y autor.


