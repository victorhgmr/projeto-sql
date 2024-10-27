CREATE TABLE logservico
(
  id SERIAL PRIMARY KEY,
  id_agendamento int not null,
  id_servico int not null,
  id_funcionario int not null,
  data timestamp without time zone,
  FOREIGN KEY (id_agendamento) REFERENCES agendamento(id),
  FOREIGN KEY (id_servico)  REFERENCES servico(id),
  FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);