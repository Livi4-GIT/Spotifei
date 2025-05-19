# Spotifei
Livia Lirio Severi   R.A 22.124.024-5


_____________CODIGO PARA CRIAR O BD_________________
Create Table if not exists public.Pessoas(
	ID_Pessoas SERIAL Primary Key,
	Nome VARCHAR(100) not null,
	Email VARCHAR(200) unique not null,
	idade INT
);

Create Table if not exists public.Usuarios(
	ID_Usuario SERIAL Primary Key,
	Nome_Usuario VARCHAR(100) not null,
	Senha VARCHAR(200) not null,
	ID_Pessoas INT not null,
	Foreign key (ID_Pessoas) References Pessoas(ID_Pessoas)
);

Create Table if not exists public.Artista(
	ID_Artista SERIAL Primary Key,
	Nome_Artistico VARCHAR(100) not null,
	Informacoes_ART VARCHAR(600),
	ID_Pessoas INT not null,
	Foreign key (ID_Pessoas) References Pessoas(ID_Pessoas)
);

Create Table if not exists public.Musica(
	ID_Musica SERIAL Primary Key,
	Nome_Musica VARCHAR(100) not null,
	Genero_Musica VARCHAR(50) not null,
	ID_Artista INT not null,
	Foreign key (ID_Artista) References Artista(ID_Artista)
);

Create Table if not exists public.Playlist(
	ID_Playlist SERIAL Primary Key,
	Nome_Playlist VARCHAR(100) not null,
	ID_Musica INT not null,
	ID_Usuario INT not null,
	Foreign key (ID_Musica) References Musica(ID_Musica)
);

ALTER TABLE public.Playlist
ADD CONSTRAINT fk_playlist_usuario
FOREIGN KEY (ID_Usuario)
REFERENCES public.Usuarios(ID_Usuario);