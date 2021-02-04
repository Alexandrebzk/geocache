create table cache
(
    id              varchar(255) not null
        primary key,
    description     varchar(255) null,
    etat            varchar(255) null,
    geolocalisation varchar(255) null,
    nature          varchar(255) null,
    type            varchar(255) null,
    lieu_id         varchar(255) null,
    constraint FK512dcfuudvafic0naq3gs31c1
        foreign key (lieu_id) references lieu (id)
);


create table lieu
(
    id  varchar(255) not null
        primary key,
    nom varchar(255) null
);


create table user
(
    id          varchar(255) not null
        primary key,
    description varchar(255) null,
    photo       varchar(255) null,
    pseudo      varchar(255) null
);


create table visite
(
    id           bigint       not null
        primary key,
    commentaire  varchar(255) null,
    date_passage datetime     null,
    photo        varchar(255) null
);

