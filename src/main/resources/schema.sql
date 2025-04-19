CREATE DATABASE shopSmart;
USE shopSmart;

CREATE TABLE Users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  phone_number VARCHAR(15) NOT NULL,
  password VARCHAR(255) NOT NULL,
  role ENUM('user', 'admin') DEFAULT 'user'
);


-- Products
CREATE TABLE Products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
  unit VARCHAR(20) NOT NULL,
  stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
  expiry_date DATE,
  category VARCHAR(50) NOT NULL,
  image_url VARCHAR(255)
);

-- Orders
CREATE TABLE Orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  total_amount DECIMAL(10,2) NOT NULL CHECK(total_amount >= 0),
  status ENUM('pending', 'paid', 'shipped', 'cancelled') DEFAULT 'pending',
  FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- OrderDetails
CREATE TABLE OrderDetails (
  order_details_id INT PRIMARY KEY AUTO_INCREMENT,
  order_id INT,
  product_id INT,
  quantity INT NOT NULL CHECK (quantity > 0),
  price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
  FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

-- CartItems Table
CREATE TABLE CartItems (
  cart_item_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  product_id INT,
  quantity INT NOT NULL,
  added_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
  FOREIGN KEY (product_id) REFERENCES Products(product_id),
  UNIQUE(user_id, product_id)
);

-- Activity Log
CREATE TABLE ActivityLog (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    activity VARCHAR(255) NOT NULL,
    activity_type VARCHAR(100) NOT NULL,
    user_id INT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

INSERT INTO Users (name, email, phone_number, password, role)
VALUES ('Admin', 'admin@admin.com', '0000000000', '$2a$12$TorL2T4qT6qoUuvkDgCT7.qQ6jorRGL9aZG8t1zeQiEL5Sldx.lQ.', 'admin');




