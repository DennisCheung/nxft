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
-- drop table fxp.p_health_state;
create table  fxp.p_health_state (
-- +-----------------------------+--------------+-----------+
   fhealth_state_id              varchar2(32)   not null,   -- ����״��ID
   fhealth_state_code            varchar2(8)    not null,   -- ����״������
   fhealth_state_gbcode          varchar2(32),              -- �������
   fhealth_state_name            varchar2(40)   not null,   -- ����״������
   fisavailable                  char(1)        not null,   -- �Ƿ���ã�
   fordernum                     number(6,2)    not null,   -- �����
   fhealth_state_desc            varchar2(256),             -- ��ע
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
   constraint pk_p_health_state primary key (fhealth_state_id),
   constraint uk_p_health_state_code unique (fhealth_state_code)
);

--
-- ͬ���
--

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('01', '01', '01', '����', 'Y', 1, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('02', '02', '02', 'һ��', 'Y', 2, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('03', '03', '03', '��', 'Y', 3, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('04', '04', '04', '�м�', 'Y', 4, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_health_state (FHEALTH_STATE_ID, FHEALTH_STATE_CODE, FHEALTH_STATE_GBCODE, FHEALTH_STATE_NAME, FISAVAILABLE, FORDERNUM, FHEALTH_STATE_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('05', '05', '05', '����', 'Y', 5, '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;