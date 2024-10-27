CREATE TABLE agendamento
(
  id SERIAL PRIMARY KEY,
  data timestamp without time zone,
  status varchar(50) not null,
  idUsuario int not null,
  idAnimal int not null,
  idServico int not null,
  FOREIGN KEY (idUsuario) REFERENCES users(id),
  FOREIGN KEY (idAnimal)  REFERENCES animal(id),
  FOREIGN KEY (idServico) REFERENCES servico(id)
);