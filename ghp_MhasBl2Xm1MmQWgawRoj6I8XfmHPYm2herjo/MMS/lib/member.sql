--------PRIMARY KEY : UNIQUE + NOT NULL ---------

DROP TABLE member PURGE;

CREATE TABLE member(
	memberId VARCHAR2(20) PRIMARY KEY,
	memberName VARCHAR2(20) NOT NULL,
	memberAge NUMBER NOT NULL,
	memberEmail VARCHAR2(30) NOT NULL,
	memberGender CHAR(1) NOT NULL,
	memberBirthday DATE NOT NULL
	
)

ALTER TABLE member
ADD memberHomePage VARCHAR2(20);

-- 1.
INSERT INTO member VALUES('bbb','����',25,'bbb@cu.ac.kr','M',sysdate,null);

-- 2.
INSERT INTO member (memberId, memberName, memberAge, memberEmail, memberGender, memberBirthday) 
VALUES('ccc','������',25,'bbb@cu.ac.kr', 'M','1999-01-01');

--SELECT memberAge *2 , memberName FROM member;

--SELECT count(memberAge) FROM member;

SELECT * FROM member WHERE memberId = 'aaa';

SELECT * FROM member
WHERE memberAge <= 20 OR memberAge <= 40;


-- NULL ����, ����:is, ���� �ʴ�:is not

SELECT * FROM member
WHERE memberHomePage = 'https://www.wpgus.co';

-- BETWEEN AND
SELECT * FROM member
WHERE memberAge between 20 and 40;

-- ����Ʈ IN
SELECT * FROM member
WHERE memberName IN('������','jehyun');

-- ���Ϲ��� �� (_, %s)
-- _: ���� �ϳ�
-- % : �ƹ��� ���ڰ� �ȿ͵� �ǰ�, � ���ڰ� �͵� ������� ����

SELECT * FROM member
WHERE memberEmail LIKE '@cu.ac.kr'

SELECT * FROM member
WHERE memberEmail LIKE '%@cu.ac.kr'


-- OREDER BY
SELECT * FROM member
WHERE memberEmail LIKE '%@cu.ac.kr'
ORDER BY memberId, memberAge DESC;

--DISTINCT : �ߺ��� ����
SELECT DISTINCT memberGender FROM member;

-- ��Ī
SELECT memberAge * 2 AS doubleAge FROM member;

DROP TABLE member1 PURGE;

CREATE TABLE member1(
	memberId VARCHAR2(20) PRIMARY KEY,
	memberName VARCHAR2(20) NOT NULL,
	memberAge NUMBER NOT NULL,
	memberAddr VARCHAR2(50) NOT NULL,
	memberEmail VARCHAR2(50) NOT NULL,
	memberGender CHAR(1) NOT NULL,
	memberGeneration NUMBER NOT NULL
)















