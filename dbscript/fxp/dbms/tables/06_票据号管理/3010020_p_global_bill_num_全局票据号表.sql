--
-- ȫ��Ʊ�ݺ�
-- 
-- 
--
-- v1.0 2015.09.09
-- author��wing
--
-- �޸���ʷ��
-- 
-- 
-- drop table fxp.p_global_bill_num ;
create table  fxp.p_global_bill_num (
-- +-----------------------------+--------------+-----------+
   fbill_type_id                 varchar2(32)   not null,   -- Ʊ������id  
   --
   -- ���к�
   --
   fseq_name                     varchar2(50)   not null,   -- ������
   fseq_init_mode                varchar2(20)   not null,   -- ���кų�ʼ��ģʽ   ÿ�죨EVERYDAY�� ÿ�� EVERYMONTH, ÿ�� EVERYYEAR  �Ӳ� UNLIMITED
   fseq_init_sysdate             date           not null,   -- ���к�ִ�г�ʼ��ʱ��ϵͳ����
   fseq_init_val                 number(12)     default 1 not null,  -- ����.��ʼ��ʱ��ֵ    sn = nextval - fseq_init_val + fseq_start_val
   fseq_start_val                number(9)      default 1 not null,  -- ����.��ʼֵ
   --
   -- �����ʽ
   --   
   fsn_len                       number(2)      not null,   -- �����������
   foutput_expression            varchar2(80)   not null,   -- Ʊ�ݺ������ʽ
   fglobal_bill_desc             varchar2(256),             -- ��ע
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   
                                 default 'admin' not null,   -- ������
   flogcdate                     date 
                                 default sysdate 
                                 not null,   -- ����ʱ��
   flogluby                      varchar2(32)   
                                 default 'admin' 
                                 not null,   -- ����޸���
   flogludate                    date 
                                 default sysdate 
                                 not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   
                                 default 'admin' 
                                 not null,   -- ��������
   flogladate                    date 
                                 default sysdate 
                                 not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_global_bill_num primary key (fbill_type_id),
   constraint uk_pk_p_global_bill_num unique (fseq_name)
);

--
-- ͬ���
--

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('PERSON_CODE', 'SEQ_PERSON_CODE', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '00000000', 8, '<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('FAMILY_CODE', 'SEQ_FAMILY_CODE', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '00000000', 8, '<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('EMP_CODE', 'SEQ_EMP_CODE', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '000000', 6, '1<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ORG_ID', 'SEQ_ORG_ID', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '000000', 6, '1<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('DEPT_ID', 'SEQ_DEPT_ID', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '000000', 6, '2<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('SITE_CODE', 'SEQ_SITE_CODE', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '000000', 6, '1<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ACCOUNT_NO', 'SEQ_ACCOUNT_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '00000000', 8, '<sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_SVCNOTE_NO', 'SEQ_HG_SVCNOTE_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_REPORT_NO', 'SEQ_HG_REPORT_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HM_REQNOTE_NO', 'SEQ_HM_REQNOTE_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_RED_SVCNOTE_NO', 'SEQ_CALL_RED_SVCNOTE_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_GREEN_SVCNOTE_NO', 'SEQ_CALL_GREEN_SVCNOTE_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_global_bill_num (FBILL_TYPE_ID, FSEQ_NAME, FSEQ_INIT_MODE, FSEQ_INIT_SYSDATE, FSEQ_INIT_VAL, FSEQ_START_VAL, FSN_FORMAT, FSN_LEN, FOUTPUT_EXPRESSION, FGLOBAL_BILL_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_CONSULT_SVCNOTE_NO', 'SEQ_CALL_CONSULT_SVCNOTE_NO', 'UNLIMITED', to_date('09-09-2015', 'dd-mm-yyyy'), 1, 1, '0000', 4, '<sysdate.yymmdd><sn>', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

commit;

create sequence HBCS.SEQ_PERSON_CODE minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_FAMILY_CODE minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_EMP_CODE minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_ORG_ID minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_DEPT_ID minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_SITE_CODE minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_ACCOUNT_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.SEQ_HG_SVCNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.HG_SVCNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.HG_REPORT_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.HM_REQNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.CALL_RED_SVCNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.CALL_GREEN_SVCNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
create sequence HBCS.CALL_CONSULT_SVCNOTE_NO minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 10;
