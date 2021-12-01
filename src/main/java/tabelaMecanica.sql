CREATE DATABASE mecanicaAutoMoville;

USE mecanicaAutoMoville;

CREATE TABLE servico (
		id_servico INT not null auto_increment,
		servico varchar(50),
        preco double not null,
        melhoria varchar(50),
        conserto varchar(50),
		PRIMARY KEY (id_servico)
);

select sum(preco) from servico;