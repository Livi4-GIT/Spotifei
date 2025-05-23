-- Tabela de Pessoas
CREATE TABLE IF NOT EXISTS public.Pessoas (
    ID_Pessoa SERIAL PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Senha VARCHAR(200) NOT NULL -- REMOVIDO UNIQUE
);

-- Tabela de Usuários
CREATE TABLE IF NOT EXISTS public.Usuarios (
    ID_Usuario SERIAL PRIMARY KEY,
    ID_Pessoa INT NOT NULL,
    FOREIGN KEY (ID_Pessoa) REFERENCES public.Pessoas(ID_Pessoa)
);

-- Tabela de Artistas
CREATE TABLE IF NOT EXISTS public.Artistas (
    ID_Artista SERIAL PRIMARY KEY,
    Nome_Artista VARCHAR(100) UNIQUE NOT NULL,
    ID_Pessoa INT NOT NULL,
    FOREIGN KEY (ID_Pessoa) REFERENCES public.Pessoas(ID_Pessoa)
);

-- Tabela de Músicas
CREATE TABLE IF NOT EXISTS public.Musicas (
    ID_Musica SERIAL PRIMARY KEY,
    Nome_Musica VARCHAR(100) NOT NULL, -- REMOVIDO UNIQUE
    ID_Artista INT NOT NULL,
    FOREIGN KEY (ID_Artista) REFERENCES public.Artistas(ID_Artista)
);

-- Tabela de Playlists
CREATE TABLE IF NOT EXISTS public.Playlists (
    ID_Playlist SERIAL PRIMARY KEY,
    Nome_Playlist VARCHAR(100) NOT NULL,
    ID_Usuario INT NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario),
    UNIQUE (ID_Usuario, Nome_Playlist) -- Nomes únicos por usuário
);

-- Tabela de associação entre Playlists e Músicas
CREATE TABLE IF NOT EXISTS public.Playlist_Musicas (
    ID_Playlist INT NOT NULL,
    ID_Musica INT NOT NULL,
    PRIMARY KEY (ID_Playlist, ID_Musica),
    FOREIGN KEY (ID_Playlist) REFERENCES public.Playlists(ID_Playlist),
    FOREIGN KEY (ID_Musica) REFERENCES public.Musicas(ID_Musica)
);

-- Tabela de Histórico de Pesquisa
CREATE TABLE IF NOT EXISTS public.Historico_Pesquisa (
    ID_Historico SERIAL PRIMARY KEY,
    ID_Usuario INT NOT NULL,
    Termo_Pesquisa VARCHAR(100) NOT NULL,
    Data_Pesquisa TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario)
);

-- Tabela de Músicas Curtidas
CREATE TABLE IF NOT EXISTS public.Musicas_Curtidas (
    ID_Usuario INT NOT NULL,
    ID_Musica INT NOT NULL,
    PRIMARY KEY (ID_Usuario, ID_Musica),
    FOREIGN KEY (ID_Usuario) REFERENCES public.Usuarios(ID_Usuario),
    FOREIGN KEY (ID_Musica) REFERENCES public.Musicas(ID_Musica)
);