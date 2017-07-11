--
-- ����״����
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_marriage;
create table  fxp.p_marriage (
-- +-----------------------------+--------------+-----------+
   fmarriage_id                  varchar2(32)   not null,   -- ����״��ID
   fmarriage_code                varchar2(8)    not null,   -- ����״������
   fmarriage_gbcode              varchar2(32),              -- �������
   fmarriage_name                varchar2(40)   not null,   -- ����״������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fmarriage_desc                varchar2(256),             -- ��ע
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
   constraint pk_p_marriage primary key (fmarriage_id),
   constraint uk_p_marriage_code unique (fmarriage_code)
);

--
-- ͬ���
--

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', 'δ��', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '�ѻ�', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

insert into p_marriage (FMARRIAGE_ID, FMARRIAGE_CODE, FMARRIAGE_GBCODE, FMARRIAGE_NAME, FISAVAILABLE, FORDERNUM, FMARRIAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '����', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy') );

commit;

