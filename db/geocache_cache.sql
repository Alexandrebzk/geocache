CREATE DATABASE IF NOT EXISTS geocache;
use geocache;
drop table if exists cache;
create table cache
(
    id              varchar(255) not null primary key,
    description     varchar(255) null,
    etat            varchar(255) null,
    geolocalisation varchar(255) null,
    nature          varchar(255) null,
    type            varchar(255) null,
    lieu_id         varchar(255) null,
    proprietaire_id varchar(255) null
);

drop table if exists lieu;
create table lieu
(
    id  varchar(255) not null primary key,
    nom varchar(255) null
);

drop table if exists utilisateur;
create table utilisateur
(
    id          varchar(255) not null primary key,
    description varchar(255) null,
    photo       varchar(255) null,
    pseudo      varchar(255) null
);

drop table if exists visite;
create table visite
(
    id           varchar(255) not null primary key,
    commentaire  varchar(255) null,
    date_passage datetime     null,
    photo        varchar(255) null,
    cache_id     varchar(255) null,
    utilisateur_id      varchar(255) null
);

ALTER TABLE visite
    ADD constraint FK_visite_utilisateur foreign key (utilisateur_id) references utilisateur (id) ON DELETE CASCADE,
    ADD constraint FK_visite_cache foreign key (cache_id) references cache (id) ON DELETE CASCADE;
ALTER TABLE cache
    ADD constraint FK_cache_utilisateur foreign key (proprietaire_id) references utilisateur (id) ON DELETE SET NULL,
    ADD constraint FK_cache_lieu foreign key (lieu_id) references lieu (id) ON DELETE CASCADE;
