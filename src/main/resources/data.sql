
INSERT INTO
tb_tipo_usuario (idTipoUsuario,nome)
VALUES 
(1,"Administrador"),
(2,"Colaborador"),
(3,"Visitante");

INSERT INTO  tb_bacia_hidrografica  ( idBaciaHidrografica, area,nome) VALUES (1,90000.00,"Bacia Botafogo");
INSERT INTO  tb_bacia_hidrografica  ( idBaciaHidrografica,area,nome) VALUES (2,90000.00,"Bacia do Sao Francisco");
INSERT INTO  tb_bacia_hidrografica  ( idBaciaHidrografica, area,nome) VALUES (3, 90000.00,"Bacia Tapacura");


INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (1,"Acude Cabeca da Onca (Poco da Areia)","DRI","SERTAO","CPR Sao Francisco","","026/2020_APAC","","",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (2,"Acude da Roca","DRI","SERTAO","CPR Sao Francisco","","","","",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (3,"Acude do Alemao","DRI","AGRESTE","CPR Palm ou Mat. ","","","","COMPESA",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (4,"Acude do Governo","DRI","SERTAO","CPR Araripe","","","","",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (5,"Acude Paus Branco","DRI","SERTAO","CPR Sao Francisco","","","","",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (6,"Afetos","DRI","AGRESTE","CPR Ipojuca","1944","","","COMPESA",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (7,"Agua Fria","DRI","AGRESTE","CPR Ipojuca","","036/2019_APAC","","",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (8,"Agua Fria de Baixo","DRI","AGRESTE","CPR Mata Sul","","","","COMPESA",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (9,"Agua Fria de Cima","DRI","AGRESTE","CPR Mata Sul","","028/2018_APAC","","COMPESA",1);
INSERT INTO  tb_barragem  ( idBarragem,nome,diretoria,gerencia,coordenacao,anoConstrucao,outorgaCaptacao,outorgaObraHidrica,titularidade,idBaciaHidrografica) VALUES (10,"Aguas Claras","DRI","AGRESTE","CPR Mata Sul","2004","042_2019_APAC","016/2020_APAC","COMPESA",1);




