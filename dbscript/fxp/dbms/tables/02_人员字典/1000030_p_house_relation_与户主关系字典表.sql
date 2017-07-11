--
-- �뻧����ϵ�ֵ��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_house_relation;
create Table  fxp.p_house_relation (
-- +-----------------------------+--------------+-----------+		
   fhouse_relation_id            varchar2(32)   not null,   -- ��ϵ�˹�ϵID
   fhouse_relation_code          varchar2(8)    not null,   -- ��ϵ�˹�ϵ����
   fhouse_relation_gbcode        varchar2(32),              -- �������
   fhouse_relation_name          varchar2(40)   not null,   -- ��ϵ�˹�ϵ����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fhouse_relation_desc          varchar2(256),             -- ��ע
   --                       
   -- ��־                  
   --                       
   fversion                      number(6)                  -- �汾��
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
   constraint pk_p_house_relation primary key (fhouse_relation_id),
   constraint uk_p_house_relation unique (fhouse_relation_code)
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

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '����', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '����', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '��Ů', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '��ĸ', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '����ĸ', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '�游ĸ', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('07', '07', '07', '���游ĸ', 'Y', 7, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('08', '08', '08', '�ֵ�', 'Y', 8, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('09', '09', '09', '����', 'Y', 9, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_house_relation (FHOUSE_RELATION_ID, FHOUSE_RELATION_CODE, FHOUSE_RELATION_GBCODE, FHOUSE_RELATION_NAME, FISAVAILABLE, FORDERNUM, FHOUSE_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '����', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


commit;

