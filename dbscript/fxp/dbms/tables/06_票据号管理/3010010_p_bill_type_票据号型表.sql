--
-- Ʊ�ݺ����ͱ�
-- 
-- 
--
-- v1.0 2015.09.09
-- author��wing
--
-- �޸���ʷ��
-- 
-- 
-- drop table fxp.p_bill_type ;
create table  fxp.p_bill_type (
-- +-----------------------------+--------------+-----------+
   fbill_type_id                 varchar2(32)   not null,   -- Ʊ������id  
   fbill_type_code               varchar2(30)   not null,   -- Ʊ�����ʹ���
   fbill_type_name               varchar2(40)   not null,   -- Ʊ����������
   fbill_class                   varchar2(30)   not null,   -- Ʊ�ݺŷ���    GLOBAL ȫ��  ORG  ����   SITE  �̻�  USER  ����Ա
   fisavailable                  char(1)        not null,   -- �Ƿ���Ч��Y/N
   fbill_type_desc               varchar2(256),             -- ��ע   
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
   constraint pk_p_bill_type primary key (fbill_type_id),
   constraint uk_p_bill_type_code unique (fbill_type_code)
);

--
-- ͬ���
--

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('PERSON_CODE', 'PERSON_CODE', '�ͻ����', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('FAMILY_CODE', 'FAMILY_CODE', '��ͥ���', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('EMP_CODE', 'FEMP_CODE', 'ְ������', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ORG_ID', 'FORG_ID', '��������', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('DEPT_ID', 'FDEPT_ID', '���ű���', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('SITE_CODE', 'SITE_CODE', '�̻�����', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('ACCOUNT_NO', 'ACCOUNT_NO', '�˻�����', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_SVCNOTE_NO', 'HG_SVCNOTE_NO', '����ָ�����񵥺�', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HG_REPORT_NO', 'HG_REPORT_NO', '����ָ�����浥��', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('HM_REQNOTE_NO', 'HM_REQNOTE_NO', '����ָ�����뵥��', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_RED_SVCNOTE_NO', 'CALL_RED_SVCNOTE_NO', '��ȷ��񵥺�', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_GREEN_SVCNOTE_NO', 'CALL_GREEN_SVCNOTE_NO', '��ȷ��񵥺�', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

insert into p_bill_type (FBILL_TYPE_ID, FBILL_TYPE_CODE, FBILL_TYPE_NAME, FBILL_CLASS, FISAVAILABLE, FBILL_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('CALL_CONSULT_SVCNOTE_NO', 'CALL_CONSULT_SVCNOTE_NO', '��ѯ���񵥺�', 'GLOBAL', 'Y', '', 0, 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'), 'admin', to_date('09-09-2015', 'dd-mm-yyyy'));

commit;
