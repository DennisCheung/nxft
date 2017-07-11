--
-- �ͻ������ϵ��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_person_relation;
create Table  fxp.p_person_relation (
-- +-----------------------------+--------------+-----------+		
   fperson_relation_id           varchar2(32)   not null,   -- ��ϵ�˹�ϵID
   fperson_relation_code         varchar2(8)    not null,   -- ��ϵ�˹�ϵ����
   fperson_relation_gbcode       varchar2(32),              -- �������
   fperson_relation_name         varchar2(40)   not null,   -- ��ϵ�˹�ϵ����
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fperson_relation_desc         varchar2(256),             -- ��ע
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
   constraint pk_p_person_relation primary key (fperson_relation_id),
   constraint uk_p_person_relation_code unique (fperson_relation_code)
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

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '����', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '��Ů', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '��ϱ', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', 'Ů��', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '����', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', 'ֶ��', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- �ﱲ

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('10', '10', '10', '����', 'Y', 10, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('11', '11', '11', '��Ů', 'Y', 11, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

-- ����

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('20', '20', '20', '����', 'Y', 20, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('21', '21', '21', '�ھ�', 'Y', 21, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('22', '22', '22', '����', 'Y', 22, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('23', '23', '23', 'ս��', 'Y', 23, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('24', '24', '24', 'ͬѧ', 'Y', 24, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('25', '25', '25', '����', 'Y', 25, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_person_relation (FPERSON_RELATION_ID, FPERSON_RELATION_CODE, FPERSON_RELATION_GBCODE, FPERSON_RELATION_NAME, FISAVAILABLE, FORDERNUM, FPERSON_RELATION_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '����', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;