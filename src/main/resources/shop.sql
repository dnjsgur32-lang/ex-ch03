USE testdb;

SHOW TABLES;

CREATE TABLE product (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'PK',
  name VARCHAR(100) NOT NULL COMMENT '상품명',
  price INT NOT NULL COMMENT '가격(원)',
  stock INT NOT NULL COMMENT '재고(개수)',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성시각',
  CONSTRAINT pk_product PRIMARY KEY (id),
  CONSTRAINT chk_product_price CHECK (price >= 0),
  CONSTRAINT chk_product_stock CHECK (stock >= 0)
);

-- 샘플데이터 삽입
INSERT INTO product(name, price, stock) VALUES
('키보드', 39000, 12),
('마우스', 25000, 30),
('모니터 27"', 229000, 7),
('USB-C 케이블', 5900, 120),
('노트북 거치대', 19900, 23);

-- 기본 동작 확인
SELECT id, name, price, stock, created_at
FROM product
ORDER BY id DESC;

-- 단건 확인
SELECT id, name, price, stock, created_at
FROM product
WHERE id = 1;

-- 수정
UPDATE product
SET name = '키보드(적축)', price = 42000, stock = 10
WHERE id = 1;

-- 삭제
DELETE FROM product
WHERE id = 5;

-- 확인
SELECT * FROM product ORDER BY id DESC;