# crudbiblioteca

# Traer todos los libros (GET)
http://localhost:8080/api/v1/books

# Traer un libro por Id (GET)
http://localhost:8080/api/v1/books/{bookId}

# Crear un libro nuevo (POST)
http://localhost:8080/api/v1/books,  no es necesario poner el id del libro, porque lo genera automáticamente

# Actualizar un libro (POST)
http://localhost:8080/api/v1/books, se puede usar el mismo endpoint anterior, indicando cuál va ser el id activo en el objeto json

# Actualizar un libro (PUT) por book_id
http://localhost:8080/api/v1/books/{bookId}

# Eliminar un libro (DELETE)
http://localhost:8080/api/v1/books/{bookId}

# Para crear un préstamo (POST)
http://localhost:8080/api/v1/loans/{bookId}/{UsetType}/{diasdedevolucion}

- bookId = El id del libro que se va a prestar
- UserType = Puede ser únicamente la palabra AFILIADO, EMPLEADO o INVITADO