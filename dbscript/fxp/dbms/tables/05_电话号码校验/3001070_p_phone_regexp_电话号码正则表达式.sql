--
-- �绰����������ʽ
--
--
--
-- v1.0 2015.04.07
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_regexp ;
create table  fxp.p_phone_regexp (
-- +-----------------------------+--------------+-----------+
   fregexp_id                    varchar2(32)   not null,   -- ���ʽid
   fphone_regexp                 varchar2(100)  not null,   -- �绰������ʽ
   fphone_type_id                varchar2(32)   not null,   -- �绰����id
   fordernum                     number(6,2)    not null,   -- �����
   fregexp_desc                  varchar2(256),             -- ��ע
   --
   -- ��־
   --
-- +-----------------------------+--------------+-----------+
   fversion                      number(6)                  -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)               -- ������
                                 default 'admin' not null,
   flogcdate                     date                       -- ����ʱ��
                                 default sysdate not null,
   flogluby                      varchar2(32)               -- ����޸���
                                 default 'admin' not null,
   flogludate                    date                       -- ����޸�ʱ��
                                 default sysdate not null,
   floglaby                      varchar2(32)               -- ��������
                                 default 'admin' not null,
   flogladate                    date                       -- ������ʱ��
                                 default sysdate not null,
   --
   -- ������Ψһ��
   --
   constraint pk_p_phone_regexp primary key (fregexp_id),
   constraint uk_p_phone_regexp unique (fphone_regexp)
);

--
-- ͬ���
--

-- 1.�̻�

-- 1.1 ��2,3,5,6,7 ��ͷ

-- 1.1.1 ��2,3,5,6,7 ��ͷ + �������ŵĹ̻�

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('111', '^[2|3|5|6|7]', '1', 111, '��2,3,5,6,7 ��ͷ���ǲ������ŵĹ̻�', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.1.2  ��λ��;����+ ��2,3,5,6,7 ��ͷ�Ĺ̻�

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('112', '^0[1-9][0-9][2|3|5|6|7]', '1', 112, '��λ��;����+ ��2,3,5,6,7 ��ͷ�Ĺ̻�', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.1.3  ��λ��;����+ ��2,3,5,6,7 ��ͷ�Ĺ̻�

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('113', '^0[1-9][0-9][0-9][2|3|5|6|7]', '1', 113, '��λ��;����+ ��2,3,5,6,7 ��ͷ�Ĺ̻�', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 1.2 ��4,8 ��ͷ���ų�400��800 �绰��

-- 1.2.1  ��4,8 ��ͷ���ų�400��800 �绰��+ ����������
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('121', '^[4|8](?!00)', '1', 121, '��4,8 ��ͷ���������ŵĹ̻����ų�400��800 �绰��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.2.2  ��λ��;����+ ��4,8 ��ͷ���̻����ų�400��800 �绰��

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('122', '^0[1-9][0-9][4|8](?!00)', '1', 122, '��λ��;����+ ��4,8 ��ͷ���̻����ų�400��800 �绰��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 1.2.3 ��λ��;����+ ��4,8 ��ͷ���̻����ų�400��800 �绰��

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('123', '^0[1-9][0-9][0-9][4|8](?!00)', '1', 123, '��λ��;����+ ��4,8 ��ͷ���̻����ų�400��800 �绰��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 2.�ֻ�

-- 2.1  13X,15X,18X

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('201', '^1[3|5|8][0-9]', '2', 201, '13X,15X,18X �ֻ�����', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 2.2  145,147,170,176,177
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('202', '^1[45|47|70|76|77]', '2', 202, '13X,14X,15X,17X,18X �ֻ�����', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 3. 400��800�绰

insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('301', '^[4|8]00', '3', 301, '400��800��ͷ��400��800�绰', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4. �ط��绰

-- 4.1 1��ͷ��λ�ط���

-- 4.1.1  ��������1��ͷ��λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('411', '^1[1|2]\d{1}$', '4', 411, '1��ͷ��λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 4.1.2  ��λ��;����+ 1��ͷ��λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('412', '^0[1-9][0-9]1[1|2]\d{1}$', '4', 412, '��λ��;����+ 1��ͷ��λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


-- 4.1.3 ��λ��;����+ 1��ͷ��λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('413', '^0[1-9][0-9][0-9]1[1|2]\d{1}$', '4', 413, '��λ��;����+ 1��ͷ��λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2 1��ͷ5λ�ط���

-- 4.2.1  �������� + 1��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('421', '^(10|11|12|16|17)\d{3}$', '4', 421, '�������� + 1��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2.2  ��λ��;���� + 1��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('422', '^0[1-9][0-9](10|11|12|16|17)\d{3}$', '4', 422, '��λ��;���� + 1��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.2.3  ��λ��;���� + 1��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('423', '^0[1-9][0-9][0-9](10|11|12|16|17)\d{3}$', '4', 423, '��λ��;���� + 1��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3 9��ͷ5λ�ط���

-- 4.3.1 �������� + 9��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('431', '^(95|96)\d{3}$', '4', 431, '�������� + 9��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3.2 ��λ��;���� + 9��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('432', '^0[1-9][0-9](95|96)\d{3}$', '4', 432, '��λ��;���� + 9��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

-- 4.3.3 ��λ��;���� + 9��ͷ5λ�ط���
insert into fxp.p_phone_regexp (FREGEXP_ID, FPHONE_REGEXP, FPHONE_TYPE_ID, FORDERNUM, FREGEXP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('433', '^0[1-9][0-9][0-9](95|96)\d{3}$', '4', 433, '��λ��;���� + 9��ͷ5λ�ط���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;

