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

INSERT INTO dog VALUES(dog_seq.nextval, 'Ǫ��', 10000, 'pu', '������', 1, 20, 'Ǫ���� �Ϳ���', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '���', 20000, 'bi', '����', 2, 40, '����� �糳��', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '��ũ���׸���', 30000, 'york', '����', 1, 10, '��ũ���׸���. ���´�.', 0);
INSERT INTO dog VALUES(dog_seq.nextval, '�ҵ�', 120000, 'bul', '����', 2, 60, '�ǵ�� ū�ϳ���', 0);
COMMIT