--
-- �Ӽ����ϵ���������
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_hbc_disease;
create table  fxp.p_hbc_disease (
-- +-----------------------------+--------------+-----------+
   fdisease_id                   varchar2(32)   not null,   -- ��������ID
   fdisease_code                 varchar2(8)    not null,   -- ������������
   fdisease_gbcode               varchar2(32),              -- �������
   fdisease_name                 varchar2(40)   not null,   -- ��������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fdisease_desc                 varchar2(256),             -- ��ע
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
   constraint pk_p_hbc_disease primary key (fdisease_id),
   constraint uk_p_hbc_disease_code unique (fdisease_code)
);

--
-- ͬ���
--

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', 'θ��', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '����', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '����', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', 'ƶѪ', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', 'ʹ��', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '�Բ�', 'N', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('07', '07', '07', '����', 'N', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('08', '08', '08', '��Ѫѹ', 'N', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('09', '09', '09', '������', 'N', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10', '10', '10', '���Ĳ�', 'N', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('11', '11', '11', '���ಡ', 'N', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('12', '12', '12', '��ﲡ', 'N', 'Y', 12, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('13', '13', '13', '�ؽ���', 'N', 'Y', 13, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('14', '14', '14', 'Ƥ����', 'N', 'Y', 14, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('15', '15', '15', '�ļ�����', 'N', 'Y', 15, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('16', '16', '16', '����մ�', 'N', 'Y', 16, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('17', '17', '17', '����', 'N', 'Y', 17, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_hbc_disease (FDISEASE_ID, FDISEASE_CODE, FDISEASE_GBCODE, FDISEASE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FDISEASE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('99', '99', '99', '����', 'Y', 'Y', 15, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;



