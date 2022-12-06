CREATE TABLE dog(
	dogId NUMBER PRIMARY KEY,
	dogKind VARCHAR2(21),
	dogPrice NUMBER,
	dogImage VARCHAR2(20),
	dogCountry VARCHAR2(21),
	dogHeight NUMBER,
	dogWeight NUMBER,
	dogContent VARCHAR2(400),
	dogReadCount NUMBER
)

CREATE SEQUENCE dog_seq;

INSERT INTO dog VALUES(dog_seq.nextval, '푸들', 10000, 'pu', '프랑스', 1, 20, '푸들은 귀엽다', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '비글', 20000, 'bi', '독일', 2, 40, '비글은 사납다', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '요크셔테리어', 30000, 'york', '영국', 1, 10, '요크셔테리어. 랄맞다.', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '불독', 120000, 'bul', '독일', 2, 60, '건들면 큰일난다', 0);
COMMIT