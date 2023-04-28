-- V2__adicionar_coluna_dia_pagamentos.sql

ALTER TABLE pagamentos ADD COLUMN dia VARCHAR(6) NOT NULL;
