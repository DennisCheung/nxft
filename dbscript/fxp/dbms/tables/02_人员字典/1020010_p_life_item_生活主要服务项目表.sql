--
-- ������Ҫ������Ŀ�ֵ��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_life_item;
create Table  fxp.p_life_item (
-- +-----------------------------+--------------+-----------+		
   flife_item_id                 varchar2(32)   not null,   -- ������Ҫ������ĿID
   flife_item_code               varchar2(8)    not null,   -- ������Ҫ������Ŀ����
   flife_item_gbcode             varchar2(32),              -- �������
   flife_item_name               varchar2(60)   not null,   -- ������Ҫ������Ŀ����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   flife_item_desc               varchar2(256),             -- ��ע
   --                       
   -- ��־                  
   --                       
   fversion                      number(6)                   -- �汾��
                                 default 0       not null,
   flogcby                       varchar2(32)   not null,   -- ������
   flogcdate                     date           not null,   -- ����ʱ��
   flogluby                      varchar2(32)   not null,   -- ����޸���
   flogludate                    date           not null,   -- ����޸�ʱ��
   floglaby                      varchar2(32)   not null,   -- ��������
   flogladate                    date           not null,   -- ������ʱ��
   --
   -- ������Ψһ��
   --
   constraint pk_p_life_item primary key (flife_item_id),
   constraint uk_p_life_item unique (flife_item_code)
   );

--
-- ͬ���
--

--
-- �ⲿ��Լ��
--
--
-- ��Ȩ
--

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '��ķ', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '��������', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '��ú��', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '��ˮ', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '��������', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '������̯λ', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', 'ʿ���', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', '��ȥ�ĳ���', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('09', '09', '09', '����ά��', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_life_item (FLIFE_ITEM_ID, FLIFE_ITEM_CODE, FLIFE_ITEM_GBCODE, FLIFE_ITEM_NAME, FISAVAILABLE, FORDERNUM, FLIFE_ITEM_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('10', '10', '10', 'ˮ��ά��', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

commit;

