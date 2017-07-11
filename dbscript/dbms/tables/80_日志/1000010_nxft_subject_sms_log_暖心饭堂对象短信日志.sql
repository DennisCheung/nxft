--
-- ů�ķ��ö��������־
--
-- v1.0 2017.06.12
-- author��wing
--
-- �޸���ʷ��
--
--
--
-- Drop Table nxft.nxft_subject_sms_log;
Create Table  nxft.nxft_subject_sms_log (
-- +-----------------------------+--------------+-----------+
   fsms_id                       varchar2(32)   not null,   -- ����id    
   --
   -- ͨѶ������
   --
   ftsp_name                     varchar2(30)   not null,   -- ͨѶ�������磺��֮Ѷ������ ЭͬͨѶ
   --
   -- ������Ϣ
   --
   fsubject_id                   varchar2(32)   not null,   -- ������ID   
   fsubject_name                 varchar2(50)   not null,   -- ��������
   fcircle_id                    varchar2(32)   not null,   -- �ͻ������Ĺ���Ȧid
   --
   -- ������Ϣ
   --
   fcreate_time                  date           not null,   -- ����ʱ��
   fsms_content                  varchar2(1000) not null,   -- ��������
   fsms_type                     varchar2(32)   not null,   -- ��������  TEXT  ���ֶ���  VOICE  ��������
   fsms_desc                     varchar2(256),             -- ҵ��˵��,�� ��ϯ���͡����͵㶩��   
   --
   -- ���Ž�����
   --
   fto_number                    varchar2(20)   not null,   -- �ͻ��绰����   
   fto_name                      varchar2(40)   not null,   -- ���Ž���������
   frelation_name                varchar2(30),              -- ������ϵname�����˻������ϵ�˹�ϵ         
   --
   -- ����Ա��Ϣ
   --
   fuser_circle_id               varchar2(32),              -- ����ԱȦid
   fuser_team_id                 varchar2(32),              -- ����Ա������id
   fuser_user_id                 varchar2(32)   not null,   -- ����Աid
   fuser_nickname                varchar2(40)   not null,   -- ����Ա����
-- +-----------------------------+--------------+-----------+
   --
   -- ��־
   --
   fversion                      number(6)                  -- �汾��
                                 default 0      not null,   
   --
   -- ������Ψһ��
   --
   constraint pk_nxft_subject_sms_log primary key (fsms_id)
);


--
-- ͬ���
--
--
-- ��Ȩ
--

-- 
--���� 
--
create index nxft.idx_nxft_subject_sms_log1 on nxft.nxft_subject_sms_log(fcreate_time);
create index nxft.idx_nxft_subject_sms_log2 on nxft.nxft_subject_sms_log(fsubject_id);
--
-- �޸���䣺
--
