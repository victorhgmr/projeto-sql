CREATE TABLE animal
(
  id SERIAL PRIMARY KEY,
  nome varchar(50) not null,
  especie varchar(50) not null,
  raca varchar(50) not null,
  idade int not null,
  dono int not null,
  FOREIGN KEY (dono) REFERENCES users(id)
);

