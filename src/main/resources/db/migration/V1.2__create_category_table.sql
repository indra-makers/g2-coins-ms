create table public.tb_category(
    idCategory serial primary key,
    nameCategory varchar(255) NOT NULL,
    descriptionCategory varchar(255) NOT NULL
)