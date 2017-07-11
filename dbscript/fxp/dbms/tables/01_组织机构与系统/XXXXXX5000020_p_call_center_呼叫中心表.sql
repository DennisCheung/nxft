--
-- �������ı�
--
-- v1.0 2015.05.31
-- author��wing  
--
-- �޸���ʷ��
-- 
--
--
-- Drop Table fxp.p_call_center;
Create Table  fxp.p_call_center (
-- +-----------------------------+--------------+-----------+
   fcall_center_id               varchar2(32)   not null,   -- ��������id
   fcall_center_code             varchar2(32)   not null,   -- ��������code  
   fcall_center_name             varchar2(100)  not null,   -- ������������
   forg_id                       varchar2(32)   not null,   -- ����id
   fservice_num                  varchar2(20)   not null,   -- ͳһ�����绰����
   fcall_center_desc             varchar2(256),             -- ��ע
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
   constraint pk_p_call_center primary key (fcall_center_id),
   constraint uk_p_call_center_code unique (forg_id,fcall_center_code)
);

--
-- ͬ���
--
--
-- ��Ȩ
--

--
-- ����
--

--
-- �޸���䣺
--

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000101', '1000101', '��خ��������', '10001','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000102', '1000102', '����120��������', '10001','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );


insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000201', '1000201', '��ɽ˳�º�������', '10002','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

insert into p_call_center (FCALL_CENTER_ID, FCALL_CENTER_CODE, FCALL_CENTER_NAME, forg_id,fservice_num, FCALL_CENTER_DESC, FVERSION, FLOGCBY, FLOGCDATE, FLOGLUBY, FLOGLUDATE, FLOGLABY, FLOGLADATE )
values ('1000301', '1000301', '��ɽ��ˮ��������', '10003','4008517517', '', 0, 'admin', sysdate, 'admin', sysdate, 'admin', sysdate );

commit;

