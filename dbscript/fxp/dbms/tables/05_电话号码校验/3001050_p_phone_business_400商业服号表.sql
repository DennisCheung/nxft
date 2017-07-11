--
-- 400��800��ҵ�绰����
--
--
--
-- v1.0 2015.03.24
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_business;
create table  fxp.p_phone_business (
-- +-----------------------------+--------------+-----------+
   fnumber_prefix                varchar2(30)   not null,   -- �绰������ͷ
   ftotal_length                 number(2)      not null,   -- �����ܳ���
   fphone_desc                   varchar2(256),             -- ��ע
   --
   -- ��־
   --
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
   constraint pk_p_phone_business primary key (fnumber_prefix)
);

--
-- ͬ���
--

insert into fxp.p_phone_business (FNUMBER_PREFIX, FTOTAL_LENGTH, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('400', 10, '400�绰', 0, 'admin', sysdate , 'admin', sysdate , 'admin', sysdate );

insert into fxp.p_phone_business (FNUMBER_PREFIX, FTOTAL_LENGTH, FPHONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('800', 10, '800�绰', 0, 'admin', sysdate , 'admin', sysdate , 'admin', sysdate );


commit;
