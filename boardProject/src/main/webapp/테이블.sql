create table board(
num NUMBER primary key , --�Խ��� �� ��ȣ
writer varchar(10) not null, -- �ۼ��� (ȸ�� ���̵�)
email varchar(30), -- �̸���
subject varchar(50) not null,-- ������
passwd varchar(12) not null,--��й�ȣ
reg_date timestamp(6) not null,--�ۼ���
readcount NUMBER default 0,--��ȸ��

ref NUMBER not null,-- �� �׷� ��ȣ
re_step NUMBER not null, -- ���� �׷쿡�� �� ��� ����
re_level NUMBER not null, -- ��� ����

content varchar2(4000) not null, -- �� ����
ip varchar(20) not null -- �ۼ��� ������
);

CREATE SEQUENCE board_seq;