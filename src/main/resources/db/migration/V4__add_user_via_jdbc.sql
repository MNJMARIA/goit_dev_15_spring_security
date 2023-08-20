INSERT INTO users (username, password,enabled) VALUES
    ('user', '$2a$10$zBftbRAT0DSRGXtQxgzCW.Rg7TkEvEiHfQd7iO4zWGjIHtrNWVd6K', true);
    --використовуємо bcrypt-хеш пароля "jdbcDefault", який можна згенерувати перед тим,
    --як додавати його до бази даних. Для генерації bcrypt-хеша пароля можна
    --використовувати інструменти, такі як BCryptPasswordEncoder у Spring Security.

INSERT INTO authorities (username, authority) VALUES
    ('user', 'ROLE_USER');