--
-- ȫ��ͳһ���ַ���绰���Ǽ��ط��绰����
--
--
--
-- v1.0 2015.03.24
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_special;
create table  fxp.p_phone_special (
-- +-----------------------------+--------------+-----------+
   fphone_number                 varchar2(30)   not null,   -- �绰����
   fphone_desc                   varchar2(256),             -- ��ע
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
   constraint pk_p_phone_special primary key (fphone_number)
);

--
-- ͬ���
--

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('110', '�񾯡��˾�', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('112',  '����', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('12110',  '�������ű���', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('120',  '��������', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('119',  '��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('95119', 'ɭ�ֻ�', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('117',  '����ʱ��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('121',  '����Ԥ��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('122',  '��ͨ�¹ʡ�����', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11183', 'EMS', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11185', '����ҵ��', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('160', '��Ѷ', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_special (FPHONE_NUMBER, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('12349', '������������', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
