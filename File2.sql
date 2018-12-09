CREATE TABLE brand(
        idGame INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(70) NOT NULL,
        fond_year SMALLINT(4),
        jenre VARCHAR(200),
        developer VARCHAR(50),
        platforms VARCHAR(100),
        PRIMARY KEY (idGame)
);

CREATE TABLE  model(
        idModel INT NOT NULL AUTO_INCREMENT,
        idGame INT NOT NULL,
        os VARCHAR(100) NOT NULL,
        processor VARCHAR(100),
        ram SMALLINT(4),
        hdd SMALLINT(3),
        video_card VARCHAR(100),
        PRIMARY KEY (idModel),
        FOREIGN KEY (idGame) REFERENCES head_info(id_game) ON DELETE CASCADE
);