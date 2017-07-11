--
-- �ͻ����ͱ�
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_customer_type;
create table  fxp.p_customer_type (
-- +-----------------------------+--------------+-----------+
   fcustomer_type_id             varchar2(32)   not null,   -- �ͻ�����ID
   fcustomer_type_code           varchar2(30)   not null,   -- �ͻ����ʹ���
   fcustomer_type_gbcode         varchar2(32),              -- �������
   fcustomer_type_name           varchar2(40)   not null,   -- �ͻ���������
   --
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fcustomer_type_desc           varchar2(256),             -- ��ע
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
   constraint pk_p_customer_type primary key (fcustomer_type_id),
   constraint uk_p_customer_type_code unique (fcustomer_type_code)
);

--
-- ͬ���
--

insert into p_customer_type (FCUSTOMER_TYPE_ID, FCUSTOMER_TYPE_CODE, FCUSTOMER_TYPE_GBCODE, FCUSTOMER_TYPE_NAME, FISAVAILABLE, FORDERNUM, FCUSTOMER_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '����ͻ�', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_customer_type (FCUSTOMER_TYPE_ID, FCUSTOMER_TYPE_CODE, FCUSTOMER_TYPE_GBCODE, FCUSTOMER_TYPE_NAME, FISAVAILABLE, FORDERNUM, FCUSTOMER_TYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '���ѿͻ�', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit ;

