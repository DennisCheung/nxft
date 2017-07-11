--
-- ��ס�����
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_living_condi;
create table  fxp.p_living_condi (
-- +-----------------------------+--------------+-----------+
   fliving_condi_id              varchar2(32)   not null,   -- ��ס���ID
   fliving_condi_code            varchar2(8)    not null,   -- ��ס�������
   fliving_condi_gbcode          varchar2(32),              -- �������
   fliving_condi_name            varchar2(40)   not null,   -- ��ס�������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fliving_condi_desc            varchar2(256),             -- ��ע
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
   constraint pk_p_living_condi primary key (fliving_condi_id),
   constraint uk_p_living_condi_code unique (fliving_condi_code)
);

--
-- ͬ���
--

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '����ͬס', 'Y', 1.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '����Ůͬס', 'Y', 2.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '�����ݣ����ѣ���ס', 'Y', 3.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '�б�ķ', 'Y', 4.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '�¹�', 'Y', 5.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '����', 'Y', 6.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

insert into p_living_condi (FLIVING_CONDI_ID, FLIVING_CONDI_CODE, FLIVING_CONDI_GBCODE, FLIVING_CONDI_NAME, FISAVAILABLE, FORDERNUM, FLIVING_CONDI_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('99', '99', '99', '����', 'Y', 7.00, '', 0, 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('26-05-2015 20:16:42', 'dd-mm-yyyy hh24:mi:ss'));

commit;



