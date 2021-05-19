create table position
(
  id SERIAL primary KEY,
  Name varchar(50) not null,
  PositionId integer not null
);

insert into position (Name,PositionId)
VALUES
('Разработчик',1),
('Дизайнер',2),
('Менеджер',3),
('Директор',4);
