alter table produto
    add column added_by int,
    add column disponivel_na_loja varchar(1),    

    add constraint fk_produto_colaborado foreign key (added_by) references colaborado(id);
