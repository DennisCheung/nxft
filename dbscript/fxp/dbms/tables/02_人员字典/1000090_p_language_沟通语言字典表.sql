--
-- ��ͨ�����ֵ��
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_language;
create Table  fxp.p_language (
-- +-----------------------------+--------------+-----------+		
   flanguage_id                  varchar2(32)   not null,   -- ID
   flanguage_code                varchar2(8)    not null,   -- ����
   flanguage_gbcode              varchar2(32),              -- �������
   flanguage_name                varchar2(40)   not null,   -- ����
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע
   --
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   flanguage_desc                varchar2(256),             -- ��ע      
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
   constraint pk_p_language primary key (flanguage_id),
   constraint uk_p_language_code unique (flanguage_code)
   );

--
-- ͬ���
--

insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '��ͨ��', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '���ػ�', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_language (FLANGUAGE_ID, FLANGUAGE_CODE, FLANGUAGE_GBCODE, FLANGUAGE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FLANGUAGE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '����', 'Y', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
