Livia Lirio RA 22.124.024-5


Documentação do Projeto Spotfei

Visão Geral

Spotfei é uma aplicação de música desenvolvida em Java com padrão MVC, utilizando banco de dados PostgreSQL. O sistema possui funcionalidades de login, cadastro, gerenciamento de playlists, curtidas, histórico de pesquisa, entre outras.

Tecnologias Utilizadas

Java (NetBeans)

PostgreSQL

JDBC para conexão com o banco

Swing para interface gráfica (Views)

Estrutura do Projeto

Pacotes principais:

Model: Contém classes que representam os dados.

DAO (Data Access Object): Responsáveis pelas operações de acesso ao banco.

Controller: Gerencia a lógica do sistema e intermedia a comunicação entre a View e o DAO.

Views: Interfaces gráficas para interação com o usuário.

Funcionalidades Implementadas

1. Autenticação de Usuário

Login

Cadastro de novo usuário

2. Músicas

Buscar músicas por nome, artista ou gênero

Listar todas as músicas

3. Playlist

Criar uma nova playlist

Adicionar músicas à playlist

Remover músicas da playlist

Excluir playlist

Listar playlists do usuário

4. Curtidas

Curtir uma música

Descurtir uma música

Listar músicas curtidas por um usuário

5. Histórico de Pesquisa

Salvar termos pesquisados

Listar histórico por usuário

Limpar histórico do usuário

DAO Criados

Conexao.java - Conecta com o banco PostgreSQL

UsuarioDAO.java - CRUD de usuários e login

MusicaDAO.java - Busca e listagem de músicas

PlaylistDAO.java - Gerenciamento de playlists

CurtidaDAO.java - Curtidas e descurtidas

HistoricoDAO.java - Registro e consulta de histórico

Controllers Criados

LoginController.java - Login e cadastro
Apresentei dificuldade na realização dos controllers, não foi utilizado da ofrma certa e com otimização. Por tanto, a aplicação não está funcional

Tabelas no Banco de Dados

--  Pessoas 
CREATE TABLE IF NOT EXISTS public.Pessoas ( ID_Pessoa SERIAL PRIMARY KEY, Nome VARCHAR(100) NOT NULL, Senha VARCHAR(200) NOT NULL );

-- Usuários 
CREATE TABLE IF NOT EXISTS public.Usuarios ( ID_Usuario SERIAL PRIMARY KEY, ID_Pessoa INT NOT NULL, FOREIGN KEY (ID_Pessoa) REFERENCES public.Pessoas(ID_Pessoa) );

--  Artistas 
CREATE TABLE IF NOT EXISTS public.Artistas ( ID_Artista SERIAL PRIMARY KEY, Nome_Artista VARCHAR(100) UNIQUE NOT NULL, ID_Pessoa INT NOT NULL, FOREIGN KEY (ID_Pessoa) REFERENCES public.Pessoas(ID_Pessoa) );

-- Músicas 
CREATE TABLE IF NOT EXISTS public.Musicas ( ID_Musica SERIAL PRIMARY KEY, Nome_Musica VARCHAR(100) NOT NULL, ID_Artista INT NOT NULL, FOREIGN KEY (ID_Artista) REFERENCES public.Artistas(ID_Artista) );

-- Playlists 
CREATE TABLE IF NOT EXISTS public.Playlists ( ID_Playlist SERIAL PRIMARY KEY, Nome_Playlist VARCHAR(100) NOT NULL, ID_Usuario INT NOT NULL, FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario), UNIQUE (ID_Usuario, Nome_Playlist) );

-- associação entre Playlists e Músicas 
CREATE TABLE IF NOT EXISTS public.Playlist_Musicas ( ID_Playlist INT NOT NULL, ID_Musica INT NOT NULL, PRIMARY KEY (ID_Playlist, ID_Musica), FOREIGN KEY (ID_Playlist) REFERENCES public.Playlists(ID_Playlist), FOREIGN KEY (ID_Musica) REFERENCES public.Musicas(ID_Musica) );

-- Histórico de Pesquisa 
CREATE TABLE IF NOT EXISTS public.Historico_Pesquisa ( ID_Historico SERIAL PRIMARY KEY, ID_Usuario INT NOT NULL, Termo_Pesquisa VARCHAR(100) NOT NULL, Data_Pesquisa TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario) );

-- Músicas Curtidas 
CREATE TABLE IF NOT EXISTS public.Musicas_Curtidas ( ID_Usuario INT NOT NULL, ID_Musica INT NOT NULL, PRIMARY KEY (ID_Usuario, ID_Musica), FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario), FOREIGN KEY (ID_Musica) REFERENCES public.Musicas(ID_Musica) );