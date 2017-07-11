--
-- ��ͷ�����Դ��
--
-- v1.0 2017.05.05
-- author��wing
--
-- ˵��
--
-- 
-- �޸���ʷ��
--
-- drop table nxft.sis_service_resource;
create table  nxft.sis_service_resource (
-- +-----------------------------+--------------+-----------+
   fsis_id                       varchar2(32)   not null,   -- ͳ��id
   fcircle_id                    varchar2(32)   not null,   -- ����Ȧid
   findicator_id                 varchar2(32)   not null,   -- ͳ��ָ��ID(����) 
   findicator_name               varchar2(60)   not null,   -- ͳ��ָ������
   fquantity                     number(9,0)    not null,   -- ����
   fdata_desc                    varchar2(256),             -- ��ע
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
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
   constraint pk_sis_service_resource primary key (fsis_id),
   constraint uk_sis_service_resource unique (fcircle_id,findicator_id)
   --
   -- Լ��
   --
);

--
-- ͬ���
--

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00001', '10001', 'ASSIST_MEAL_WORKER', '���͹�����Ա', 3, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00002', '10001', 'ASSIST_MEAL_VOLUNTEER', '����־Ը��', 10, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00003', '10001', 'KITCHEN', '�������', 1, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));

insert into nxft.sis_service_resource (FSIS_ID, FCIRCLE_ID, FINDICATOR_ID, FINDICATOR_NAME, FQUANTITY, FDATA_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('00004', '10001', 'ASSIST_MEAL_SITE', '���͵�', 3, '', 0, 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'), 'admin', to_date('06-05-2017', 'dd-mm-yyyy'));



--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸����
--
