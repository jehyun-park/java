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
INSERT INTO member VALUES('bbb','제현',25,'bbb@cu.ac.kr','M',sysdate,null);

-- 2.
INSERT INTO member (memberId, memberName, memberAge, memberEmail, memberGender, memberBirthday) 
VALUES('ccc','가나다',25,'bbb@cu.ac.kr', 'M','1999-01-01');

--SELECT memberAge *2 , memberName FROM member;

--SELECT count(memberAge) FROM member;