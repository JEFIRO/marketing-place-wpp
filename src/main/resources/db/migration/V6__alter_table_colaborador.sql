alter table colaborado
    add column id_loja int,
    add constraint fk_id_loja foreign key (id_loja) references loja(id);