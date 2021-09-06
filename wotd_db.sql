CREATE SEQUENCE Users_seq START 1 INCREMENT 1;
CREATE SEQUENCE Admins_seq START 1 INCREMENT 1;
CREATE SEQUENCE Words_seq START 1 INCREMENT 1;
CREATE SEQUENCE PrizeList_seq START 1 INCREMENT 1;
CREATE SEQUENCE Campaigns_seq START 1 INCREMENT 1;
CREATE SEQUENCE Prize_seq START 1 INCREMENT 1;
CREATE TABLE Users(
    Id INT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('Users_seq'),
    Username VARCHAR(30) NOT NULL,
    Email VARCHAR(50),
    BirthDate VARCHAR(10)
);
CREATE TABLE Admins(
    Id INT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('Admins_seq'),
    Username VARCHAR(30) NOT NULL,
    Password VARCHAR(100) NOT NULL
);
CREATE TABLE Words(
    Id INT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('Words_seq'),
    Word VARCHAR(30) NOT NULL,
    Is_word_of_the_day BOOLEAN NOT NULL
);
CREATE TABLE PrizeLists(
    Id INT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('PrizeList_seq'),
    isActive BOOLEAN NOT NULL
);
CREATE TABLE Prizes(
  PrizeListId INT NOT NULL,
  PrizeId INT NOT NULL DEFAULT NEXTVAL('Prize_seq'),
  Prize VARCHAR(30) NOT NULL,
  TimesSelected INT NOT NULL,
  CONSTRAINT Fk_PrizeList FOREIGN KEY(PrizeListId) REFERENCES PrizeLists(Id),
  PRIMARY KEY(PrizeListId, PrizeId)
);
CREATE TABLE Campaigns(
    Id INT PRIMARY KEY NOT NULL DEFAULT NEXTVAL('Campaigns_seq'),
    Name VARCHAR(30) NOT NULL,
    isactive BOOLEAN NOT NULL
);
CREATE TABLE Reports(
    CampaignId INT PRIMARY KEY ,
    NoUsers INT NOT NULL,
    NoCorrect INT NOT NULL,
    NoFail INT NOT NULL,
    CONSTRAINT Fk_CampaingId FOREIGN KEY(CampaignId) REFERENCES Campaigns(Id)
);
--To avoid errors alter sequences after tables have been created
ALTER SEQUENCE Users_seq OWNED BY Users.Id;
ALTER SEQUENCE Admins_seq OWNED BY Admins.Id;
ALTER SEQUENCE Words_seq OWNED BY Words.Id;
ALTER SEQUENCE PrizeList_seq OWNED BY PrizeLists.Id;
ALTER SEQUENCE Campaigns_seq OWNED BY Campaigns.Id;
ALTER SEQUENCE Prize_seq OWNED BY Prizes.PrizeId;

--Insert Test Data
INSERT INTO Admins(Username, Password) VALUES ('Ilija','1234');
INSERT INTO Words(Word, Is_word_of_the_day) VALUES ('Jelena',TRUE);
INSERT INTO Words(word, is_word_of_the_day) VALUES ('Ilija',FALSE);
INSERT INTO Campaigns(name, isactive) VALUES ('Campaign 1', TRUE);
INSERT INTO Campaigns(name, isactive) VALUES ('Campaign 2', FALSE);
INSERT INTO Reports(campaignid, nousers, nocorrect, nofail) VALUES (1,0,0,0);
INSERT INTO PrizeLists(isActive) VALUES (TRUE);
INSERT INTO PrizeLists(isActive) VALUES (FALSE);
INSERT INTO Prizes(prizelistid, prize, timesselected) VALUES (1 'Prize 1', 0);
INSERT INTO Prizes(prizelistid, prize, timesselected) VALUES (1 'Prize 2', 0);
INSERT INTO Prizes(prizelistid, prize, timesselected) VALUES (1 'Prize 3', 0);
