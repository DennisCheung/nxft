--
-- �Ա��ֵ��
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_sex;
create Table fxp.p_sex (
-- +-----------------------------+--------------+-----------+		
   fsex_id                       varchar2(32)   not null,   -- ID
   fsex_code                     varchar2(8)    not null,   -- ����
   fsex_gbcode                   varchar2(32),              -- �������
   fsex_name                     varchar2(40)   not null,   -- ����
   --
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fsex_desc                     varchar2(256),             -- ��ע      
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
   constraint pk_p_sex primary key (fsex_id),
   constraint uk_p_sex_code unique (fsex_code)
   );

--
-- ͬ���
--

insert into p_sex (FSEX_ID, FSEX_CODE, FSEX_GBCODE, FSEX_NAME, FISAVAILABLE, FORDERNUM, FSEX_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1', '1', '1', '��', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_sex (FSEX_ID, FSEX_CODE, FSEX_GBCODE, FSEX_NAME, FISAVAILABLE, FORDERNUM, FSEX_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('2', '2', '2', 'Ů', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit ;