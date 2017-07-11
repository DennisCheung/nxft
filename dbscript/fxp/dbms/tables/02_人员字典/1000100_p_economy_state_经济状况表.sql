--
-- ����״����
--
-- v1.0 2014.12.08
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- drop table fxp.p_economy_state;
create table  fxp.p_economy_state (
-- +-----------------------------+--------------+-----------+
   feconomy_state_id             varchar2(32)   not null,   -- ����״��ID
   feconomy_state_code           varchar2(8)    not null,   -- ����״������
   feconomy_state_gbcode         varchar2(32),              -- �������
   feconomy_state_name           varchar2(40)   not null,   -- ����״������
   fisother                      char(1)        not null,   -- �Ƿ��������� Y/N  ���������ֹ����뱸ע 
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   feconomy_state_desc           varchar2(256),             -- ��ע
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
   constraint pk_p_economy_state primary key (feconomy_state_id),
   constraint uk_p_economy_state_code unique (feconomy_state_code)
);

--
-- ͬ���
--
insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '��ְ', 'N', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', '����', 'N', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '����', 'N', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '��ҵ', 'N', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '�ͱ�', 'N', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('06', '06', '06', '����', 'N', 'Y', 6, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_economy_state (FECONOMY_STATE_ID, FECONOMY_STATE_CODE, FECONOMY_STATE_GBCODE, FECONOMY_STATE_NAME, FISOTHER, FISAVAILABLE, FORDERNUM, FECONOMY_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('99', '99', '99', '����', 'N', 'Y', 99, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;
