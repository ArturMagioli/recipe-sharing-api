CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by varchar(20) DEFAULT 'System' NOT NULL,
    updated_at TIMESTAMP NULL,
    updated_by varchar(20) NULL
);

CREATE TABLE IF NOT EXISTS recipes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title varchar(50) NOT NULL,
    description TEXT,
    ingredients TEXT NOT NULL,
    instructions TEXT NOT NULL,
    servings INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by varchar(20) DEFAULT 'System' NOT NULL,
    updated_at TIMESTAMP NULL,
    updated_by varchar(20) NULL,
    CONSTRAINT fk_recipes_users
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS ingredients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    recipe_id BIGINT NOT NULL,
    ingredient_value DECIMAL(5,2) NOT NULL,
    unit ENUM ('G', 'KG', 'ML', 'L', 'PC', 'TSP', 'TBSP', 'PINCH') NOT NULL,
    ingredient_type varchar (60) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by varchar(20) DEFAULT 'System' NOT NULL,
    updated_at TIMESTAMP NULL,
    updated_by varchar(20) NULL,
    CONSTRAINT fk_ingredients_recipes
    FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE SET NULL
);