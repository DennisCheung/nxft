--
-- �Ļ��̶�
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_edu_degree;
create table fxp.p_edu_degree (
-- +-----------------------------+--------------+-----------+
   fedu_degree_id                varchar2(32)   not null,   -- �Ļ��̶�ID
   fedu_degree_code              varchar2(8)    not null,   -- �Ļ��̶ȴ���
   fedu_degree_gbcode            varchar2(32),              -- �������
   fedu_degree_name              varchar2(40)   not null,   -- �Ļ��̶�����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fedu_degree_desc              varchar2(256),             -- ��ע
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
   constraint pk_p_edu_degree primary key (fedu_degree_id),
   constraint uk_p_edu_degree_code unique (fedu_degree_code)
   );

--
-- ͬ���
--

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '����', 'Y', 1, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '��ר', 'Y', 2, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '��ר', 'Y', 3, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '����', 'Y', 4, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '˶ʿ', 'Y', 5, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '��ʿ', 'Y', 6, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', '����', 'Y', 7, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', 'Сѧ', 'Y', 8, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

insert into p_edu_degree (FEDU_DEGREE_ID, FEDU_DEGREE_CODE, FEDU_DEGREE_GBCODE, FEDU_DEGREE_NAME, FISAVAILABLE, FORDERNUM, FEDU_DEGREE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '��ä�����ä', 'Y', 9, '', 0, 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'), 'admin', to_date('08-07-2015', 'dd-mm-yyyy'));

commit;
