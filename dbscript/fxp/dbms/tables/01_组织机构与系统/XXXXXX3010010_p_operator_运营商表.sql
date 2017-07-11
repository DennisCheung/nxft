--
-- ��Ӫ�̱��൱�ڻ��������չ
--
-- v1.0 2016.08.09
-- author��wing
--
-- ����������Ӫ��������չ  ��
-- �޸���ʷ��
--
--
--
-- Drop Table fxp.p_operator;
Create Table  fxp.p_operator (
-- +-----------------------------+--------------+-----------+
   foperator_id                  varchar2(32)   not null,   -- ��Ӫ��id
   foperator_name                varchar2(50)   not null,   -- ��Ӫ������
   -- foperator_fullname         varchar2(100)  not null,   -- ��Ӫ��ȫ��
   foperator_info                varchar2(1000),            -- ��Ӫ�̼��
   fregion_id                    varchar2(32)   not null,   -- ��������ID
   fregion_name                  varchar2(80)   not null,   -- ������������    
   --
   faddress                      varchar2(200),             -- ��ϸ��ַ
   foperator_desc                varchar2(256),             -- ��ע 
   --
   -- ��ͬ��Ϣ
   -- 
   -- fpersons_max               number(8)   default 0   not null, -- ���ͻ���
   -- fseats_max                 number(8)   default 0   not null, -- �����ϯ��
   -- fcontract_begin_date       date           not null,    -- ��ͬ��ʼʱ��
   -- fcontract_end_date         date           not null,    -- ��ͬ����ʱ��      
   --
   -- ��ϵ��
   --
   fcontact_person               varchar2(30),              -- ��ϵ������
   -- fcontact_duty              varchar2(30),              -- ��ϵ��ְλ
   fcontact_mobile               varchar2(30),              -- ��ϵ���ֻ�
   fcontact_email                varchar2(30),              -- ��ϵ������
   fdefault_region_id            varchar2(32),              -- Ĭ����������ID
   fdefault_region_name          varchar2(80),              -- Ĭ�������������� 
-- +-----------------------------+--------------+-----------+
   --
   -- ��ͨ
   --
   fcreate_date                  date default sysdate not null, -- �������ڣ�¼��ʱ��������ڣ� 
   fcreate_user_id               varchar2(32)  not null,   -- ��������Աid
   fcreate_user_name             varchar2(50)  not null,   -- ��������Ա����
   --
   -- ע��
   --
   fis_cancel                    char(1) default 'N'  not null, -- �Ƿ�ע��
   fcancel_reason                varchar2(60),              -- ע��ԭ��
   fcancel_date                  date,                      -- ע������ʱ��
   fcancel_user_id               varchar2(32),              -- ע������Աid   
   fcancel_user_name             varchar2(30),              -- ע������Ա����      
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                   -- �汾��
                                 default 0      not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_operator primary key (foperator_id)
);

--
-- ͬ���
--
--
-- ��Ȩ
--

--
-- ����
--


--
-- �޸���䣺
--

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10001', '���ݸ���', '���ݸ��������������޹�˾', '', '2951', '�㶫ʡ������', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10002', '˳�¸���', '˳�¸��������������޹�˾', '', '2994', '�㶫ʡ��ɽ��˳����', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

insert into p_operator (Foperator_ID, Foperator_NAME, Foperator_FULLNAME, Foperator_INFO, FREGION_ID, FREGION_NAME, FADDRESS, Foperator_DESC, FPERSONS_MAX, FSEATS_MAX, FCONTRACT_BEGIN_DATE, FCONTRACT_END_DATE, FCONTACT_PERSON, FCONTACT_DUTY, FCONTACT_MOBILE, FCONTACT_EMAIL, FCREATE_DATE, FCREATE_USER_ID, FCREATE_USER_NAME, FIS_CANCEL, FCANCEL_REASON, FCANCEL_DATE, FCANCEL_USER_ID, FCANCEL_USER_NAME, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('10003', '��ˮ����', '��ˮ���������������޹�˾', '', '4392', '�㶫ʡ��ɽ����ˮ��', '', '', 9999, 999, to_date('19-08-2015', 'dd-mm-yyyy'), to_date('19-08-2020', 'dd-mm-yyyy'), '', '', '', '', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', 'admin', 'N', '', null, '', '', 0, 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'), 'admin', to_date('19-08-2015', 'dd-mm-yyyy'));

commit;

