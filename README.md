# Hundir el Barco - Cliente/Servidor

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

Este proyecto implementa una arquitectura cliente-servidor en Java utilizando **sockets** y **threads** para un juego de "Hundir el Barco".
El servidor genera coordenadas aleatorias (X, Y) entre 0 y 9, y los clientes intentan adivinarlas en un máximo de tres intentos. Si un cliente acierta, el servidor lo notifica y cierra la conexión.

## 🚀 Tecnologías Utilizadas

- **Lenguaje**: Java 17+
- **Redes**: Sockets TCP/IP
- **Concurrencia**: Threads para manejar múltiples clientes simultáneamente

## 📌 Arquitectura del Sistema

### Servidor (`ServerApp`)

- Inicia en un puerto específico (`8082`).
- Genera **una vez** las coordenadas X e Y aleatorias.
- Escucha conexiones de clientes de manera **concurrente**.
- Crea un hilo (`ClientHandler`) por cada cliente para gestionar su interacción.

### Cliente (`ClientApp`)

- Se conecta al servidor en `localhost:8082`.
- Solicita al usuario que ingrese coordenadas X e Y.
- Envía las coordenadas al servidor y espera respuesta.
- Si acierta, finaliza inmediatamente. Si falla, tiene hasta 3 intentos.

## 🛠 Instalación y Ejecución

### 1️⃣ Clonar el repositorio

```sh
 git clone https://github.com/tu_usuario/hundir-el-barco.git
 cd hundir-el-barco
```

### 2️⃣ Compilar y ejecutar el servidor

```sh
javac -d . src/net/salesianos/server/ServerApp.java
java net.salesianos.server.ServerApp
```

### 3️⃣ Compilar y ejecutar el cliente

```sh
javac -d . src/net/salesianos/client/ClientApp.java
java net.salesianos.client.ClientApp
```

## 🔍 Funcionamiento

### 1️⃣ Ejecutar el servidor

- Compilar y ejecutar `ServerApp`.
- Se mostrará el mensaje: `Servidor iniciado...`.

### 2️⃣ Ejecutar los clientes

- Cada cliente ingresará coordenadas hasta acertar o agotar intentos.
- Si acierta, verá `¡Tocado y hundido!`, de lo contrario `Coordenadas incorrectas`.

### 3️⃣ Pruebas con múltiples clientes

- Se ejecutaron varios clientes simultáneamente.
- El servidor asignó la misma coordenada a todos.
- Cuando un cliente acertó, los demás pudieron seguir intentando.

## 📜 Licencia

Este proyecto está bajo la licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

📌 _Hecho con ❤️ por [alberto](https://github.com/The-Albertox)_
