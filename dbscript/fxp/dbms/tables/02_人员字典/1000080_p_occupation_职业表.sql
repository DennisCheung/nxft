--
-- ְҵ��
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- drop table fxp.p_occupation;
create table  fxp.p_occupation (
-- +-----------------------------+--------------+-----------+
   foccupation_id                varchar2(32)   not null,   -- ְҵID
   foccupation_code              varchar2(30)   not null,   -- ְҵ����
   foccupation_gbcode            varchar2(32),              -- �������
   foccupation_name              varchar2(40)   not null,   -- ְҵ����
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   foccupation_desc              varchar2(256),             -- ��ע
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
   constraint pk_p_occupation primary key (foccupation_id),
   constraint uk_p_occupation_code unique (foccupation_code)
);

--
-- ͬ���
--
-- ְҵ����ǳ�������ա��й��������ٱ��չɷ����޹�˾ְҵ�����

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00', '00', '00', 'һ��������Ա','N', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', 'ũ��ҵ','N', 'Y', 2, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '��ҵ','N', 'Y', 3, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', 'ľ��ɭ��ҵ','N', 'Y', 4, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '��ҵ��ʯҵ','N', 'Y', 5, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '��ͨ����ҵ','N', 'Y', 6, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '����ҵ','N', 'Y', 7, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('07', '07', '07', '��������ҵ','N', 'Y', 8, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('08', '08', '08', '����ҵ','N', 'Y', 9, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('09', '09', '09', '���Ź��','N', 'Y', 10, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10', '10', '10', '��������', 'N','Y', 11, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('11', '11', '11', 'Ӱ������ҵ','N', 'Y', 12, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('12', '12', '12', '�ƽ��Ļ�','N', 'Y', 13, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('13', '13', '13', '�ڽ�','N', 'Y', 14, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('14', '14', '14', '������ҵ����','N', 'Y', 15, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('15', '15', '15', '��ҵ','N', 'Y', 16, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('16', '16', '16', '���ڱ���ҵ','N', 'Y', 17, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('17', '17', '17', '����ҵ','N', 'Y', 18, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('18', '18', '18', '��ͥ����','N', 'Y', 19, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('19', '19', '19', '�ΰ���Ա����','N', 'Y', 20, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('20', '20', '20', '����','N', 'Y', 21, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_occupation (FOCCUPATION_ID, FOCCUPATION_CODE, FOCCUPATION_GBCODE, FOCCUPATION_NAME,fisother, FISAVAILABLE, FORDERNUM, FOCCUPATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('21', '21', '21', '����','Y', 'Y', 22, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

commit;