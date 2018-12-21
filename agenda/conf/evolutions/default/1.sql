# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contato (
  id                            integer auto_increment not null,
  nome                          varchar(255),
  email                         varchar(255),
  telefone                      varchar(255),
  usuario_id                    integer,
  constraint pk_contato primary key (id)
);

create table usuario (
  id                            integer auto_increment not null,
  email                         varchar(255),
  senha                         varchar(255),
  constraint pk_usuario primary key (id)
);

create index ix_contato_usuario_id on contato (usuario_id);
alter table contato add constraint fk_contato_usuario_id foreign key (usuario_id) references usuario (id) on delete restrict on update restrict;


# --- !Downs

alter table contato drop constraint if exists fk_contato_usuario_id;
drop index if exists ix_contato_usuario_id;

drop table if exists contato;

drop table if exists usuario;

