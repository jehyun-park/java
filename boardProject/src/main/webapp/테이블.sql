create table board(
num NUMBER primary key , --게시판 글 번호
writer varchar(10) not null, -- 작성자 (회원 아이디)
email varchar(30), -- 이메일
subject varchar(50) not null,-- 글제목
passwd varchar(12) not null,--비밀번호
reg_date timestamp(6) not null,--작성일
readcount NUMBER default 0,--조회수

ref NUMBER not null,-- 글 그룹 번호
re_step NUMBER not null, -- 같은 그룹에서 글 출력 순서
re_level NUMBER not null, -- 답글 레벨

content varchar2(4000) not null, -- 글 내용
ip varchar(20) not null -- 작성자 아이피
);

CREATE SEQUENCE board_seq;