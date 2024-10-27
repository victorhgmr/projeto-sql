CREATE TABLE vendaproduto
(
  id_venda int not null,
  id_produto int not null,
  quantidade int not null,
  FOREIGN KEY (id_venda) REFERENCES venda(id),
  FOREIGN KEY (id_produto) REFERENCES produto(id)
);

