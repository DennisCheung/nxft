--
-- ����ϵ�ֵ�
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_family_relation;
create Table  fxp.p_family_relation (
-- +-----------------------------+--------------+-----------+		
   ffamily_relation_id           varchar2(32)   not null,   -- ��ͥ����ϵID
   ffamily_relation_code         varchar2(8)    not null,   -- ��ͥ����ϵ����
   ffamily_relation_gbcode       varchar2(32),              -- �������
   ffamily_relation_name         varchar2(40)   not null,   -- ��ͥ����ϵ����
   frelation_class               varchar2(20)   not null,   -- ��ϵ����  NEIGHBORHOOD ���� ��  SOCIETY ���
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   ffamily_relation_desc         varchar2(256),             -- ��ע
   --                       
   -- ��־                  
   --                       
  fversion                       number(6)                   -- �汾��
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
   constraint pk_p_family_relation primary key (ffamily_relation_id),
   constraint uk_p_family_relation unique (ffamily_relation_code)
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

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('01', '01', '01', 'ͬ��', 'NEIGHBORHOOD', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('02', '02', '02', '¥��', 'NEIGHBORHOOD', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('03', '03', '03', '¥��', 'NEIGHBORHOOD', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('04', '04', '04', '��ί��', 'NEIGHBORHOOD', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('05', '05', '05', '��ҵ����', 'NEIGHBORHOOD', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('06', '06', '06', '����/����', 'NEIGHBORHOOD', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('21', '21', '21', '��Ⱥ��ϵ��', 'SOCIETY', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);

insert into p_family_relation (FFAMILY_RELATION_ID, FFAMILY_RELATION_CODE, FFAMILY_RELATION_GBCODE, FFAMILY_RELATION_NAME, FRELATION_CLASS, FISAVAILABLE, FORDERNUM, FFAMILY_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE)
values ('22', '22', '22', '������ϵ��', 'SOCIETY', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate);


commit;

