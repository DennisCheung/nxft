--
-- ������
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_citizenship;
create table  fxp.p_citizenship (
-- +-----------------------------+--------------+-----------+
   fcitizenship_id               varchar2(32)   not null,   -- ����ID
   fcitizenship_code             varchar2(8)    not null,   -- ��������
   fcitizenship_gbcode           varchar2(32),              -- �������
   fcitizenship_name             varchar2(40)   not null,   -- ��������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fcitizenship_desc             varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date default sysdate not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date default sysdate not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date default sysdate not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_citizenship primary key (fcitizenship_id),
   constraint uk_p_citizenship_code unique (fcitizenship_code)
   );

--
-- ͬ���
--

insert into p_citizenship (FCITIZENSHIP_ID, FCITIZENSHIP_CODE, FCITIZENSHIP_GBCODE, FCITIZENSHIP_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FCITIZENSHIP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '�й�', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_citizenship (FCITIZENSHIP_ID, FCITIZENSHIP_CODE, FCITIZENSHIP_GBCODE, FCITIZENSHIP_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FCITIZENSHIP_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '���', 'Y', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;