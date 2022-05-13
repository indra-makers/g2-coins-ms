create table public.tbl_categories(
    id_category serial primary key,
    nameCategory varchar(255) NOT NULL,
    descriptionCategory varchar(255) NOT NULL
)