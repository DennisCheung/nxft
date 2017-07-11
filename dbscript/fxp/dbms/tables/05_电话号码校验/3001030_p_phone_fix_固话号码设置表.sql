--
-- �̻��������ñ�
--
--
-- v1.0 2015.03.25
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_phone_fix ;
create table  fxp.p_phone_fix (
-- +-----------------------------+--------------+-----------+
   farea_code                    varchar2(20)   not null,   -- ����
   --
   -- ��ʽ����
   --
   ftotal_length                 number(2)      not null,   -- �����ܳ��ȣ������ţ�
   fpnone_desc                   varchar2(256),             -- ��ע
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
   constraint pk_p_phone_fix primary key (farea_code)
);

--
-- ͬ���
--

insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('020', 11, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0757', 12, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into fxp.p_phone_fix (FAREA_CODE, FTOTAL_LENGTH, FPNONE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('0758', 11, '',0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


commit;

