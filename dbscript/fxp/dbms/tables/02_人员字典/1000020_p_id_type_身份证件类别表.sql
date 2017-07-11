--
-- ���֤������
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_id_type;
create Table fxp.p_id_type (
-- +-----------------------------+--------------+-----------+		
   fidtype_id                    varchar2(32)   not null,   -- ID
   fidtype_code                  varchar2(8)    not null,   -- ����
   fidtype_gbcode                varchar2(32),              -- �������
   fidtype_name                  varchar2(40)   not null,   -- ����
   --
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fidtype_desc                  varchar2(256),             -- ��ע      
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
   constraint pk_p_id_type primary key (fidtype_Id),
   constraint uk_p_id_type_code unique (fidtype_Code)
   );

--
-- ͬ���
--

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', '�������֤', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '�۰�ͨ��֤', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

insert into p_id_type (FIDTYPE_ID, FIDTYPE_CODE, FIDTYPE_GBCODE, FIDTYPE_NAME, FISAVAILABLE, FORDERNUM, FIDTYPE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '̨��֤֤', 'Y', 1.00, '', 0, 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'), 'admin', to_date('03-04-2015', 'dd-mm-yyyy'));

commit; 
