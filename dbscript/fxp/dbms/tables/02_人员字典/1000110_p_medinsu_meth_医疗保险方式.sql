--
-- ҽ�Ʊ��շ�ʽ��
--
-- v1.0 2015.01.12
-- author��wing
--
-- �޸���ʷ��
--
--
-- Drop Table fxp.p_medinsu_meth;
create Table  fxp.p_medinsu_meth (
-- +-----------------------------+--------------+-----------+		
   fmedinsu_meth_id              varchar2(32)   not null,   -- ҽ�Ʊ��շ�ʽid
   fmedinsu_meth_code            varchar2(30)   not null,   -- ҽ�Ʊ��շ�ʽ����
   fmedinsu_meth_gbcode          varchar2(32),              -- �������   
   fmedinsu_meth_name            varchar2(30)   not null,   -- ҽ�Ʊ��շ�ʽ  ����
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   --  
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fmedinsu_meth_desc            varchar2(256),             -- ��ע
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
   constraint pk_p_medinsu_meth primary key (fmedinsu_meth_id),
   constraint uk_p_medinsu_meth_code unique (fmedinsu_meth_code)
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

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', 'ְ��ҽ��', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '����ҽ��', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '����ҽ��', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '��ũ��', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '�Է�', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_medinsu_meth (FMEDINSU_METH_ID, FMEDINSU_METH_CODE, FMEDINSU_METH_GBCODE, FMEDINSU_METH_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FMEDINSU_METH_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '����', 'Y', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;

