
# 🚀 RUN.MD - Documentação Técnica

## 📂 Visão Geral

Este projeto é uma API RESTful desenvolvida em **Kotlin** utilizando o padrão **Clean Architecture**. Seu objetivo é listar detalhes de produtos a partir de um arquivo JSON local.

---

## 📐 Estrutura de Pacotes

A estrutura segue a Clean Architecture dividida em:

```
com.listproducts
│
├── adapter                # Adaptadores de entrada e saída
│   ├── input.controller   → API REST
│   └── output.repository  → Leitura do JSON local
│
├── application.usecase    # Casos de uso (lógica de negócio)
│
├── domain
│   ├── model              → Modelo de domínio (Product)
│   ├── port.input         → Interfaces de entrada
│   └── port.output        → Interfaces de saída
│
└── infra.config           → Configurações da aplicação
```

---

## 🔧 Principais Classes

| Classe | Descrição |
|--------|-----------|
| `Application.kt` | Classe principal de inicialização da aplicação Spring Boot. |
| `ProductController.kt` | Define os endpoints REST para acesso aos produtos. |
| `ProductJsonRepository.kt` | Implementação de repositório que lê os dados do arquivo `products.json`. |
| `ProductUseCase.kt` | Camada de aplicação que orquestra a lógica de negócio. |
| `Product.kt` | Modelo de domínio que representa um produto. |
| `ProductUseCase (interface)` | Define a porta de entrada para os casos de uso. |
| `ProductRepository` | Interface de saída usada para acesso a dados. |
| `AppConfig.kt` | Configura os beans necessários para injeção de dependência. |

---

## 🌐 API RESTful

### Endpoints Disponíveis

#### ✅ `GET /api/products/all`

Retorna **todos os produtos** disponíveis.

- **URL completa:** `http://localhost:8080/api/products/all`
- **Corpo da requisição:** _nenhum_
- **Resposta:**

```json
[
  {
    "name": "Fone Bluetooth A10",
    "brand": "Marca X",
    "price": 149.99,
    "batteryLife": "10h",
    "features": ["Bluetooth 5.0", "Resistente à água"]
  }
]
```

---

#### ✅ `GET /api/products/by-ids`

Retorna **apenas os produtos cujos IDs são passados no corpo da requisição**.

- **URL completa:** `http://localhost:8080/api/products/by-ids`
- **Corpo da requisição (JSON):**

```json
["id1", "id2", "id3"]
```

- **Resposta:**

```json
[
  {
    "name": "Fone Bluetooth A10",
    "brand": "Marca X",
    "price": 149.99,
    "batteryLife": "10h",
    "features": ["Bluetooth 5.0", "Resistente à água"]
  }
]
```

---

## ▶️ Como Executar Localmente

### Pré-requisitos

- [JDK 17+](https://adoptium.net/)
- [Gradle](https://gradle.org/) (opcional – wrapper incluído)
- [Insomnia](https://insomnia.rest/) para testes

### Passos

1. **Descompactar o repositório:**

```bash
cd list-product-kotlin
```

2. **Dar permissão ao script Gradle (Linux/macOS):**

```bash
chmod +x gradlew
```

3. **Compilar o projeto:**

```bash
./gradlew build (Linux)
gradlew.bat (Windows)
```

4. **Executar o projeto:**

```bash
./gradlew bootRun
```

A aplicação será iniciada em:  
📍 `http://localhost:8080`

---

## 🧪 Testes com Insomnia

1. Abrir o **Insomnia**.
2. Criar uma nova requisição do tipo **GET**.
3. Para listar todos os produtos:

```
GET http://localhost:8080/api/products/all
```

4. Para listar produtos por ID:

```
GET http://localhost:8080/api/products/by-ids
```

Com o seguinte corpo (JSON):

```json
["id1", "id2"]
```

---

## 📝 Observações

- O arquivo de produtos (`products.json`) está localizado no projeto, provavelmente na pasta `resources`.
- A aplicação não utiliza banco de dados – todos os dados vêm de um arquivo estático.
