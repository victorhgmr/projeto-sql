CREATE TABLE pagamento
(
  id SERIAL PRIMARY KEY,
  id_agendamento int not null,
  valor int not null,
  metodo varchar(50) not null,
  status varchar(50) not null,
  FOREIGN KEY (id_agendamento) REFERENCES agendamento(id)
);

