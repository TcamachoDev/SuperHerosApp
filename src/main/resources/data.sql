CREATE TABLE SUPERHERO (
    ID NUMBER(38) not null primary key,
    NAME_HEROE VARCHAR2(255),
    SUPERPOWER VARCHAR2(255)

);
COMMIT;

INSERT INTO SUPERHERO (ID, NAME_HEROE, SUPERPOWER) VALUES (1, 'SUPERMAN', 'SUN FORCE');
INSERT INTO SUPERHERO (ID, NAME_HEROE, SUPERPOWER) VALUES (2, 'SPIDERMAN', 'SWING AT HIGH SPEED');
INSERT INTO SUPERHERO (ID, NAME_HEROE, SUPERPOWER) VALUES (3, 'FLASH', 'REGENERATIVE CAPACITY');
INSERT INTO SUPERHERO (ID, NAME_HEROE, SUPERPOWER) VALUES (4, 'BATMAN', 'SLIDE THROUGH THE AIR');

COMMIT;