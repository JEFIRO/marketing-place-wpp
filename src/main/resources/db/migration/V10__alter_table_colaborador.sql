alter table colaborado
    add column status boolean default true,
    add column data_criacao timestamp default NOW(),
    add column data_atualizacao timestamp default NOW(),
    add column data_exclusao timestamp;
