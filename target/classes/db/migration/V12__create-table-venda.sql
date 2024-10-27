CREATE TABLE venda
(
  id SERIAL PRIMARY KEY,
  data timestamp without time zone,
  valor_total int not null,
  id_user int not null,
  FOREIGN KEY (id_user) REFERENCES users(id)
);

